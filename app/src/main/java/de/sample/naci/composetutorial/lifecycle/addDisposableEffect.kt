package de.sample.naci.composetutorial.lifecycle

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

//Coded by Fabian Jung
//This file is courtesy of Fabian Jung : https://github.com/betafx

@Composable
fun LifecycleOwner.addDisposableEffect(
    onCreate: (() -> Unit)? = null,
    onStart: (() -> Unit)? = null,
    onResume: (() -> Unit)? = null,
    onPause: (() -> Unit)? = null,
    onStop: (() -> Unit)? = null,
    onDestroy: (() -> Unit)? = null,
    onDisposed: (() -> Unit)? = null,
    onAny: (() -> Unit)? = null
) {
    DisposableEffect(this) {
        // Create an observer that triggers our funs
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> onCreate?.invoke()
                Lifecycle.Event.ON_START -> onStart?.invoke()
                Lifecycle.Event.ON_RESUME -> onResume?.invoke()
                Lifecycle.Event.ON_PAUSE -> onPause?.invoke()
                Lifecycle.Event.ON_STOP -> onStop?.invoke()
                Lifecycle.Event.ON_DESTROY -> onDestroy?.invoke() // TODO This neve gets called
                Lifecycle.Event.ON_ANY -> onAny?.invoke() // I have no clue when this gets called
            }
        }
        // Add the observer to the lifecycle
        this@addDisposableEffect.lifecycle.addObserver(observer)
        // When the effect leaves the Composition, remove the observer
        onDispose {
            onDisposed?.invoke()
            this@addDisposableEffect.lifecycle.removeObserver(observer)
        }
    }
}