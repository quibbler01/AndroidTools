package com.quibbler.androidtools.packages.settings

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.core.app.NotificationManagerCompat
import com.quibbler.androidtools.packages.startActivitySafely

public fun openThisAppDetails(context: Context) {
    openInstalledAppDetailsByName(context, context.packageName)
}

public fun openInstalledAppDetailsByName(context: Context, packageName: String) {
    val intent: Intent = Intent()
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
    intent.data = Uri.fromParts("package", packageName, null)
    startActivitySafely(context, intent)
}

public fun openThisAppNotification(context: Context) {
    openAppNotification(context, context.packageName)
}

public fun openAppNotification(context: Context, packageName: String) {
    val intent: Intent = Intent()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        intent.action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, packageName);
        //intent.putExtra(Settings.EXTRA_CHANNEL_ID, context.applicationInfo.uid);
    } else {
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        intent.putExtra("app_package", packageName)
        //intent.putExtra("app_uid", context.applicationInfo.uid)
    }
    startActivitySafely(context, intent)
}

public fun isNotificationsEnabled(context: Context): Boolean {
    val notificationManager = NotificationManagerCompat.from(context)
    return notificationManager.areNotificationsEnabled()
}
