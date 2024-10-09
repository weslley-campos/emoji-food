package com.github.weslleystos.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.weslleystos.core.data.products.ProductRepository
import com.github.weslleystos.core.data.products.model.Product
import com.github.weslleystos.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class HomeViewModel @Inject constructor(
    navigator: Navigator,
    private val productRepository: ProductRepository
) : ViewModel(), Navigator by navigator {
    private val _uiState = MutableStateFlow<ImmutableList<Product>>(persistentListOf())
    val uiState = _uiState
        .onStart { loadProducts() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = persistentListOf()
        )

    private fun loadProducts() = viewModelScope.launch {
        delay(1.seconds.inWholeMilliseconds)
        _uiState.update { productRepository.getProducts() }
    }
}
