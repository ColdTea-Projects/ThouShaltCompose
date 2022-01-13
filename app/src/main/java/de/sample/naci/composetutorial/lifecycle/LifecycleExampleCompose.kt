package de.sample.naci.composetutorial.lifecycle

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLifecycleOwner
import de.sample.naci.composetutorial.examples.TextFieldButtonSnackbar
import timber.log.Timber


@Composable
fun LifecycleExampleCompose() {
    LocalLifecycleOwner.current.addDisposableEffect(
        onCreate = {
            Timber.i("Composable Things --> onCreate")
        },
        onStart = {
            Timber.i("Composable Things --> onStart")
        },
        onResume = {
            Timber.i("Composable Things --> onResume")
        },
        onPause = {
            Timber.i("Composable Things --> onPause")
        },
        onStop = {
            Timber.i("Composable Things --> onStop")
        },
        onDestroy = {
            Timber.i("Composable Things --> onDestroy")
        },
        onDisposed = {
            Timber.i("Composable Things --> onDisposed")
        },
        onAny = {
            Timber.i("Composable Things --> onAny")
        }
    )
    TextFieldButtonSnackbar()
}