package com.a.jetpackcomposelists.multiple

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
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
    names: List<String> = List(15) { "Item #$it" },
    completed: MutableList<Boolean> = MutableList(15) { false }
) {
    Column(modifier = Modifier.fillMaxHeight()) {
        NameList(names, Modifier.weight(1f), completed)
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier, completed: MutableList<Boolean>) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(items = names) { index: Int, item: String ->
            Greeting(name = item, completed, index)
            Divider(color = Color.LightGray)
        }
    }
}

@Composable
fun Greeting(name: String, completedList: MutableList<Boolean>, index: Int) {
    var isSelected by rememberSaveable { mutableStateOf(completedList[index]) }
    val backgroundColor by animateColorAsState(if (isSelected) Color.Blue else Color.Transparent)

    Box(Modifier.fillMaxWidth()) {
        Text(
            text = "Hello $name!",
            modifier = Modifier
                .padding(24.dp).align(Alignment.CenterStart)
        )
        Checkbox(
            checked = isSelected,
            onCheckedChange = {
                isSelected = !isSelected
                completedList[index] = !isSelected
            },
            modifier = Modifier
                .padding(24.dp)
                .background(color = backgroundColor).align(Alignment.CenterEnd)
        )
    }
}
