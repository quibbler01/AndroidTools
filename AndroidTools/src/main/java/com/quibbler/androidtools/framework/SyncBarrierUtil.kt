package com.quibbler.androidtools.framework

import android.annotation.SuppressLint
import android.os.Looper
import android.os.MessageQueue
import java.lang.Exception

@Deprecated("Never use SyncBarrier in your app.")
object SyncBarrierUtil {

    @SuppressLint("DiscouragedPrivateApi")
    fun postSyncBarrier(): Int {
        var token = -1
        try {
            val method = MessageQueue::class.java.getDeclaredMethod("postSyncBarrier")
            token = method.invoke(Looper.getMainLooper().queue) as Int
        } catch (ignore: Exception) {
        }
        return token
    }

    @SuppressLint("DiscouragedPrivateApi")
    fun removeSyncBarrier(token: Int) {
        try {
            val method = MessageQueue::class.java.getDeclaredMethod("removeSyncBarrier", Int::class.javaPrimitiveType)
            method.invoke(Looper.getMainLooper().queue, token)
        } catch (ignore: Exception) {
        }
    }

}