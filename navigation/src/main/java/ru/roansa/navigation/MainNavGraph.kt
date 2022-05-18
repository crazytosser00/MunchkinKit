package ru.roansa.navigation

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavGraph(navController: NavHostController, controller: ScreenController) {
    NavHost(navController = navController, startDestination = MAIN_ROUTE.withArgs()) {

        composable(MAIN_ROUTE.withArgs(), args) {
            controller.showScreen(MAIN_ROUTE, navController, it)
        }
    }
}

private fun String.withArgs(): String = "$this/{args}"

private val args = listOf(navArgument("args") { type = NavType.StringType })