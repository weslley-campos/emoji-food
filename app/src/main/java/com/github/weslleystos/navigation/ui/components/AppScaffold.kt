package com.github.weslleystos.navigation.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.weslleystos.navigation.navigation.isSelected
import com.github.weslleystos.navigation.navigation.isTopLevelRoute
import com.github.weslleystos.navigation.navigation.navigateToTopLevel
import com.github.weslleystos.navigation.navigation.topLevelRoutes
import com.github.weslleystos.navigation.ui.theme.ComposeNavigationTheme

@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
    content: @Composable (NavHostController, PaddingValues) -> Unit
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val isTopLevelRoute = currentDestination?.isTopLevelRoute() ?: false
            if (isTopLevelRoute) {
                BottomAppBar {
                    topLevelRoutes.forEach { topLevelRoute ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    topLevelRoute.icon,
                                    contentDescription = topLevelRoute.name
                                )
                            },
                            label = { Text(topLevelRoute.name) },
                            selected = currentDestination?.isSelected(topLevelRoute.route) ?: false,
                            onClick = {
                                navController.navigateToTopLevel(topLevelRoute.route)
                            }
                        )
                    }
                }
            }
        },
        modifier = modifier
            .fillMaxSize(),
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        content = { content.invoke(navController, it) }
    )
}

@Preview
@Composable
private fun AppScaffoldPreview() {
    ComposeNavigationTheme {
        AppScaffold { _, _ -> }
    }
}
