package com.github.weslleystos.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.github.weslleystos.navigation.navigation.observeNavigationEvents
import com.github.weslleystos.navigation.ui.components.AppNavHost
import com.github.weslleystos.navigation.ui.components.AppScaffold
import com.github.weslleystos.navigation.ui.theme.ComposeNavigationTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationTheme {
                AppScaffold { navController, innerPadding ->
                    navController.observeNavigationEvents(navigator)

                    AppNavHost(
                        navController = navController,
                        startDestination = navigator.startDestination,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
