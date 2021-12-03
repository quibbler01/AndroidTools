package com.quibbler.toolstest.test

import android.util.Log
import com.quibbler.androidtools.AndroidTools.TAG
import com.quibbler.androidtools.packages.PackageUtil

class PackageUtilTest {

    fun test() {
        Log.d(
            TAG,
            "is package [com.huawei.calculator] installed? " + PackageUtil.isAppInstalled("com.huawei.calculator")
        )
    }

}