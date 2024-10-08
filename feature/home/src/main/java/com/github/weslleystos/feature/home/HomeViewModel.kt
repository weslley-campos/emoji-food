package com.github.weslleystos.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.weslleystos.feature.home.model.Product
import com.github.weslleystos.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class HomeViewModel @Inject constructor(
    navigator: Navigator
) : ViewModel(), Navigator by navigator {
    private val _uiState = MutableStateFlow(persistentListOf<Product>())
    val uiState = _uiState
        .onStart { loadProducts() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = persistentListOf()
        )

    private fun loadProducts() = viewModelScope.launch {
        delay(1.seconds.inWholeMilliseconds)
        _uiState.update { products }
    }

    private val products = persistentListOf(
        Product(name = "Apple", icon = "🍎", price = 2.50),
        Product(name = "Banana", icon = "🍌", price = 1.80),
        Product(name = "Pizza", icon = "🍕", price = 15.99),
        Product(name = "Hamburger", icon = "🍔", price = 8.50),
        Product(name = "Strawberry", icon = "🍓", price = 0.75),
        Product(name = "Sushi", icon = "🍣", price = 1.25),
        Product(name = "Avocado", icon = "🥑", price = 3.20),
        Product(name = "Taco", icon = "🌮", price = 4.50),
        Product(name = "Grapes", icon = "🍇", price = 0.20),
        Product(name = "Ice Cream", icon = "🍦", price = 3.99),
        Product(name = "Watermelon", icon = "🍉", price = 5.99),
        Product(name = "Carrot", icon = "🥕", price = 0.50),
        Product(name = "Croissant", icon = "🥐", price = 2.25),
        Product(name = "Peach", icon = "🍑", price = 1.75),
        Product(name = "Fried Chicken", icon = "🍗", price = 3.50),
        Product(name = "Burrito", icon = "🌯", price = 7.99),
        Product(name = "Pineapple", icon = "🍍", price = 4.50),
        Product(name = "Donut", icon = "🍩", price = 1.25),
        Product(name = "Lemon", icon = "🍋", price = 0.75),
        Product(name = "Popcorn", icon = "🍿", price = 3.50),
        Product(name = "Green Apple", icon = "🍏", price = 2.75),
        Product(name = "Tangerine", icon = "🍊", price = 1.00),
        Product(name = "Pear", icon = "🍐", price = 2.30),
        Product(name = "Cherries", icon = "🍒", price = 0.30),
        Product(name = "Kiwi Fruit", icon = "🥝", price = 1.50),
        Product(name = "Tomato", icon = "🍅", price = 0.90),
        Product(name = "Coconut", icon = "🥥", price = 4.00),
        Product(name = "Hot Pepper", icon = "🌶️", price = 0.40),
        Product(name = "Cucumber", icon = "🥒", price = 1.20),
        Product(name = "Leafy Green", icon = "🥬", price = 2.50),
        Product(name = "Broccoli", icon = "🥦", price = 2.00),
        Product(name = "Garlic", icon = "🧄", price = 0.60),
        Product(name = "Onion", icon = "🧅", price = 0.80),
        Product(name = "Mushroom", icon = "🍄", price = 1.80),
        Product(name = "Peanuts", icon = "🥜", price = 0.15),
        Product(name = "Bread", icon = "🍞", price = 3.50),
        Product(name = "Cheese", icon = "🧀", price = 5.50),
        Product(name = "Egg", icon = "🥚", price = 0.40),
        Product(name = "Butter", icon = "🧈", price = 4.20),
        Product(name = "Pancakes", icon = "🥞", price = 3.75),
        Product(name = "Waffle", icon = "🧇", price = 3.25),
        Product(name = "Bacon", icon = "🥓", price = 1.20),
        Product(name = "French Fries", icon = "🍟", price = 2.99),
        Product(name = "Hot Dog", icon = "🌭", price = 3.50),
        Product(name = "Sandwich", icon = "🥪", price = 6.50),
        Product(name = "Pretzel", icon = "🥨", price = 1.75),
        Product(name = "Bagel", icon = "🥯", price = 1.50),
        Product(name = "Falafel", icon = "🧆", price = 1.00),
        Product(name = "Ice", icon = "🧊", price = 2.00),
        Product(name = "Shaved Ice", icon = "🍧", price = 4.50)
    )
}
