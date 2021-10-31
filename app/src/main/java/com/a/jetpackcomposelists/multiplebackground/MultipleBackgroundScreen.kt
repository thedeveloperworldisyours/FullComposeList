package com.a.jetpackcomposelists.multiplebackground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Scaffold
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a.jetpackcomposelists.R

@Composable
fun MultipleBackgroundScreen(activity: MultipleBackgroundActivity,
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
    activity: MultipleBackgroundActivity,
    completed: MutableList<Boolean>
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(items = activity.viewModel.getInitial(activity)) { index: Int, item: String ->
            Item(activity, name = item, completed, index)
            TabRowDefaults.Divider(color = Color.LightGray)
        }
    }
}

@Composable
fun Item(
    activity: MultipleBackgroundActivity, name: String, completedList: MutableList<Boolean>, index: Int
) {
    var isSelected by rememberSaveable { mutableStateOf(completedList[index]) }

    Box(Modifier
        .height(90.dp)
        .fillMaxWidth()
        .background(if (isSelected) Color.Gray else Color.White)
        .selectable(
            selected = isSelected,
            onClick = {
                isSelected = !isSelected
                completedList[index] = !isSelected
                activity.viewModel.fruitSelected(index)
            })
    ) {
        Text(
            text = name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = if (isSelected) Color.White else Color.Gray,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.Center)
        )
    }
}
