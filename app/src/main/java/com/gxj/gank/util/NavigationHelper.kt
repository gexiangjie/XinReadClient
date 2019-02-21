package com.gxj.gank.util

import android.annotation.SuppressLint
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager

@SuppressLint("RestrictedApi")
fun BottomNavigationView.disableShiftMode() {
    val menuView = this.getChildAt(0) as BottomNavigationMenuView
    try {
        menuView.labelVisibilityMode = 1
        (0 until menuView.childCount).forEach {
            (menuView.getChildAt(it) as BottomNavigationItemView).let { item ->
                item.setShifting(false)
            }
        }
    } catch (e: Exception) {

    }
}

fun BottomNavigationView.setUpWithViewPager(viewPager: ViewPager) {
    setOnNavigationItemSelectedListener { item ->
        (0 until menu.size()).forEach {
            if (item == menu.getItem(it)) {
                viewPager.setCurrentItem(it, false)
                return@setOnNavigationItemSelectedListener true
            }
        }
        false
    }
}
