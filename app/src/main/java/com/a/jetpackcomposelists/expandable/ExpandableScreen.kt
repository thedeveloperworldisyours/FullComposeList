package com.a.jetpackcomposelists.expandable

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.a.jetpackcomposelists.R

@ExperimentalAnimationApi
@Composable
fun ExpandableScreen(
    expandableViewModel: ExpandableViewModel, context: Context
) {

    Scaffold(
        modifier = Modifier
            .fillMaxWidth(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        }
    ) {
        Box(
            Modifier
                .fillMaxSize()
        ) {
            ExpandableElement(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                expandableViewModel,
                context
            )
        }
    }
}