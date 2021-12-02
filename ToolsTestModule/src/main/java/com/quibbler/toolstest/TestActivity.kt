package com.quibbler.toolstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quibbler.toolstest.test.InitTest
import com.quibbler.toolstest.test.PackageUtilTest
import com.quibbler.toolstest.test.ResUtilTest

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        InitTest().test()

        ResUtilTest.test(this)

        PackageUtilTest().test()
    }

}