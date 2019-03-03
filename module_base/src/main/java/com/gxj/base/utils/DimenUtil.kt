package com.gxj.base.utils

import android.content.Context
import android.util.TypedValue

fun Context.dp2Px(dpVal: Int): Int =
    TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dpVal.toFloat(),
        resources.displayMetrics
    ).toInt()