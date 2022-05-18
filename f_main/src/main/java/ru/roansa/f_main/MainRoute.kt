package ru.roansa.f_main

import androidx.compose.runtime.Composable
import com.squareup.moshi.Moshi
import ru.roansa.navigation.ARG_MAP_MOSHI_TYPE
import ru.roansa.navigation.BaseRoute
import ru.roansa.navigation.MAIN_ROUTE

class MainRoute(val testArg: String?) : BaseRoute() {

    constructor(args: Map<String, Any?>) : this(
        testArg = args[ARG_FIRST] as? String
    )

    override val path: String get() = MAIN_ROUTE

    override fun convertToString(): String {
        val map = mapOf(ARG_FIRST to testArg)
        val args =
            Moshi.Builder().build().adapter<Map<String, Any?>>(ARG_MAP_MOSHI_TYPE).toJson(map)

        return "$path/$args"
    }

}