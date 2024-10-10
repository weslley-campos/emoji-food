package com.github.weslleystos.feature.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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
import com.github.weslleystos.core.data.products.model.Product
import com.github.weslleystos.navigation.graph.HomeGraph
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val products by viewModel.queryState.collectAsStateWithLifecycle()
    val searchQuery by viewModel.savedSearchQuery.collectAsStateWithLifecycle()
    SearchScreen(
        searchQuery = searchQuery,
        products = products,
        onSearchQueryChanged = viewModel::updateSearchQuery,
        onItemClicked = {
            viewModel.tryNavigateTo(HomeGraph.ProductDetailRoute(it))
        },
        modifier = modifier
    )
}

@Composable
fun SearchScreen(
    searchQuery: String,
    products: ImmutableList<Product>,
    onItemClicked: (Product) -> Unit,
    onSearchQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            SearchProduct(
                searchQuery = searchQuery,
                onSearchQueryChanged = onSearchQueryChanged,
                modifier = Modifier.padding(16.dp)
            )
        },
        modifier = modifier
            .windowInsetsPadding(WindowInsets.displayCutout)
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(items = products) { product ->
                ProductItem(
                    product = product,
                    modifier = Modifier.clickable {
                        onItemClicked.invoke(product)
                    }
                )
            }
        }
    }
}

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = product.icon,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        Column {
            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                product.category,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "$${"%.2f".format(product.price)}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun SearchProduct(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = searchQuery,
        onValueChange = { value ->
            onSearchQueryChanged(value)
        },
        modifier = modifier
            .fillMaxWidth(),
        placeholder = { Text("Search...") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        trailingIcon = {
            if (searchQuery.isNotEmpty()) {
                IconButton(
                    onClick = {
                        onSearchQueryChanged("")
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear search query"
                    )
                }
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    MaterialTheme {
        SearchScreen(
            searchQuery = "",
            products = persistentListOf(
                Product(
                    name = "Watermelon",
                    icon = "🍉",
                    price = 5.99,
                    category = "Fruits"
                ),
                Product(
                    name = "Sushi",
                    icon = "🍣",
                    price = 1.25,
                    category = "Asian Food"
                ),
                Product(
                    name = "Coffee",
                    icon = "☕",
                    price = 2.50,
                    category = "Drinks"
                )
            ),
            onSearchQueryChanged = {},
            onItemClicked = {}
        )
    }
}
