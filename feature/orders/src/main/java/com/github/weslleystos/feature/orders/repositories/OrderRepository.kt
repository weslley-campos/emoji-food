package com.github.weslleystos.feature.orders.repositories

import com.github.weslleystos.feature.orders.model.Order
import com.github.weslleystos.feature.orders.model.ProductOrder
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import javax.inject.Inject

interface OrderRepository {
    suspend fun getOrders(): ImmutableList<Order>
}

class OrderRepositoryImpl @Inject constructor() : OrderRepository {
    override suspend fun getOrders() = persistentListOf(
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
        ),
        Order(
            product = ProductOrder(
                name = "Hamburger",
                icon = "🍔",
                price = 8.50,
                category = "Fast Food"
            ),
            quantity = 4
        ),
        Order(
            product = ProductOrder(
                name = "Avocado",
                icon = "🥑",
                price = 3.20,
                category = "Vegetables"
            ),
            quantity = 6
        ),
        Order(
            product = ProductOrder(
                name = "Ice Cream",
                icon = "🍦",
                price = 3.99,
                category = "Desserts"
            ),
            quantity = 3
        ),
        Order(
            product = ProductOrder(
                name = "Taco",
                icon = "🌮",
                price = 4.50,
                category = "Mexican Food"
            ),
            quantity = 7
        ),
        Order(
            product = ProductOrder(
                name = "Croissant",
                icon = "🥐",
                price = 2.25,
                category = "Bakery"
            ),
            quantity = 10
        ),
        Order(
            product = ProductOrder(name = "Steak", icon = "🥩", price = 22.99, category = "Meals"),
            quantity = 2
        ),
        Order(
            product = ProductOrder(
                name = "Bubble Tea",
                icon = "🧋",
                price = 5.50,
                category = "Drinks"
            ),
            quantity = 5
        ),
        Order(
            product = ProductOrder(
                name = "Spaghetti",
                icon = "🍝",
                price = 10.99,
                category = "Meals"
            ),
            quantity = 3
        ),
        Order(
            product = ProductOrder(
                name = "Donut",
                icon = "🍩",
                price = 1.25,
                category = "Desserts"
            ),
            quantity = 12
        ),
        Order(
            product = ProductOrder(
                name = "Broccoli",
                icon = "🥦",
                price = 2.00,
                category = "Vegetables"
            ),
            quantity = 4
        ),
        Order(
            product = ProductOrder(
                name = "Pizza",
                icon = "🍕",
                price = 15.99,
                category = "Fast Food"
            ),
            quantity = 2
        ),
        Order(
            product = ProductOrder(
                name = "Coconut Water",
                icon = "🥥",
                price = 4.25,
                category = "Drinks"
            ),
            quantity = 6
        ),
        Order(
            product = ProductOrder(
                name = "Pancakes",
                icon = "🥞",
                price = 3.75,
                category = "Breakfast"
            ),
            quantity = 4
        ),
        Order(
            product = ProductOrder(
                name = "Shrimp",
                icon = "🦐",
                price = 18.50,
                category = "Seafood"
            ),
            quantity = 2
        ),
        Order(
            product = ProductOrder(
                name = "Popcorn",
                icon = "🍿",
                price = 3.50,
                category = "Snacks"
            ),
            quantity = 3
        ),
        Order(
            product = ProductOrder(
                name = "Curry Rice",
                icon = "🍛",
                price = 9.50,
                category = "Asian Food"
            ),
            quantity = 2
        ),
        Order(
            product = ProductOrder(
                name = "Chocolate Bar",
                icon = "🍫",
                price = 2.50,
                category = "Desserts"
            ),
            quantity = 5
        ),
        Order(
            product = ProductOrder(name = "Salad", icon = "🥗", price = 7.99, category = "Meals"),
            quantity = 3
        ),
        Order(
            product = ProductOrder(
                name = "Pretzel",
                icon = "🥨",
                price = 1.75,
                category = "Bakery"
            ),
            quantity = 8
        ),
        Order(
            product = ProductOrder(name = "Lemon", icon = "🍋", price = 0.75, category = "Fruits"),
            quantity = 10
        ),
        Order(
            product = ProductOrder(
                name = "Fried Chicken",
                icon = "🍗",
                price = 3.50,
                category = "Meals"
            ),
            quantity = 6
        ),
        Order(
            product = ProductOrder(
                name = "Macaron",
                icon = "🍪",
                price = 2.25,
                category = "Desserts"
            ),
            quantity = 15
        ),
        Order(
            product = ProductOrder(
                name = "Hot Dog",
                icon = "🌭",
                price = 3.50,
                category = "Fast Food"
            ),
            quantity = 5
        ),
        Order(
            product = ProductOrder(
                name = "Green Apple",
                icon = "🍏",
                price = 2.75,
                category = "Fruits"
            ),
            quantity = 7
        ),
        Order(
            product = ProductOrder(
                name = "Ramen",
                icon = "🍜",
                price = 8.75,
                category = "Asian Food"
            ),
            quantity = 3
        ),
        Order(
            product = ProductOrder(
                name = "Cheese",
                icon = "🧀",
                price = 5.50,
                category = "Condiments and Ingredients"
            ),
            quantity = 2
        ),
        Order(
            product = ProductOrder(
                name = "Falafel",
                icon = "🧆",
                price = 1.00,
                category = "Middle Eastern"
            ),
            quantity = 10
        )
    )
}
