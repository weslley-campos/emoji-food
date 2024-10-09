package com.github.weslleystos.feature.home.productdetail

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
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.weslleystos.core.data.products.model.Product

@Composable
fun ProductDetailRoute(
    product: Product,
    modifier: Modifier = Modifier,
    viewModel: ProductDetailViewModel = hiltViewModel()
) {
    ProductDetailScreen(
        product = product,
        onNavigateBack = viewModel::tryNavigateUp,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    product: Product,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    onAddToCart: (Product, Int) -> Unit = { _, _ -> },
) {
    var quantity by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Product Details") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Filled.ArrowBackIosNew, contentDescription = "Back")
                    }
                }
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = product.icon,
                    fontSize = 72.sp,
                    modifier = Modifier.padding(end = 16.dp)
                )
                Column {
                    Text(
                        text = product.name,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "Category: ${product.category}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Price: $${"%.2f".format(product.price)}", fontSize = 18.sp)

            Spacer(modifier = Modifier.height(24.dp))

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

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Total: $${"%.2f".format(product.price * quantity)}",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { onAddToCart(product, quantity) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    Icons.Filled.ShoppingCart,
                    contentDescription = "Shopping Cart",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text("Add to Cart")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailScreenPreview() {
    val sampleProduct = Product("Apple", "🍎", "Fruit", 2.50)
    ProductDetailScreen(
        product = sampleProduct,
        onNavigateBack = {},
    )
}
