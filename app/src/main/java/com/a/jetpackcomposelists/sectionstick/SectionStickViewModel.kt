package com.example.listswithcompose.sectionstick

import android.content.Context
import androidx.lifecycle.ViewModel
import com.a.jetpackcomposelists.R
import com.a.jetpackcomposelists.sectionstick.Fruit

class SectionStickViewModel : ViewModel() {
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