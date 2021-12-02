package com.quibbler.androidtools.resource

import android.util.Log
import com.quibbler.androidtools.AndroidTools
import com.quibbler.androidtools.AndroidTools.TAG

/**
 *
 * @param resName String
 * @param type String
 * @param pkgName String
 * @return Int
 */
fun getResIdByName(resName: String, type: String, pkgName: String = AndroidTools.getContext().packageName): Int {
    var id: Int = -1
    try {
        id = AndroidTools.getContext().resources.getIdentifier(resName, type, pkgName)
    } catch (e: Exception) {
        Log.d(TAG, "get $resName failed,type is $type : ${e.message}")
    }
    return id
}

fun getResIdByName(resName: String, type: String): Int {
    val pkgName = AndroidTools.getContext().packageName
    return getResIdByName(resName, type, pkgName)
}

fun getDrawableResIdByName(resName: String): Int {
    return getResIdByName(resName, "drawable")
}

fun getStringResIdByName(resName: String): Int {
    return getResIdByName(resName, "string")
}

fun getLayoutResIdByName(resName: String): Int {
    return getResIdByName(resName, "layout")
}

fun getColorResIdByName(resName: String): Int {
    return getResIdByName(resName, "color")
}

fun getDimenResIdByName(resName: String): Int {
    return getResIdByName(resName, "dimens")
}

fun getThemeResIdByName(resName: String): Int {
    return getResIdByName(resName, "themes")
}
