package com.a.jetpackcomposelists.horizontal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.a.jetpackcomposelists.ui.theme.JetpackComposeListsTheme

class HorizontalActivity: ComponentActivity() {

    private val viewModel by viewModels<HorizontalViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeListsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    HorizontalScreen(viewModel, this)
                }
            }
        }
    }
}