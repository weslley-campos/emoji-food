package com.github.weslleystos.feature.orders.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.weslleystos.feature.orders.model.Order
import com.github.weslleystos.feature.orders.model.ProductOrder

@Composable
fun OrderDetailRoute(
    modifier: Modifier = Modifier,
    viewModel: OrderDetailViewModel = hiltViewModel()
) {
    val order by viewModel.uiState.collectAsStateWithLifecycle()
    OrdersDetailScreen(
        order = order,
        onNavigateBack = viewModel::tryNavigateUp,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdersDetailScreen(
    order: Order,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    onUpdateQuantity: (Int) -> Unit = {}
) {
    var quantity by remember { mutableIntStateOf(order.quantity) }
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Order Details") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = order.product.icon,
                    fontSize = 48.sp,
                    modifier = Modifier.padding(end = 16.dp)
                )
                Column {
                    Text(
                        text = order.product.name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Category: ${order.product.category}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Price: $${"%.2f".format(order.product.price)}", fontSize = 18.sp)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Quantity:", fontSize = 18.sp)
                Spacer(modifier = Modifier.width(8.dp))
                TextButton(onClick = { if (quantity > 1) quantity-- }) {
                    Text("-", fontSize = 16.sp)
                }
                Text(
                    text = quantity.toString(),
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontSize = 18.sp
                )
                TextButton(onClick = { quantity++ }) {
                    Text("+", fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Total: $${"%.2f".format(order.product.price * quantity)}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { onUpdateQuantity(quantity) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Update Order")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OrdersDetailScreenPreview() {
    MaterialTheme {
        OrdersDetailScreen(
            order = Order(
                product = ProductOrder(
                    name = "Coffee",
                    icon = "☕",
                    price = 2.50,
                    category = "Drinks"
                ),
                quantity = 8
            ),
            onNavigateBack = {}
        )
    }
}
