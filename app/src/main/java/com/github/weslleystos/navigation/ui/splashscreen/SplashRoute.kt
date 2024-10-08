package com.github.weslleystos.navigation.ui.splashscreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SplashRoute(
    modifier: Modifier = Modifier,
    viewModel: SplashScreenViewModel = hiltViewModel()
) {
    viewModel.checkIfIsAuthenticated()

    SplashScreen(modifier = modifier)
}
