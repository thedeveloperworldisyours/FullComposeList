package com.a.jetpackcomposelists.swipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.a.jetpackcomposelists.ui.theme.JetpackComposeListsTheme

class SwipeActivity : ComponentActivity() {

    private val viewModel by viewModels<SwipeViewModel>()

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeListsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    SwipeScreen(viewModel, this)
                }
            }
        }
    }
}