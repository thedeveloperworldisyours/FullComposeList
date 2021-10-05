package com.a.jetpackcomposelists.horizontal

import android.content.Context
import androidx.lifecycle.ViewModel
import com.a.jetpackcomposelists.R

class HorizontalViewModel : ViewModel() {
    fun getList(context: Context) = context.resources.getStringArray(
            R.array.fruits_array).toList().toMutableList()

}