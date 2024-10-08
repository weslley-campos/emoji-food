package com.github.weslleystos.feature.orders

import androidx.lifecycle.ViewModel
import com.github.weslleystos.feature.orders.model.Order
import com.github.weslleystos.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.persistentListOf
import javax.inject.Inject

@HiltViewModel
class OrdersViewModel @Inject constructor(
    navigator: Navigator
) : ViewModel(), Navigator by navigator {
    val orderList = persistentListOf(
        Order(name = "Apple", icon = "🍎", quantity = 5, price = 2.50),
        Order(name = "Banana", icon = "🍌", quantity = 6, price = 1.80),
        Order(name = "Pizza", icon = "🍕", quantity = 2, price = 15.99),
        Order(name = "Hamburger", icon = "🍔", quantity = 3, price = 8.50),
        Order(name = "Strawberry", icon = "🍓", quantity = 20, price = 0.75),
        Order(name = "Sushi", icon = "🍣", quantity = 12, price = 1.25),
        Order(name = "Avocado", icon = "🥑", quantity = 4, price = 3.20),
        Order(name = "Taco", icon = "🌮", quantity = 5, price = 4.50),
        Order(name = "Grapes", icon = "🍇", quantity = 30, price = 0.20),
        Order(name = "Ice Cream", icon = "🍦", quantity = 2, price = 3.99),
        Order(name = "Watermelon", icon = "🍉", quantity = 1, price = 5.99),
        Order(name = "Carrot", icon = "🥕", quantity = 10, price = 0.50),
        Order(name = "Croissant", icon = "🥐", quantity = 4, price = 2.25),
        Order(name = "Peach", icon = "🍑", quantity = 7, price = 1.75),
        Order(name = "Fried Chicken", icon = "🍗", quantity = 8, price = 3.50),
        Order(name = "Burrito", icon = "🌯", quantity = 3, price = 7.99),
        Order(name = "Pineapple", icon = "🍍", quantity = 2, price = 4.50),
        Order(name = "Donut", icon = "🍩", quantity = 6, price = 1.25),
        Order(name = "Lemon", icon = "🍋", quantity = 8, price = 0.75),
        Order(name = "Popcorn", icon = "🍿", quantity = 3, price = 3.50)
    )
}
