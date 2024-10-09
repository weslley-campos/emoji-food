package com.github.weslleystos.feature.home.graph

import com.github.weslleystos.core.data.products.model.Product
import com.github.weslleystos.navigation.model.Destination
import kotlinx.serialization.Serializable

sealed class HomeGraph : Destination {
    @Serializable
    data object HomeRoute : HomeGraph()

    @Serializable
    data class ProductDetailRoute(val product: Product) : HomeGraph()
}
