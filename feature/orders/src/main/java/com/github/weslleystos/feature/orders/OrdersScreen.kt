package com.github.weslleystos.feature.orders

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.weslleystos.feature.orders.graph.OrdersGraph.OrderDetailRoute
import com.github.weslleystos.feature.orders.model.Order
import kotlinx.collections.immutable.ImmutableList

@Composable
fun OrdersRoute(
    modifier: Modifier = Modifier,
    viewModel: OrdersViewModel = hiltViewModel()
) {
    OrdersScreen(
        orders = viewModel.orderList,
        onItemClicked = {
            viewModel.tryNavigateTo(OrderDetailRoute(it))
        },
        modifier = modifier
    )
}

@Composable
fun OrdersScreen(
    orders: ImmutableList<Order>,
    onItemClicked: (Order) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.displayCutout)
                .consumeWindowInsets(innerPadding)
        ) {
            items(items = orders) { order ->
                OrderItem(
                    order = order,
                    modifier = Modifier.clickable {
                        onItemClicked.invoke(order)
                    }
                )
            }
        }
    }
}

@Composable
fun OrderItem(
    order: Order,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = order.icon,
            fontSize = 24.sp,
            modifier = Modifier.padding(end = 16.dp)
        )
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = order.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "quantity: ${order.quantity}",
                    fontSize = 16.sp
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "price: $${"%.2f".format(order.price)}",
                    fontSize = 16.sp
                )
                Text(
                    text = "total: $${"%.2f".format(order.price * order.quantity)}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}
