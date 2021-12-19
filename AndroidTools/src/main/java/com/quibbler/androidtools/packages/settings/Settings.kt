package com.quibbler.androidtools.packages.settings

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings

public fun openAppDetails(context: Context) {
    openInstalledAppDetails(context, context.packageName)
}

public fun openInstalledAppDetails(context: Context, packageName: String) {
    val intent: Intent = Intent()
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
    intent.data = Uri.fromParts("package", packageName, null)
    context.startActivity(intent)
}

