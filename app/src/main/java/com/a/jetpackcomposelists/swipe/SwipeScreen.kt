package com.a.jetpackcomposelists.swipe

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.a.jetpackcomposelists.R

@ExperimentalMaterialApi
@Composable
fun SwipeScreen (
    viewModel: SwipeViewModel,
    context: Context
) {
    Scaffold(modifier = Modifier.fillMaxWidth(), topBar = {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {})
    }) {
        Column(modifier = Modifier.fillMaxHeight()) {
            NameList(Modifier.weight(1f), viewModel, context)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun NameList(modifier: Modifier,
             viewModel: SwipeViewModel,
             context: Context
) {
    LazyColumn(modifier = modifier) {
        items(items = viewModel.getList(context)) { item: String ->
            Surface {
                Card(
                    backgroundColor = MaterialTheme.colors.primarySurface,
                    elevation = 5.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 8.dp)
                ) {
                    SwipeContent(name = item)
                }
            }
        }
    }
}