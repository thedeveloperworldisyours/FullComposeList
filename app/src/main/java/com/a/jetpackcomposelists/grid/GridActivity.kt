package com.a.jetpackcomposelists.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.a.jetpackcomposelists.horizontal.HorizontalScreen
import com.a.jetpackcomposelists.horizontal.HorizontalViewModel
import com.a.jetpackcomposelists.ui.theme.JetpackComposeListsTheme

class GridActivity: ComponentActivity() {

    private val viewModel by viewModels<GridViewModel>()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeListsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    GridScreen(viewModel, this)
                }
            }
        }
    }
}