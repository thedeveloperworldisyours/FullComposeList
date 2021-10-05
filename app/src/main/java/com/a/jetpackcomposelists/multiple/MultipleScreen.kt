package com.a.jetpackcomposelists.multiple

import android.content.Context
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Checkbox
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MultipleScreen(
    viewModel: MultipleViewModel,
    context: Context,
    completed: MutableList<Boolean> = MutableList(viewModel.getInitial(context).size) { false }
) {
    Column(modifier = Modifier.fillMaxHeight()) {
        NameList(viewModel, context, Modifier.weight(1f), completed)
    }
}

@Composable
fun NameList(
    viewModel: MultipleViewModel,
    context: Context,
    modifier: Modifier, completed: MutableList<Boolean>
) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(items = viewModel.getInitial(context)) { index: Int, item: String ->
            Greeting(viewModel, name = item, completed, index)
            Divider(color = Color.LightGray)
        }
    }
}

@Composable
fun Greeting(
    viewModel: MultipleViewModel, name: String, completedList: MutableList<Boolean>, index: Int
) {
    var isSelected by rememberSaveable { mutableStateOf(completedList[index]) }
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
                completedList[index] = !isSelected
                viewModel.fruitSelected(index)
            },
            modifier = Modifier
                .padding(24.dp)
                .background(color = backgroundColor)
                .align(Alignment.CenterEnd)
        )
    }
}
