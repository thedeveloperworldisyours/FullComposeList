package com.a.jetpackcomposelists.single

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a.jetpackcomposelists.R

@Composable
fun SingleScreen(
    activity: SingleActivity
) {
    Column(modifier = Modifier.fillMaxHeight()) {
        NameList(activity)
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun NameList(
    activity: SingleActivity
) {
    val selectedOption = mutableStateOf(0)
    val optionsList = activity.viewModel.getInitial(activity)
    Scaffold(modifier = Modifier.fillMaxWidth(), topBar = {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {})
    }) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(items = optionsList) { selected: Int, item: String ->
                ElementSelected(text = item,
                    selectedValue = optionsList[selectedOption.value],
                    onClickListener = {
                        selectedOption.value = selected
                    })
                TabRowDefaults.Divider(color = Color.LightGray)
            }
        }
    }
}


@Composable
fun ElementSelected(
    text: String,
    selectedValue: String,
    onClickListener: (String) -> Unit
) {
    Box(
        Modifier
            .height(90.dp)
            .fillMaxWidth()
            .selectable(
                selected = (text == selectedValue),
                onClick = {
                    onClickListener(text)
                })
    ) {
        RadioButton(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(10.dp),
            selected = (text == selectedValue),
            onClick = {
                onClickListener(text)
            })
        Text(
            text = text,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.Center)
        )
    }
}
