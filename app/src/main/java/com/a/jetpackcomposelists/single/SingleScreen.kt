package com.a.jetpackcomposelists.single

import android.annotation.SuppressLint
import android.content.Context
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a.jetpackcomposelists.R

@Composable
fun SingleScreen(
    viewModel: SingleViewModel,
    context: Context
) {
    Column(modifier = Modifier.fillMaxHeight()) {
        NameList(viewModel, context, Modifier.weight(1f))
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun NameList(
    viewModel: SingleViewModel,
    context: Context,
    modifier: Modifier
) {
    val selectedOption = mutableStateOf(0)
    val optionsList = viewModel.getInitial(context)
    Scaffold(modifier = Modifier.fillMaxWidth(), topBar = {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {})
    }) {
        LazyColumn(modifier = modifier.fillMaxSize()) {
            itemsIndexed(items = optionsList) { selected: Int, item: String ->
                ElementSelected(text = item,
                    selectedValue = optionsList[selectedOption.value],
                    onClickListener = {
                        selectedOption.value = selected
                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
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
