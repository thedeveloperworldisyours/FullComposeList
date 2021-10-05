package com.a.jetpackcomposelists.multiple

import android.content.Context
import androidx.lifecycle.ViewModel
import com.a.jetpackcomposelists.R
import com.a.jetpackcomposelists.section.Fruit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MultipleViewModel: ViewModel() {
    private val booleanListMutable = MutableStateFlow(listOf<Int>())
    val booleanList : StateFlow<List<Int>> get() = booleanListMutable

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