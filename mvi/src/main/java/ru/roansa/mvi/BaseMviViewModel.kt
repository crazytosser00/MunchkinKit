package ru.roansa.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.consumeAsFlow

open class BaseMviViewModel<A: MviAction, E: MviEvent, S: MviState> : MviViewModel<A, E, S>, ViewModel() {

    private val _state = MutableSharedFlow<S>(extraBufferCapacity = 100)

    override val state: SharedFlow<S> get() = _state

    protected open val actions: Channel<A> get() = Channel(capacity = 100)
    protected open val events: Channel<E> get() = Channel()

    protected suspend fun observeOnEvents(event: suspend (value: E) -> Unit) =
        events.consumeAsFlow().safeCollect(event)

    suspend fun observeOnActions(action: suspend (value: A) -> Unit) =
        actions.consumeAsFlow().safeCollect(action)

    @ExperimentalCoroutinesApi
    fun emitAction(action: A) {
        if (actions.isClosedForReceive || actions.isClosedForSend) return

        if (!actions.trySend(action).isSuccess) {
            println("Cannot send action $this to viewModel: channel overflow")
        }
    }

    private fun updateState(updatingAction: () -> S) {
        _state.tryEmit(updatingAction())
    }

    @ExperimentalCoroutinesApi
    private fun emitEvent(event: E) {
        if (events.isClosedForReceive || events.isClosedForSend) return

        if (!events.trySend(event).isSuccess) {
            println("Cannot send action $this to viewModel: channel overflow")
        }
    }
}