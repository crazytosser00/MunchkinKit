package ru.roansa.f_main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.compose.withDI
import org.kodein.di.instance
import ru.roansa.navigation.MainNavGraph
import ru.roansa.navigation.ScreenController

class MainActivity : AppCompatActivity(), DIAware {

    override val di: DI by lazy { (applicationContext as DIAware).di }
    val screenController: ScreenController by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            withDI(di) {
                MainNavGraph(navController = navController, controller = screenController)
            }
        }

    }
}