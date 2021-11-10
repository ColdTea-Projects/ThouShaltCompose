package de.sample.naci.composetutorial.examples.navigation.model

import androidx.annotation.StringRes
import de.sample.naci.composetutorial.R

sealed class ScreenGroups(val route: String, @StringRes val resourceId: Int)

object Group1: ScreenGroups("group1", R.string.group_1)
object Group2: ScreenGroups("group2", R.string.group_2)

val screenGroups = listOf(
    Group1,
    Group2
)