package com.github.weslleystos.navigation

import androidx.navigation.NavOptionsBuilder
import com.github.weslleystos.navigation.model.Destination
import com.github.weslleystos.navigation.model.NavigationAction
import kotlinx.coroutines.flow.Flow

/**
 * The Navigator interface provides a streamlined approach to handling navigation
 * in Jetpack Compose, addressing common challenges such as callback hell,
 * scattered navigation logic, and the need for pre-navigation business logic.
 *
 * Key features:
 * - Centralized navigation control through a Flow of NavigationActions
 * - Support for both synchronous and asynchronous navigation operations
 * - Clear separation between top-level and regular destinations
 */
interface Navigator {
    val startDestination: Destination
    val navigationActions: Flow<NavigationAction>

    suspend fun navigateTo(destination: Destination)

    fun tryNavigateTo(destination: Destination)

    suspend fun navigateTo(
        destination: Destination,
        navOptions: NavOptionsBuilder.() -> Unit
    )

    fun tryNavigateTo(
        destination: Destination,
        navOptions: NavOptionsBuilder.() -> Unit
    )

    suspend fun navigateToTopLevel(destination: Destination)

    fun tryNavigateToTopLevel(destination: Destination)

    suspend fun navigateUp()

    fun tryNavigateUp()
}
