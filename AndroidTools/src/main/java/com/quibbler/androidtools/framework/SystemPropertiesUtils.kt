package com.quibbler.androidtools.framework

import android.content.Context

private const val SystemPropertiesClassName = "android.os.SystemProperties"

fun getProperty(name: String, defaultValue: String = ""): String {
    try {
        val clazz = Class.forName(SystemPropertiesClassName)
        val get = clazz.getDeclaredMethod("get", String.javaClass, String.javaClass)
        return get.invoke(clazz, name, defaultValue) as String
    } catch (ignore: Exception) {
    }
    return defaultValue
}

fun setProperty(key: String, value: String) {
    try {
        val clazz = Class.forName(SystemPropertiesClassName)
        val set = clazz.getDeclaredMethod("set", String.javaClass, String.javaClass)
        set.invoke(clazz, key, value)
    } catch (ignore: Exception) {
    }
}