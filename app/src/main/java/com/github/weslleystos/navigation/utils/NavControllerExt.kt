package com.github.weslleystos.navigation.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.github.weslleystos.navigation.Navigator
import com.github.weslleystos.navigation.model.Destination
import com.github.weslleystos.navigation.model.NavigationAction

/**
 * Navigates to a top-level destination in the navigation hierarchy.
 *
 * This extension function for NavHostController is designed to handle navigation
 * to top-level destinations, such as items in a bottom navigation bar.
 * It ensures a consistent and efficient navigation experience.
 */
fun NavHostController.navigateToTopLevel(destination: Destination) {
    navigate(destination) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reSelecting the same item
        launchSingleTop = true
        // Restore state when reSelecting a previously selected item
        restoreState = true
    }
}

/**
 * Observes and processes navigation events from a [Navigator].
 *
 * This extension function for [NavHostController] collects navigation actions
 * from a [Navigator] and executes them accordingly. It handles different types
 * of navigation actions, including navigation to a specific destination,
 * navigation to a top-level destination, and upward navigation in the hierarchy.
 *
 * @param navigator The [Navigator] from which to collect navigation actions.
 */
@Composable
fun NavHostController.observeNavigationEvents(navigator: Navigator) {
    navigator.navigationActions.collectWithLifecycle { action ->
        when (action) {
            is NavigationAction.Navigate -> navigate(action.destination) {
                action.navOptions(this)
            }

            is NavigationAction.NavigateToTopLevel -> navigateToTopLevel(action.destination)

            is NavigationAction.NavigateUp -> navigateUp()
        }
    }
}
