package com.github.weslleystos.feature.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.weslleystos.core.data.products.ProductRepository
import com.github.weslleystos.core.data.products.model.Product
import com.github.weslleystos.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    navigator: Navigator,
    private val savedStateHandle: SavedStateHandle,
    private val productRepository: ProductRepository
) : ViewModel(), Navigator by navigator {
    private val _queryState = MutableStateFlow<ImmutableList<Product>>(persistentListOf())
    val queryState = _queryState.asStateFlow()

    val savedSearchQuery = savedStateHandle.getStateFlow(SEARCH_QUERY, "")
        .onEach {
            searchProducts(it)
        }
        .stateIn(
            initialValue = "",
            scope = viewModelScope,
            started = SharingStarted.Lazily
        )

    fun updateSearchQuery(query: String) {
        savedStateHandle[SEARCH_QUERY] = query.lowercase()
    }

    private fun searchProducts(query: String) = viewModelScope.launch {
        when {
            query.isEmpty() -> {
                _queryState.update { persistentListOf() }
            }

            else -> {
                val products = productRepository.getProducts()
                val result = products.filter {
                    it.name.lowercase().contains(query) || it.category.lowercase().contains(query)
                }.toImmutableList()
                _queryState.update { result }
            }
        }
    }

    companion object {
        const val SEARCH_QUERY = "SEARCH_QUERY"
    }
}
