package ru.roansa.mvi

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.consumeAsFlow

open class BaseMviProcessor<A : MviAction, E : MviEvent, S : MviState> {

    protected open val actions: Channel<A> get() = Channel(capacity = 100)
    protected open val events: Channel<E> get() = Channel()

    suspend fun observeOnEvents(event: suspend (value: E) -> Unit) =
        events.consumeAsFlow().safeCollect(event)

    suspend fun observeOnActions(action: suspend (value: A) -> Unit) =
        actions.consumeAsFlow().safeCollect(action)

}