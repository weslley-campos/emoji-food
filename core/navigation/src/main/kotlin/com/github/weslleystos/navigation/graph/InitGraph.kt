package com.github.weslleystos.navigation.graph

import com.github.weslleystos.navigation.model.Destination
import kotlinx.serialization.Serializable

sealed class InitGraph : Destination {
    @Serializable
    data object SplashScreen : Destination
}
