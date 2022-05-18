package ru.roansa.navigation

import androidx.compose.runtime.Composable

abstract class BaseRoute {

    abstract val path: String

    abstract fun convertToString(): String

    companion object {
        const val ARG_FIRST = "arg_first"
        const val ARG_SECOND = "arg_second"
        const val ARG_THIRD = "arg_third"
        const val ARG_FOURTH = "arg_fourth"
        const val ARG_FIFTH = "arg_fifth"
    }

}