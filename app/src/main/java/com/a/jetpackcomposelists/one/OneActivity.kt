package com.a.jetpackcomposelists.one

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.a.jetpackcomposelists.ui.theme.JetpackComposeListsTheme

class OneActivity : ComponentActivity() {

    private val viewModel by viewModels<OneViewModel>()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeListsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    OneScreen(viewModel, this)
                }
            }
        }
    }
}