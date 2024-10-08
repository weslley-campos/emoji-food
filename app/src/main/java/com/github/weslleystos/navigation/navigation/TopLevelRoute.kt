package com.github.weslleystos.navigation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ReceiptLong
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.github.weslleystos.feature.home.graph.HomeGraph
import com.github.weslleystos.feature.orders.graph.OrdersGraph

data class TopLevelRoute<T>(
    val name: String,
    val route: T,
    val icon: ImageVector
)

internal val topLevelRoutes = listOf(
    TopLevelRoute("Home", HomeGraph.HomeRoute, Icons.Outlined.Home),
    TopLevelRoute("Orders", OrdersGraph.OrdersRoute, Icons.AutoMirrored.Outlined.ReceiptLong),
)
