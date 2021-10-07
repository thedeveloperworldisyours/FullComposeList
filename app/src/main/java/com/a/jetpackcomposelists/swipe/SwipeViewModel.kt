package com.a.jetpackcomposelists.swipe

import android.content.Context
import androidx.lifecycle.ViewModel
import com.a.jetpackcomposelists.R

class SwipeViewModel: ViewModel() {
    fun getList(context: Context) = context.resources.getStringArray(
        R.array.fruits_array).toList().toMutableList()

}