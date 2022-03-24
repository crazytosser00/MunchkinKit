package ru.roansa.mvi

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

/**
 * Terminal flow operator that collects the given flow with a provided [action] and catch [CancellationException]
 */
suspend inline fun <T> Flow<T>.safeCollect(crossinline action: suspend (value: T) -> Unit): Unit =
    this.collect { value ->
        try {
            action(value)
        } catch (e: CancellationException) {
            // Do nothing
        }
    }