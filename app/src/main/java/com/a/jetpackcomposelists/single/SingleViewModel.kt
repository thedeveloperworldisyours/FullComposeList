package com.a.jetpackcomposelists.single

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.a.jetpackcomposelists.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SingleViewModel: ViewModel() {

    var mutableList = mutableListOf<String>()
    var completed = mutableListOf<Boolean>()

    fun getInitial(context: Context): MutableList<String>{
        mutableList = context.resources.getStringArray(
            R.array.fruits_array).toList().toMutableList()
        completed = MutableList(mutableList.size) { false }
        return mutableList
    }
}
