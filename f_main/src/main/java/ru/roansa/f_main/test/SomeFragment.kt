package ru.roansa.f_main.test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ru.roansa.mvi.MviIntent
import ru.roansa.mvi.MviView
import ru.roansa.mvi.MviViewModel

@ExperimentalCoroutinesApi
class SomeFragment : Fragment(), MviView<SomeAction, SomeEvent, SomeState> {

    override val viewModel: SomeViewModel get() = TODO("Not yet implemented")

    override suspend fun render(state: SomeState) {

    }

    override suspend fun handleEvent(event: SomeEvent) {

    }
}