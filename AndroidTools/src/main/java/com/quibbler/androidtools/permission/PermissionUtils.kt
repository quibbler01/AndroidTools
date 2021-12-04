package com.quibbler.androidtools.permission

import android.content.pm.PackageManager
import android.os.Build
import com.quibbler.androidtools.AndroidTools

fun checkPermission(vararg permissions: String): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        for (permission in permissions) {
            if (AndroidTools.getContext().checkSelfPermission(permission) == PackageManager.PERMISSION_DENIED) {
                return false
            }
        }
        return true
    } else {
        return true
    }

}