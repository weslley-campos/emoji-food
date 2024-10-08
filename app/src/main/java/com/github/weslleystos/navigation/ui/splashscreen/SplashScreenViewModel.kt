package com.github.weslleystos.navigation.ui.splashscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.weslleystos.navigation.Navigator
import com.github.weslleystos.navigation.graph.MainGraph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    navigator: Navigator
) : ViewModel(), Navigator by navigator {
    fun checkIfIsAuthenticated() {
        viewModelScope.launch {
            delay(2.seconds.inWholeMilliseconds)

            navigateTo(MainGraph.HomeGraph) {
                popUpTo<MainGraph.SplashRoute> {
                    inclusive = true
                }
            }
        }
    }
}
