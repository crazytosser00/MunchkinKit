package ru.roansa.f_main.test

import ru.roansa.mvi.MviAction

abstract class SomeAction : MviAction()

object AnyAction : SomeAction()