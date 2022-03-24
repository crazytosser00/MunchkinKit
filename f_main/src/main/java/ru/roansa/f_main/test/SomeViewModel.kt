package ru.roansa.f_main.test

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import ru.roansa.mvi.BaseMviProcessor
import ru.roansa.mvi.BaseMviViewModel
import ru.roansa.mvi.MviState
import ru.roansa.mvi.MviViewModel

class SomeViewModel : BaseMviViewModel<SomeAction, SomeEvent, SomeState>() {

}

class SomeState : MviState