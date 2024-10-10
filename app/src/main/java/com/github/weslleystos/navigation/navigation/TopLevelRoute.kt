package com.github.weslleystos.navigation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ReceiptLong
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.github.weslleystos.feature.orders.graph.OrdersGraph
import com.github.weslleystos.navigation.graph.HomeGraph
import com.github.weslleystos.navigation.graph.MainGraph

data class TopLevelRoute<T>(
    val name: String,
    val route: T,
    val icon: ImageVector
)

internal val topLevelRoutes = listOf(
    TopLevelRoute("Home", HomeGraph.HomeRoute, Icons.Outlined.Home),
    TopLevelRoute("Search", MainGraph.SearchRoute, Icons.Outlined.Search),
    TopLevelRoute("Orders", OrdersGraph.OrdersRoute, Icons.AutoMirrored.Outlined.ReceiptLong),
)
