package com.quibbler.androidtools.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.quibbler.androidtools.AndroidTools

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


/**
 * Get the type information of the current network connection
 */
fun getConnectedType(): Int {
    val mConnectivityManager: ConnectivityManager = AndroidTools.getContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val mNetworkInfo: NetworkInfo? = mConnectivityManager.getActiveNetworkInfo()
    if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
        return mNetworkInfo.getType();
    }
    return -1;
}