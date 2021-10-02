package com.a.jetpackcomposelists.main

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.a.jetpackcomposelists.R
import com.a.jetpackcomposelists.expandable.ExpandableActivity
import com.a.jetpackcomposelists.multiple.MultipleActivity
import com.a.jetpackcomposelists.section.SectionActivity
import com.a.jetpackcomposelists.sectionstick.SectionStickActivity

class MainViewModel : ViewModel() {

    companion object {
        const val SECTION = 0
        const val SECTION_STICK = 1
        const val EXPANDABLE = 2
        const val MULTIPLE = 3
    }

    fun getList(context: Context): MutableList<String> {
        val fruitList = ArrayList<String>()
        fruitList.add(context.resources.getString(R.string.section))
        fruitList.add(context.resources.getString(R.string.section_stick))
        fruitList.add(context.resources.getString(R.string.expandable))
        fruitList.add(context.resources.getString(R.string.multiple))
        return fruitList
    }

    fun goToNewScreen(index: Int, context: Context) {
        when(index) {
            SECTION -> {
                context.startActivity(Intent(context, SectionActivity::class.java))
            }
            SECTION_STICK -> {
                context.startActivity(Intent(context, SectionStickActivity::class.java))
            }
            EXPANDABLE -> {
                context.startActivity(Intent(context, ExpandableActivity::class.java))
            }
            MULTIPLE -> {
                context.startActivity(Intent(context, MultipleActivity::class.java))
            }
        }
    }
}