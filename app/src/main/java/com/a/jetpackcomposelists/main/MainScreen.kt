package com.a.jetpackcomposelists.main

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.a.jetpackcomposelists.R

@Composable
fun MyScreenContent(
    viewModel: MainViewModel,
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

@Composable
fun NameList(modifier: Modifier,
    viewModel: MainViewModel,
    context: Context
) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(items = viewModel.getList(context)) { index: Int, item: String ->
            Surface(modifier = Modifier.clickable { viewModel.goToNewScreen(index, context) }) {
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