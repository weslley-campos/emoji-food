package com.github.weslleystos.core.data.products

import com.github.weslleystos.core.data.products.model.Product
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import javax.inject.Inject

interface ProductRepository {
    suspend fun getProducts(): ImmutableList<Product>
}

class ProductRepositoryImpl @Inject constructor() : ProductRepository {
    override suspend fun getProducts(): ImmutableList<Product> {
        return persistentListOf(
            // Fruits
            Product(name = "Apple", icon = "🍎", price = 2.50, category = "Fruits"),
            Product(name = "Banana", icon = "🍌", price = 1.80, category = "Fruits"),
            Product(name = "Strawberry", icon = "🍓", price = 0.75, category = "Fruits"),
            Product(name = "Grapes", icon = "🍇", price = 0.20, category = "Fruits"),
            Product(name = "Watermelon", icon = "🍉", price = 5.99, category = "Fruits"),
            Product(name = "Peach", icon = "🍑", price = 1.75, category = "Fruits"),
            Product(name = "Pineapple", icon = "🍍", price = 4.50, category = "Fruits"),
            Product(name = "Lemon", icon = "🍋", price = 0.75, category = "Fruits"),
            Product(name = "Green Apple", icon = "🍏", price = 2.75, category = "Fruits"),
            Product(name = "Tangerine", icon = "🍊", price = 1.00, category = "Fruits"),
            Product(name = "Pear", icon = "🍐", price = 2.30, category = "Fruits"),
            Product(name = "Cherries", icon = "🍒", price = 0.30, category = "Fruits"),
            Product(name = "Kiwi Fruit", icon = "🥝", price = 1.50, category = "Fruits"),
            Product(name = "Coconut", icon = "🥥", price = 4.00, category = "Fruits"),
            // Vegetables
            Product(name = "Avocado", icon = "🥑", price = 3.20, category = "Vegetables"),
            Product(name = "Carrot", icon = "🥕", price = 0.50, category = "Vegetables"),
            Product(name = "Tomato", icon = "🍅", price = 0.90, category = "Vegetables"),
            Product(name = "Hot Pepper", icon = "🌶️", price = 0.40, category = "Vegetables"),
            Product(name = "Cucumber", icon = "🥒", price = 1.20, category = "Vegetables"),
            Product(name = "Leafy Green", icon = "🥬", price = 2.50, category = "Vegetables"),
            Product(name = "Broccoli", icon = "🥦", price = 2.00, category = "Vegetables"),
            Product(name = "Garlic", icon = "🧄", price = 0.60, category = "Vegetables"),
            Product(name = "Onion", icon = "🧅", price = 0.80, category = "Vegetables"),
            Product(name = "Mushroom", icon = "🍄", price = 1.80, category = "Vegetables"),
            Product(name = "Eggplant", icon = "🍆", price = 2.25, category = "Vegetables"),
            Product(name = "Bell Pepper", icon = "🫑", price = 1.75, category = "Vegetables"),
            Product(name = "Corn", icon = "🌽", price = 1.50, category = "Vegetables"),
            Product(name = "Potato", icon = "🥔", price = 0.90, category = "Vegetables"),
            Product(name = "Sweet Potato", icon = "🍠", price = 1.80, category = "Vegetables"),
            // Fast Food
            Product(name = "Pizza", icon = "🍕", price = 15.99, category = "Fast Food"),
            Product(name = "Hamburger", icon = "🍔", price = 8.50, category = "Fast Food"),
            Product(name = "French Fries", icon = "🍟", price = 2.99, category = "Fast Food"),
            Product(name = "Hot Dog", icon = "🌭", price = 3.50, category = "Fast Food"),
            // Asian Food
            Product(name = "Sushi", icon = "🍣", price = 1.25, category = "Asian Food"),
            Product(name = "Dumplings", icon = "🥟", price = 6.50, category = "Asian Food"),
            Product(name = "Spring Roll", icon = "🥢", price = 3.75, category = "Asian Food"),
            Product(name = "Fried Rice", icon = "🍚", price = 8.50, category = "Asian Food"),
            Product(name = "Tempura", icon = "🍤", price = 9.99, category = "Asian Food"),
            Product(name = "Pad Thai", icon = "🍜", price = 11.50, category = "Asian Food"),
            Product(name = "Bibimbap", icon = "🍲", price = 12.75, category = "Asian Food"),
            Product(name = "Ramen", icon = "🍜", price = 8.75, category = "Asian Food"),
            Product(name = "Curry Rice", icon = "🍛", price = 9.50, category = "Asian Food"),
            // Mexican Food
            Product(name = "Taco", icon = "🌮", price = 4.50, category = "Mexican Food"),
            Product(name = "Burrito", icon = "🌯", price = 7.99, category = "Mexican Food"),
            Product(name = "Tamale", icon = "🫔", price = 5.75, category = "Mexican Food"),
            // Bakery
            Product(name = "Croissant", icon = "🥐", price = 2.25, category = "Bakery"),
            Product(name = "Bread", icon = "🍞", price = 3.50, category = "Bakery"),
            Product(name = "Baguette", icon = "🥖", price = 2.75, category = "Bakery"),
            Product(name = "Pretzel", icon = "🥨", price = 1.75, category = "Bakery"),
            Product(name = "Bagel", icon = "🥯", price = 1.50, category = "Bakery"),
            // Desserts and Sweet Treats
            Product(name = "Ice Cream", icon = "🍦", price = 3.99, category = "Desserts"),
            Product(name = "Donut", icon = "🍩", price = 1.25, category = "Desserts"),
            Product(name = "Cake", icon = "🍰", price = 18.99, category = "Desserts"),
            Product(name = "Cupcake", icon = "🧁", price = 2.75, category = "Desserts"),
            Product(name = "Pie", icon = "🥧", price = 12.99, category = "Desserts"),
            Product(name = "Chocolate Bar", icon = "🍫", price = 2.50, category = "Desserts"),
            Product(name = "Lollipop", icon = "🍭", price = 1.00, category = "Desserts"),
            Product(name = "Candy", icon = "🍬", price = 1.25, category = "Desserts"),
            Product(name = "Custard", icon = "🍮", price = 4.50, category = "Desserts"),
            Product(name = "Honey", icon = "🍯", price = 5.99, category = "Desserts"),
            Product(name = "Dango", icon = "🍡", price = 3.75, category = "Desserts"),
            Product(name = "Fortune Cookie", icon = "🥠", price = 0.50, category = "Desserts"),
            Product(name = "Macaron", icon = "🍪", price = 2.25, category = "Desserts"),
            Product(name = "Gelato", icon = "🍨", price = 4.75, category = "Desserts"),
            Product(name = "Shaved Ice", icon = "🍧", price = 4.50, category = "Desserts"),
            // Snacks
            Product(name = "Popcorn", icon = "🍿", price = 3.50, category = "Snacks"),
            Product(name = "Peanuts", icon = "🥜", price = 0.15, category = "Snacks"),
            Product(name = "Potato Chips", icon = "🥔", price = 2.50, category = "Snacks"),
            Product(name = "Nachos", icon = "🧀", price = 5.99, category = "Snacks"),
            Product(name = "Crackers", icon = "🍘", price = 2.25, category = "Snacks"),
            Product(name = "Rice Cracker", icon = "🍘", price = 2.00, category = "Snacks"),
            Product(name = "Mochi", icon = "🍙", price = 3.25, category = "Snacks"),
            // Drinks
            Product(name = "Coffee", icon = "☕", price = 2.50, category = "Drinks"),
            Product(name = "Tea", icon = "🍵", price = 2.00, category = "Drinks"),
            Product(name = "Milk", icon = "🥛", price = 1.75, category = "Drinks"),
            Product(name = "Beer", icon = "🍺", price = 4.50, category = "Drinks"),
            Product(name = "Wine", icon = "🍷", price = 8.99, category = "Drinks"),
            Product(name = "Cocktail", icon = "🍸", price = 9.50, category = "Drinks"),
            Product(name = "Tropical Drink", icon = "🍹", price = 7.50, category = "Drinks"),
            Product(name = "Sake", icon = "🍶", price = 6.50, category = "Drinks"),
            Product(name = "Champagne", icon = "🍾", price = 25.99, category = "Drinks"),
            Product(name = "Whiskey", icon = "🥃", price = 12.50, category = "Drinks"),
            Product(name = "Bubble Tea", icon = "🧋", price = 5.50, category = "Drinks"),
            Product(name = "Soda", icon = "🥤", price = 2.25, category = "Drinks"),
            Product(name = "Mate", icon = "🧉", price = 3.50, category = "Drinks"),
            Product(name = "Coconut Water", icon = "🥥", price = 4.25, category = "Drinks"),
            // Meals
            Product(name = "Fried Chicken", icon = "🍗", price = 3.50, category = "Meals"),
            Product(name = "Spaghetti", icon = "🍝", price = 10.99, category = "Meals"),
            Product(name = "Steak", icon = "🥩", price = 22.99, category = "Meals"),
            Product(name = "Roast Chicken", icon = "🍗", price = 14.50, category = "Meals"),
            Product(name = "Salad", icon = "🥗", price = 7.99, category = "Meals"),
            Product(name = "Bento Box", icon = "🍱", price = 12.50, category = "Meals"),
            Product(name = "Paella", icon = "🥘", price = 16.99, category = "Meals"),
            Product(name = "Fondue", icon = "🫕", price = 20.50, category = "Meals"),
            // Breakfast
            Product(name = "Pancakes", icon = "🥞", price = 3.75, category = "Breakfast"),
            Product(name = "Waffle", icon = "🧇", price = 3.25, category = "Breakfast"),
            Product(name = "Bacon", icon = "🥓", price = 1.20, category = "Breakfast"),
            Product(name = "Egg", icon = "🥚", price = 0.40, category = "Breakfast"),
            // Seafood
            Product(name = "Fish", icon = "🐟", price = 15.99, category = "Seafood"),
            Product(name = "Shrimp", icon = "🦐", price = 18.50, category = "Seafood"),
            Product(name = "Lobster", icon = "🦞", price = 35.99, category = "Seafood"),
            Product(name = "Crab", icon = "🦀", price = 22.50, category = "Seafood"),
            Product(name = "Oyster", icon = "🦪", price = 14.99, category = "Seafood"),
            Product(name = "Squid", icon = "🦑", price = 13.75, category = "Seafood"),
            // Sandwich and Wraps
            Product(name = "Sandwich", icon = "🥪", price = 6.50, category = "Sandwich and Wraps"),
            // Middle Eastern
            Product(name = "Falafel", icon = "🧆", price = 1.00, category = "Middle Eastern"),
            // Condiments and Ingredients
            Product(
                name = "Cheese",
                icon = "🧀",
                price = 5.50,
                category = "Condiments and Ingredients"
            ),
            Product(
                name = "Butter",
                icon = "🧈",
                price = 4.20,
                category = "Condiments and Ingredients"
            ),
            Product(
                name = "Olive",
                icon = "🫒",
                price = 3.50,
                category = "Condiments and Ingredients"
            ),
            // Miscellaneous
            Product(name = "Ice", icon = "🧊", price = 2.00, category = "Miscellaneous")
        )
    }
}
