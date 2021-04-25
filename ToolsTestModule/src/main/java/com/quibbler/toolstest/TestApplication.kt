package com.quibbler.toolstest

import android.app.Application
import com.quibbler.androidtools.AndroidTools

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidTools.init(this)
    }

}