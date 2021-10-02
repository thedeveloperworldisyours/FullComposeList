package com.a.jetpackcomposelists.expandable

import android.content.Context
import androidx.lifecycle.ViewModel
import com.a.jetpackcomposelists.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ExpandableViewModel : ViewModel() {
    private val expandedListMutable = MutableStateFlow(listOf<Int>())
    val expandedList : StateFlow<List<Int>> get() = expandedListMutable
    val elementList = mutableListOf<Element>()


    fun getElement(context: Context): List<Element> {
        val fruits: List<String> = context.resources.getStringArray(R.array.fruits_array).toList()

        fruits.forEach {
            elementList.add(Element(it, "$it detail"))
        }
        return elementList
    }

    fun cardArrowClick(cardId: Int) {
        expandedListMutable.value = expandedListMutable.value.toMutableList().also{ list ->
            if (list.contains(cardId)) {
                list.remove(cardId)
            } else {
                list.add(cardId)
            }
        }
    }
}