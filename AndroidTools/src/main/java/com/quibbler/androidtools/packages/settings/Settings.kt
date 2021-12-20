package com.quibbler.androidtools.packages.settings

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.core.app.NotificationManagerCompat

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

public fun openAppNotification(context: Context) {
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
    context.startActivity(intent)
}

public fun isNotificationsEnabled(context: Context): Boolean {
    val notificationManager = NotificationManagerCompat.from(context)
    return notificationManager.areNotificationsEnabled()
}
