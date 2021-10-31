package com.a.jetpackcomposelists.multiple

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.a.jetpackcomposelists.main.MainViewModel
import com.a.jetpackcomposelists.main.MyScreenContent
import com.a.jetpackcomposelists.ui.theme.JetpackComposeListsTheme

class MultipleActivity : ComponentActivity() {

    val viewModel by viewModels<MultipleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeListsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MultipleScreen(this)
                }
            }
        }
    }
}