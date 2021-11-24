package de.sample.naci.composetutorial

import androidx.lifecycle.ViewModel
import de.sample.naci.composetutorial.examples.motions.draganddroplist.ReorderItem
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(): ViewModel() {

    override fun onCleared() {
        Timber.i("Cleared")
        super.onCleared()
    }
    var clickCount = 0
    var nextScreenText = "Navigate to next"

    var dragAndDropList = listOf(
        ReorderItem(1),
        ReorderItem(2),
        ReorderItem(3),
        ReorderItem(4),
        ReorderItem(5),
        ReorderItem(6),
        ReorderItem(7),
        ReorderItem(8),
        ReorderItem(9),
        ReorderItem(10),
        ReorderItem(11),
        ReorderItem(12),
        ReorderItem(13),
        ReorderItem(14),
        ReorderItem(15),
        ReorderItem(16),
        ReorderItem(17),
        ReorderItem(18),
        ReorderItem(19),
        ReorderItem(20),
        ReorderItem(21),
        ReorderItem(22),
        ReorderItem(23),
        ReorderItem(24),
        ReorderItem(25),
        ReorderItem(26),
        ReorderItem(27),
        ReorderItem(28),
        ReorderItem(29)
    )
}