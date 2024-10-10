package com.github.weslleystos.navigation.graph

import com.github.weslleystos.navigation.model.Destination
import kotlinx.serialization.Serializable

sealed class MainGraph : Destination {
    @Serializable
    data object SplashRoute : MainGraph()

    @Serializable
    data object AuthGraph : MainGraph()

    @Serializable
    data object HomeGraph : MainGraph()

    @Serializable
    data object SearchRoute : MainGraph()

    @Serializable
    data object OrdersGraph : MainGraph()

    @Serializable
    data object ProfileGraph : MainGraph()
}
