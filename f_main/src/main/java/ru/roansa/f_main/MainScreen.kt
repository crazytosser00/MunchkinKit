package ru.roansa.f_main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController, backStackEntry: NavBackStackEntry) {
    Text(text = "This is the main screen")
}