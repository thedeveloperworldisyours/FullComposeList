package com.a.jetpackcomposelists.main

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.a.jetpackcomposelists.R
import com.a.jetpackcomposelists.singlebackground.SingleBackgroundActivity
import com.a.jetpackcomposelists.expandable.ExpandableActivity
import com.a.jetpackcomposelists.grid.GridActivity
import com.a.jetpackcomposelists.horizontal.HorizontalActivity
import com.a.jetpackcomposelists.single.SingleActivity
import com.a.jetpackcomposelists.multiple.MultipleActivity
import com.a.jetpackcomposelists.multiplebackground.MultipleBackgroundActivity
import com.a.jetpackcomposelists.section.SectionActivity
import com.a.jetpackcomposelists.sectionstick.SectionStickActivity
import com.a.jetpackcomposelists.swipe.SwipeActivity

class MainViewModel : ViewModel() {

    companion object {
        const val SECTION = 0
        const val SECTION_STICK = 1
        const val EXPANDABLE = 2
        const val MULTIPLE = 3
        const val HORIZONTAL = 4
        const val GRID = 5
        const val ONE_CHOICE = 6
        const val SWIPE = 7
        const val SINGLE_BACKGROUND = 8
        const val MULTIPLE_BACKGROUND = 9
    }

    fun getList(context: Context): MutableList<String> {
        val fruitList = ArrayList<String>()
        fruitList.add(context.resources.getString(R.string.section))
        fruitList.add(context.resources.getString(R.string.section_stick))
        fruitList.add(context.resources.getString(R.string.expandable))
        fruitList.add(context.resources.getString(R.string.multiple))
        fruitList.add(context.resources.getString(R.string.horizontal))
        fruitList.add(context.resources.getString(R.string.grid))
        fruitList.add(context.resources.getString(R.string.one_choice))
        fruitList.add(context.resources.getString(R.string.swipe))
        fruitList.add(context.resources.getString(R.string.single_background))
        fruitList.add(context.resources.getString(R.string.multiple_background))
        return fruitList
    }

    fun goToNewScreen(index: Int, context: Context) {
        when (index) {
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
            HORIZONTAL -> {
                context.startActivity(Intent(context, HorizontalActivity::class.java))
            }
            GRID -> {
                context.startActivity(Intent(context, GridActivity::class.java))
            }
            ONE_CHOICE -> {
                context.startActivity(Intent(context, SingleActivity::class.java))
            }
            SWIPE -> {
                context.startActivity(Intent(context, SwipeActivity::class.java))
            }
            SINGLE_BACKGROUND -> {
                context.startActivity(Intent(context, SingleBackgroundActivity::class.java))
            }
            MULTIPLE_BACKGROUND -> {
                context.startActivity(Intent(context, MultipleBackgroundActivity::class.java))
            }
        }
    }
}