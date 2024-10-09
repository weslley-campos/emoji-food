package com.github.weslleystos.feature.orders.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class ProductOrder(
    val name: String,
    val icon: String,
    val category: String,
    val price: Double
) : Parcelable
