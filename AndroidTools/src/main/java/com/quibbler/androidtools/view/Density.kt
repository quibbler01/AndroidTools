package com.quibbler.androidtools.view

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * According to the resolution of the phone, the unit is converted from dp to px (pixel)
 *
 * @param context Context Interface to global information about an application environment.
 * @param dpValue Float value ine dp
 * @return Int value in px
 */
fun dip2px(context: Context, dpValue: Float): Int {
    val scale: Float = context.resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}

/**
 * According to the resolution of the mobile phone, the unit is converted from px (pixel) to dp
 *
 * @param context Context Interface to global information about an application environment.
 * @param pxValue Float value in px
 * @return Int value in dp
 */
fun px2dip(context: Context, pxValue: Float): Int {
    val scale: Float = context.resources.displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()
}

/**
 *
 * @param context Context Interface to global information about an application environment.
 * @return DisplayMetrics
 */
fun getPhysicsDisplayMetrics(context: Context): DisplayMetrics {
    val wm: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val displayMetrics: DisplayMetrics = DisplayMetrics()
    wm.defaultDisplay.getRealMetrics(displayMetrics)
    return displayMetrics
}

/**
 *
 * @param context Context Interface to global information about an application environment.
 * @return Int The width of the screen
 */
fun getScreenWidth(context: Context): Int {
    val displayMetrics: DisplayMetrics = getPhysicsDisplayMetrics(context)
    return displayMetrics.widthPixels
}

/**
 *
 * @param context Context Interface to global information about an application environment.
 * @return Int The height of the screen
 */
fun getScreenHeight(context: Context): Int {
    val displayMetrics: DisplayMetrics = getPhysicsDisplayMetrics(context)
    return displayMetrics.heightPixels
}
