package com.github.weslleystos.core.data.products.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val name: String,
    val icon: String,
    val category: String,
    val price: Double
)
