package ru.roansa.mvi

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

interface MviViewModel<A: MviAction, E: MviEvent, S: MviState>: DefaultLifecycleObserver {

    val state : SharedFlow<S>

}