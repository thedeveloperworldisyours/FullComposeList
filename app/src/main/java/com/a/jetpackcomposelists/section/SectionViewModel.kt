package com.a.jetpackcomposelists.section

import android.content.Context
import androidx.lifecycle.ViewModel
import com.a.jetpackcomposelists.R

class SectionViewModel : ViewModel() {
    fun getMap(context: Context): Map<Char, List<Fruit>> {
        val fruits: List<String> = context.resources.getStringArray(R.array.fruits_array).toList()
        return getInitial(fruits).groupBy { it.initial }
    }

    private fun getInitial(fruits: List<String>): MutableList<Fruit> {
        val fruitList = ArrayList<Fruit>()
        fruits.forEach { fruitList.add(Fruit(it.first(), it)) }
        return fruitList
    }
}