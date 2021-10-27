package de.sample.naci.composetutorial.extensions

fun <T> List<T>.swap(take: Int, with: Int): List<T> = this
    .toMutableList()
    .apply {
        val taken = this[take]
        this[take] = this[with]
        this[with] = taken
    }