package ru.roansa.core.navigation.di

import org.kodein.di.DI
import org.kodein.di.bindSingleton
import ru.roansa.f_main.MainScreenResolver
import ru.roansa.navigation.ScreenController

val navigationModule = DI.Module(name = "navigationModule") {
    bindSingleton {
        ScreenController().apply {
            add(MainScreenResolver())
        }
    }
}