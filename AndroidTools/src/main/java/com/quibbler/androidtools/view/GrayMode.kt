package com.quibbler.androidtools.view

import android.app.Activity
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.view.View
import android.view.Window

/**
 * make this view show in gray mode.
 *
 * @receiver View
 * @param saturation a Float value of 0 maps the color to gray-scale. 1 is identity.
 */
fun View.grayMode(saturation: Float = 0f) {
    val colorMatrix = ColorMatrix().apply {
        setSaturation(saturation)
    }
    val paint = Paint().apply {
        colorFilter = ColorMatrixColorFilter(colorMatrix)
    }
    setLayerType(View.LAYER_TYPE_HARDWARE, paint)
}

/**
 * make this Window show in gray mode.
 * @receiver Window
 */
fun Window.grayMode() {
    decorView.grayMode()
}

/**
 * make this Activity show in gray mode.
 * @receiver Activity
 */
fun Activity.grayMode() {
    window?.grayMode()
}
