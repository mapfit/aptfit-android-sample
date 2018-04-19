package com.mapfit.realestate.util

import android.graphics.drawable.Drawable
import android.widget.TextView

fun TextView.setCompoundDrawables(
    start: Drawable? = null,
    top: Drawable? = null,
    end: Drawable? = null,
    bottom: Drawable? = null
) {
    setCompoundDrawablesWithIntrinsicBounds(start, top, end, bottom)
}