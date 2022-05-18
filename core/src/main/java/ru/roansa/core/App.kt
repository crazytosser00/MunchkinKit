package ru.roansa.core

import android.app.Application
import android.content.Context
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.bindSingleton
import ru.roansa.core.navigation.di.navigationModule

class App : Application(), DIAware {

    override val di: DI by DI.lazy {
        import(androidXModule(this@App))
        import(navigationModule)
    }

}