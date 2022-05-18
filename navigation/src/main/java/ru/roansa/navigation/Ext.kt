package ru.roansa.navigation

import androidx.navigation.NavHostController
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.ParameterizedType

val ARG_MAP_MOSHI_TYPE: ParameterizedType by lazy {
    Types.newParameterizedType(
        Map::class.java,
        String::class.java,
        Any::class.java
    )
}

/**
 * NavHostController isn't using in extracting process, but method calls from it's scope
 * Because we need to restrict possible usage of this method
 *
 * Now we can use the method only in context of Compose navigation
 */
fun NavHostController.extractArgsMap(args: String): Map<String, Any?> {
    return Moshi.Builder().build().adapter<Map<String, Any?>>(ARG_MAP_MOSHI_TYPE).fromJson(args)
        ?: mapOf()
}