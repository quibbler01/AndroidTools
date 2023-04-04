package com.quibbler.toolstest

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.quibbler.androidtools.packages.settings.*
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
            openThisAppDetails(this)
        }
        testBinding.settingsOther.setOnClickListener {
            openInstalledAppDetailsByName(this, "com.tencent.mm")
        }

        testBinding.notification.setOnClickListener {
            openThisAppNotification(this)
        }
        testBinding.notificationOther.setOnClickListener {
            openAppNotification(this, "com.tencent.mm")
        }
        testBinding.notificationEnable.text = "Notification: ${isNotificationsEnabled(this)}"



        window.attributes.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES

    }

}