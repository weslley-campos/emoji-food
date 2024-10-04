package com.github.weslleystos.navigation.utils

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

/**
 * Collects the Flow with lifecycle awareness.
 *
 * This extension function on Flow<T> is designed to be used within a Composable function.
 * It ensures that the Flow is collected in a lifecycle-aware manner, starting when the
 * lifecycle reaches the STARTED state and stopping when it falls below that state.
 *
 * Usage:
 * ```
 * val myFlow: Flow<Int> = ...
 * myFlow.collectWithLifecycle { value ->
 *     // Handle the emitted value
 * }
 * ```
 */

@SuppressLint("ComposableNaming")
@Composable
fun <T> Flow<T>.collectWithLifecycle(collector: (T) -> Unit) {
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(lifecycleOwner) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            withContext(Dispatchers.Main.immediate) {
                collect(collector)
            }
        }
    }
}
