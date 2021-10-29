package com.a.jetpackcomposelists.single

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.a.jetpackcomposelists.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SingleViewModel: ViewModel() {

    var lastIndex = 0
    var mutableList = mutableListOf<String>()
    var completed = mutableListOf<Boolean>()
    private val booleanListMutable = MutableStateFlow(listOf<Int>())
    val booleanList : StateFlow<List<Int>> get() = booleanListMutable
    var theIndex = mutableStateOf(1)

    fun getInitial(context: Context): MutableList<String>{
        mutableList = context.resources.getStringArray(
            R.array.fruits_array).toList().toMutableList()
        completed = MutableList(mutableList.size) { false }
        return mutableList
    }
    fun regenarete() {
        completed = MutableList(mutableList.size) { false }
    }

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
