package com.a.jetpackcomposelists.multiplebackground

import android.content.Context
import androidx.lifecycle.ViewModel
import com.a.jetpackcomposelists.R
import kotlinx.coroutines.flow.MutableStateFlow

class MultipleBackgroundViewModel: ViewModel() {
    private val booleanListMutable = MutableStateFlow(listOf<Int>())

    fun getInitial(context: Context) = context.resources.getStringArray(
        R.array.fruits_array).toList().toMutableList()

    fun fruitSelected(fruitSelected: Int) {
        booleanListMutable.value = booleanListMutable.value.toMutableList().also{ list ->
            if (list.contains(fruitSelected)) {
                list.remove(fruitSelected)
            } else {
                list.add(fruitSelected)
            }
        }
    }
}