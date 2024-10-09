package com.github.weslleystos.feature.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.weslleystos.feature.orders.model.Order
import com.github.weslleystos.feature.orders.repositories.OrderRepository
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
class OrdersViewModel @Inject constructor(
    navigator: Navigator,
    private val orderRepository: OrderRepository
) : ViewModel(), Navigator by navigator {
    private val _uiState = MutableStateFlow<ImmutableList<Order>>(persistentListOf())
    val uiState = _uiState
        .onStart { loadOrders() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = persistentListOf()
        )

    private fun loadOrders() = viewModelScope.launch {
        delay(1.seconds.inWholeMilliseconds)
        _uiState.update { orderRepository.getOrders() }
    }
}
