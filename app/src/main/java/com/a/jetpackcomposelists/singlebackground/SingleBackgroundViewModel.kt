package com.a.jetpackcomposelists.singlebackground

import android.content.Context
import androidx.lifecycle.ViewModel
import com.a.jetpackcomposelists.R

class SingleBackgroundViewModel: ViewModel() {

    var mutableList = mutableListOf<String>()
    var completed = mutableListOf<Boolean>()

    fun getInitial(context: Context): MutableList<String>{
        mutableList = context.resources.getStringArray(
            R.array.fruits_array).toList().toMutableList()
        completed = MutableList(mutableList.size) { false }
        return mutableList
    }
}