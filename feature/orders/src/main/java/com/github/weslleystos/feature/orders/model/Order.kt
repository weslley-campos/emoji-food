package com.github.weslleystos.feature.orders.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Order(
    val product: ProductOrder,
    val quantity: Int,
) : Parcelable
