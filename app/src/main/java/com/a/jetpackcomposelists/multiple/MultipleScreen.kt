package com.a.jetpackcomposelists.multiple

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.a.jetpackcomposelists.R


@Composable
fun MultipleScreen(
    activity: MultipleActivity,
    completed: MutableList<Boolean> = MutableList(activity.viewModel.getInitial(activity).size) { false }
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
        Column(modifier = Modifier.fillMaxHeight()) {
            NameList(activity, completed)
        }
    }
}

@Composable
fun NameList(
    activity: MultipleActivity,
    completed: MutableList<Boolean>
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(items = activity.viewModel.getInitial(activity)) { index: Int, item: String ->
            Item(activity.viewModel, name = item, completed, index)
            Divider(color = Color.LightGray)
        }
    }
}

@Composable
fun Item(
    viewModel: MultipleViewModel,
    name: String,
    completedList: MutableList<Boolean>,
    index: Int
) {
    var isSelected by rememberSaveable { mutableStateOf(completedList[index]) }
    val backgroundColor by animateColorAsState(if (isSelected) Color.Gray else Color.Transparent)

    val onClickableListener = {
        isSelected = !isSelected
        completedList[index] = !isSelected
        viewModel.fruitSelected(index)
    }
    Box(Modifier.fillMaxWidth().selectable(
        selected = isSelected,
        onClick = onClickableListener)) {
        Text(
            text = name,
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.CenterStart)
        )
        RadioButton(
            selected = isSelected,
            onClick = onClickableListener,
            modifier = Modifier
                .padding(24.dp)
                .background(color = backgroundColor)
                .align(Alignment.CenterEnd)
        )
    }
}
