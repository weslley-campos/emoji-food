package com.github.weslleystos.feature.orders.graph

import com.github.weslleystos.feature.orders.model.Order
import com.github.weslleystos.navigation.model.Destination
import kotlinx.serialization.Serializable

sealed class OrdersGraph : Destination {
    @Serializable
    data object OrdersRoute : OrdersGraph()

    @Serializable
    data class OrderDetailRoute(val order: Order) : OrdersGraph()
}
