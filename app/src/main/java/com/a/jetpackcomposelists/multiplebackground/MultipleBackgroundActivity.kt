package com.a.jetpackcomposelists.multiplebackground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.a.jetpackcomposelists.ui.theme.JetpackComposeListsTheme

class MultipleBackgroundActivity: ComponentActivity() {

    val viewModel by viewModels<MultipleBackgroundViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeListsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MultipleBackgroundScreen(this)
                }
            }
        }
    }
}