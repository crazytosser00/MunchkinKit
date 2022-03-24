package ru.roansa.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

open class BaseMviViewModel<A: MviAction, E: MviEvent, S: MviState> : MviViewModel<A, E, S>, ViewModel() {

    private val _state = MutableSharedFlow<S>(extraBufferCapacity = 100)

    override val state: SharedFlow<S> get() = _state

    override val mviProcessor: BaseMviProcessor<A, E, S> = BaseMviProcessor()
}