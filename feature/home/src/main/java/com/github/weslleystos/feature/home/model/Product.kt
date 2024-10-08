package com.github.weslleystos.feature.home.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(val name: String, val icon: String, val price: Double)
