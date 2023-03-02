package com.quibbler.androidtools.packages

import android.content.pm.PackageInfo
import android.content.pm.PackageManager.NameNotFoundException
import android.text.TextUtils
import com.quibbler.androidtools.AndroidTools

object PackageUtil {

    /**
     * Determine whether the application is installed based on the package name
     */
    fun isAppInstalled(packageName: String): Boolean {
        //package name should not be empty
        if (TextUtils.isEmpty(packageName)) {
            return false
        }
        val packageManager = AndroidTools.getContext().packageManager
        return try {
            val info: PackageInfo? = packageManager.getPackageInfo(packageName, 0)
            info != null
        } catch (ignore: NameNotFoundException) {
            false
        }
    }

}