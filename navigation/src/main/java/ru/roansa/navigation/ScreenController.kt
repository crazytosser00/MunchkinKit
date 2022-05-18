package ru.roansa.navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

class ScreenController {

    private val screenResolvers = mutableListOf<ScreenResolver>()

    @SuppressLint("ComposableNaming")
    @Composable
    fun showScreen(
        route: String,
        navHostController: NavHostController,
        backStackEntry: NavBackStackEntry
    ) {
        screenResolvers.forEach { resolver ->
            if (resolver.canResolve(route)) {
                resolver.resolve(navHostController, backStackEntry)
                return
            }
        }
    }

    fun add(screenResolver: ScreenResolver) {
        screenResolvers.add(screenResolver)
    }

}