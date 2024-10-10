package com.github.weslleystos.navigation.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import com.github.weslleystos.core.data.products.model.Product
import com.github.weslleystos.feature.home.HomeRoute
import com.github.weslleystos.feature.home.productdetail.ProductDetailRoute
import com.github.weslleystos.feature.orders.OrdersRoute
import com.github.weslleystos.feature.orders.details.OrderDetailRoute
import com.github.weslleystos.feature.orders.graph.OrdersGraph
import com.github.weslleystos.feature.orders.model.Order
import com.github.weslleystos.feature.search.SearchRoute
import com.github.weslleystos.navigation.graph.HomeGraph
import com.github.weslleystos.navigation.graph.MainGraph
import com.github.weslleystos.navigation.model.Destination
import com.github.weslleystos.navigation.ui.splashscreen.SplashRoute
import com.github.weslleystos.navigation.utils.mapParcelableType
import com.github.weslleystos.navigation.utils.mapSerializableType

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: Destination,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable<MainGraph.SplashRoute> {
            SplashRoute()
        }

        navigation<MainGraph.HomeGraph>(
            startDestination = HomeGraph.HomeRoute
        ) {
            composable<HomeGraph.HomeRoute> {
                HomeRoute()
            }

            composable<HomeGraph.ProductDetailRoute>(
                typeMap = mapSerializableType<Product>()
            ) { backStackEntry ->
                val product = backStackEntry.toRoute<HomeGraph.ProductDetailRoute>().product
                ProductDetailRoute(product)
            }
        }

        composable<MainGraph.SearchRoute> {
            SearchRoute()
        }

        navigation<MainGraph.OrdersGraph>(
            startDestination = OrdersGraph.OrdersRoute
        ) {
            composable<OrdersGraph.OrdersRoute> {
                OrdersRoute()
            }
            composable<OrdersGraph.OrderDetailRoute>(
                typeMap = mapParcelableType<Order>()
            ) {
                OrderDetailRoute()
            }
        }
    }
}
