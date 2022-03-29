package ru.roansa.f_main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import org.kodein.di.DI
import org.kodein.di.DIAware

class MainActivity : AppCompatActivity(), DIAware {

    override val di: DI by lazy { (applicationContext as DIAware).di }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Text("S")
        }

    }
}