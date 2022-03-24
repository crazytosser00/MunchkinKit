package ru.roansa.mvi

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharedFlow

@ExperimentalCoroutinesApi
interface MviView<A: MviAction, E: MviEvent, S: MviState> {

    val viewModel: MviViewModel<A, E, S>
    //TODO this getter may throw NoSuchElementException, so that needs rework
    val state: S get() = viewModel.state.replayCache.last()

    suspend fun render(state: S)

    suspend fun handleEvent(event: E)

    fun A.emit() {
        if (viewModel.actions.isClosedForReceive || viewModel.actions.isClosedForSend) return

        if (!viewModel.actions.trySend(this).isSuccess) {
            println("Cannot send action $this to viewModel: channel overflow")
        }
    }

}