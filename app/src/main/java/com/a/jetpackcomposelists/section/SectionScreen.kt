package com.a.jetpackcomposelists.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.a.jetpackcomposelists.R

@Composable
fun SectionScreen(groupByInitials: Map<Char, List<Fruit>>) {
    Scaffold(modifier = Modifier.fillMaxWidth(), topBar = {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {})
    }) {
        Column(modifier = Modifier.fillMaxHeight()) {
            NameList(groupByInitials = groupByInitials, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun NameList(groupByInitials: Map<Char, List<Fruit>>, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        groupByInitials.forEach { (initials, fruits) ->
            item {
                HeaderComposable(name = initials.toString())
            }
            items(items = fruits) { fruit ->
                ItemComposable(name = fruit.name)
            }
        }
    }
}

@Composable
fun HeaderComposable(name: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Text(text = name, modifier = Modifier.padding(7.dp))
    }
    Divider(color = Color.LightGray)
}

@Composable
fun ItemComposable(name: String) {
    Row {
        Text(text = name, modifier = Modifier.padding(14.dp))
    }
    Divider(color = Color.LightGray)
}