package com.github.weslleystos.feature.orders.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.github.weslleystos.feature.orders.graph.OrdersGraph.OrderDetailRoute
import com.github.weslleystos.feature.orders.model.Order
import com.github.weslleystos.navigation.Navigator
import com.github.weslleystos.navigation.utils.mapParcelableType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class OrderDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    navigator: Navigator
) : ViewModel(), Navigator by navigator {
    private val order = savedStateHandle
        .toRoute<OrderDetailRoute>(mapParcelableType<Order>())
        .order
    private val _uiState = MutableStateFlow(order)
    val uiState = _uiState.asStateFlow()
}
