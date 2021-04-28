package com.quibbler.androidtools

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * To determine whether the current mobile phone has an available network,
 * permission [android.Manifest.permission.ACCESS_NETWORK_STATE] is required.
 */
@Deprecated("use ConnectivityManager.NetworkCallback instead")
fun isNetworkAvailable(): Boolean {
    val connectivityManager: ConnectivityManager = AndroidTools.getContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network: NetworkInfo? = connectivityManager.activeNetworkInfo
    return if (network != null) {
        network.isConnected
    } else false
}