package ru.roansa.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController

abstract class ScreenResolver {

    abstract fun canResolve(route: String): Boolean

    /**
     * Jetpack Compose can't use abstract methods as Composable
     * So in this case if you want to override composable method
     * You should use abstract parent classes with open functions
     */
    @SuppressLint("ComposableNaming")
    @Composable
    open fun resolve(navHostController: NavHostController, backStackEntry: NavBackStackEntry) {

    }

}