package com.quibbler.androidtools.framework

import android.annotation.SuppressLint
import android.os.Looper
import android.os.MessageQueue
import org.jetbrains.annotations.TestOnly
import java.lang.Exception
import java.util.concurrent.CopyOnWriteArraySet

@Deprecated("Never use SyncBarrier in your app.")
object SyncBarrierUtil {

    /**
     * global [Set] record all SyncBarrier Tokens.
     */
    private val tokens: MutableSet<Int> = CopyOnWriteArraySet<Int>()

    @SuppressLint("DiscouragedPrivateApi")
    fun postSyncBarrier(): Int {
        var token = -1
        try {
            val method = MessageQueue::class.java.getDeclaredMethod("postSyncBarrier")
            token = method.invoke(Looper.getMainLooper().queue) as Int
            tokens.add(token)
        } catch (ignore: Exception) {
        }
        return token
    }

    @SuppressLint("DiscouragedPrivateApi")
    fun removeSyncBarrier(token: Int) {
        if (!tokens.contains(token)) return
        try {
            val method = MessageQueue::class.java.getDeclaredMethod("removeSyncBarrier", Int::class.javaPrimitiveType)
            method.invoke(Looper.getMainLooper().queue, token)
            tokens.remove(token)
        } catch (ignore: Exception) {
        }
    }

    /**
     * remove all SyncBarrier.
     */
    @TestOnly
    public fun releaseAllSyncBarrier() {
        for (token in tokens) {
            removeSyncBarrier(token)
        }
    }

}