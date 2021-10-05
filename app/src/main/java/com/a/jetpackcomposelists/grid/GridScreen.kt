package com.a.jetpackcomposelists.grid

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.a.jetpackcomposelists.R

@ExperimentalFoundationApi
@Composable
fun GridScreen(
    viewModel: GridViewModel,
    context: Context
) {
    Scaffold(modifier = Modifier.fillMaxWidth(), topBar = {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {})
    }) {
        Column(modifier = Modifier.fillMaxHeight()) {
            VerticalGrid(Modifier.fillMaxWidth(), viewModel, context)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun VerticalGrid(
    modifier: Modifier,
    viewModel: GridViewModel,
    context: Context
) {
    LazyVerticalGrid(modifier = modifier, cells = GridCells.Fixed(2)) {
        items(items = viewModel.getList(context)) { item: String ->
            Surface() {
                Card(
                    backgroundColor = MaterialTheme.colors.primarySurface,
                    elevation = 5.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 8.dp)
                ) {
                    Text(text = item, modifier = Modifier.padding(14.dp), color = Color.White)
                }
            }
        }
    }
}