package com.github.weslleystos.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.weslleystos.feature.home.graph.HomeGraph.ProductDetailRoute
import com.github.weslleystos.feature.home.model.Product
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val products by viewModel.uiState.collectAsStateWithLifecycle()
    HomeScreen(
        products = products,
        navigateTo = viewModel::tryNavigateTo,
        modifier = modifier
    )
}

@Composable
fun HomeScreen(
    products: ImmutableList<Product>,
    navigateTo: (ProductDetailRoute) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier
            .windowInsetsPadding(WindowInsets.displayCutout)
    ) {
        items(products) { product ->
            ProductCard(
                product = product,
                modifier = Modifier.clickable {
                    navigateTo.invoke(ProductDetailRoute(product))
                }
            )
        }
    }
}

@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp),
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = product.icon,
                fontSize = 48.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = "$${"%.2f".format(product.price)}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductGridPreview() {
    MaterialTheme {
        val sampleProducts = persistentListOf(
            Product("Apple", "🍎", 2.50),
            Product("Banana", "🍌", 1.80),
            Product("Pizza", "🍕", 15.99),
            Product("Hamburger", "🍔", 8.50),
            Product("Strawberry", "🍓", 0.75),
            Product("Sushi", "🍣", 1.25)
        )
        HomeScreen(sampleProducts, {})
    }
}
