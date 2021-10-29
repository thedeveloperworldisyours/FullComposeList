package com.a.jetpackcomposelists.single

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


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

    LazyColumn(modifier = modifier.height(90.dp)) {
        items(items = optionsList) { item: String ->
            ElementSelected(text = item,
                selectedValue =  optionsList[selectedOption.value],
                onClickListener = {
                    Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                })
            TabRowDefaults.Divider(color = Color.LightGray)
        }
    }
}



@Composable
fun ElementSelected(text: String,
                    selectedValue: String,
                    onClickListener: (String) -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .selectable(
                selected = (text == selectedValue),
                onClick = {
                    onClickListener(text)
                })
    ) {
        RadioButton(
            selected = (text == selectedValue),
            onClick = {
                onClickListener(text)
            })
        Text(
            text = text,
            style = MaterialTheme.typography.body1.merge(),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}
