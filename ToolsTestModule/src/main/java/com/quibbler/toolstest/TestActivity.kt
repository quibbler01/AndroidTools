package com.quibbler.toolstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quibbler.androidtools.packages.settings.openAppDetails
import com.quibbler.androidtools.packages.settings.openInstalledAppDetails
import com.quibbler.toolstest.databinding.ActivityTestBinding
import com.quibbler.toolstest.test.InitTest
import com.quibbler.toolstest.test.PackageUtilTest
import com.quibbler.toolstest.test.ResUtilTest

class TestActivity : AppCompatActivity() {

    lateinit var testBinding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        testBinding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(testBinding.root)

        InitTest().test()

        ResUtilTest.test(this)

        PackageUtilTest().test()

        testBinding.settings.setOnClickListener {
            openAppDetails(this)
        }
        testBinding.settingsOther.setOnClickListener {
            openInstalledAppDetails(this, "com.tencent.mm")
        }
    }

}