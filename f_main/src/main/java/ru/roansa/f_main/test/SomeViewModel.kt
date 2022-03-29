package ru.roansa.f_main.test

import ru.roansa.mvi.BaseMviViewModel
import ru.roansa.mvi.MviState

class SomeViewModel : BaseMviViewModel<SomeAction, SomeEvent, SomeState>() {

}

class SomeState : MviState