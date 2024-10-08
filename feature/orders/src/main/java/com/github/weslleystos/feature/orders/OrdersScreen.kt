package com.github.weslleystos.feature.orders

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.weslleystos.feature.orders.graph.OrdersGraph.OrderDetailRoute
import com.github.weslleystos.feature.orders.model.Order
import com.github.weslleystos.feature.orders.model.ProductOrder
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun OrdersRoute(
    modifier: Modifier = Modifier,
    viewModel: OrdersViewModel = hiltViewModel()
) {
    val orders by viewModel.uiState.collectAsStateWithLifecycle()
    OrdersScreen(
        orders = orders,
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
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.displayCutout)
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
            text = order.product.icon,
            fontSize = 24.sp,
            modifier = Modifier.padding(end = 16.dp)
        )
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = order.product.name,
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
                    text = "price: $${"%.2f".format(order.product.price)}",
                    fontSize = 16.sp
                )
                Text(
                    text = "total: $${"%.2f".format(order.product.price * order.quantity)}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OrdersScreenPreview() {
    MaterialTheme {
        OrdersScreen(
            orders = persistentListOf(
                Order(
                    product = ProductOrder(
                        name = "Watermelon",
                        icon = "🍉",
                        price = 5.99,
                        category = "Fruits"
                    ),
                    quantity = 2
                ),
                Order(
                    product = ProductOrder(
                        name = "Sushi",
                        icon = "🍣",
                        price = 1.25,
                        category = "Asian Food"
                    ),
                    quantity = 15
                ),
                Order(
                    product = ProductOrder(
                        name = "Coffee",
                        icon = "☕",
                        price = 2.50,
                        category = "Drinks"
                    ),
                    quantity = 8
                )
            ),
            onItemClicked = {}
        )
    }
}
