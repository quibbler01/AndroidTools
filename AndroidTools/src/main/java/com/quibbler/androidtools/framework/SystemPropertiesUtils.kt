package com.quibbler.androidtools.framework

import android.annotation.SuppressLint

const val SystemPropertiesClassName = "android.os.SystemProperties"

@SuppressLint("PrivateApi")
fun getProperty(name: String, defaultValue: String = ""): String {
    try {
        val clazz = Class.forName(SystemPropertiesClassName)
        val get = clazz.getMethod("get", String::class.java, String::class.java)
        return get.invoke(clazz, name, defaultValue) as String
    } catch (ignore: Exception) {
    }
    return defaultValue
}

@SuppressLint("PrivateApi")
fun getProperty(name: String, defaultValue: Int = -1): Int {
    try {
        val clazz = Class.forName(SystemPropertiesClassName)
        val get = clazz.getMethod("get", String::class.java, Int::class.java)
        return get.invoke(clazz, name, defaultValue) as Int
    } catch (ignore: Exception) {
    }
    return defaultValue
}

@SuppressLint("PrivateApi")
fun getProperty(name: String, defaultValue: Long = -1L): Long {
    try {
        val clazz = Class.forName(SystemPropertiesClassName)
        val get = clazz.getMethod("get", String::class.java, Long::class.java)
        return get.invoke(clazz, name, defaultValue) as Long
    } catch (ignore: Exception) {
    }
    return defaultValue
}

@SuppressLint("PrivateApi")
fun getProperty(name: String, defaultValue: Boolean = false): Boolean {
    try {
        val clazz = Class.forName(SystemPropertiesClassName)
        val get = clazz.getMethod("get", String::class.java, Boolean::class.java)
        return get.invoke(clazz, name, defaultValue) as Boolean
    } catch (ignore: Exception) {
    }
    return defaultValue
}

@SuppressLint("PrivateApi")
fun setProperty(key: String, value: String) {
    try {
        val clazz = Class.forName(SystemPropertiesClassName)
        val set = clazz.getMethod("set", String::class.java, String::class.java)
        set.invoke(clazz, key, value)
    } catch (ignore: Exception) {
    }
}