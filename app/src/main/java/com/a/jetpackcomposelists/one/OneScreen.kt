package com.a.jetpackcomposelists.one

import android.content.Context
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.a.jetpackcomposelists.multiple.MultipleViewModel


@Composable
fun OneScreen(
    viewModel: OneViewModel,
    context: Context
) {
    Column(modifier = Modifier.fillMaxHeight()) {
        NameList(viewModel, context, Modifier.weight(1f))
    }
}

@Composable
fun NameList(
    viewModel: OneViewModel,
    context: Context,
    modifier: Modifier
) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(items = viewModel.getInitial(context)) { index: Int, item: String ->
            Greeting(viewModel, name = item, index)
            TabRowDefaults.Divider(color = Color.LightGray)
        }
    }
}

@Composable
fun Greeting(
    viewModel: OneViewModel, name: String, index: Int
) {

    var isSelected by rememberSaveable { mutableStateOf(viewModel.completed[index]) }
    val backgroundColor by animateColorAsState(if (isSelected) Color.Blue else Color.Transparent)

    Box(Modifier.fillMaxWidth()) {
        Text(
            text = name,
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.CenterStart)
        )
        Checkbox(
            checked = isSelected,
            onCheckedChange = {
                isSelected = !isSelected
                viewModel.completed[viewModel.lastIndex] = isSelected
                viewModel.lastIndex = index
                /*viewModel.completed[index] = !isSelected


                viewModel.completed[viewModel.lastIndex] = false
                viewModel.lastIndex = index
                viewModel.completed[index] = true*/
                viewModel.fruitSelected(index)
            },
            modifier = Modifier
                .padding(24.dp)
                .background(color = backgroundColor)
                .align(Alignment.CenterEnd)
        )
    }
}
