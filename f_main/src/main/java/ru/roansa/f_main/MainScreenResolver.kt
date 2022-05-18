package ru.roansa.f_main

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import ru.roansa.navigation.MAIN_ROUTE
import ru.roansa.navigation.ScreenResolver

class MainScreenResolver : ScreenResolver() {

    override fun canResolve(route: String): Boolean = route.startsWith(MAIN_ROUTE)

    @SuppressLint("ComposableNaming")
    @Composable
    override fun resolve(navHostController: NavHostController, backStackEntry: NavBackStackEntry) {
        MainScreen(navHostController, backStackEntry)
    }
}