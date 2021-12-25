package com.quibbler.androidtools.framework;

import android.os.Looper;
import android.os.MessageQueue;

import java.lang.reflect.Method;

@Deprecated
public class SyncBarrierUtil {

    public static int postSyncBarrier() {
        int token = -1;
        try {
            Method method = MessageQueue.class.getDeclaredMethod("postSyncBarrier");
            token = (int) method.invoke(Looper.getMainLooper().getQueue());
        } catch (Exception ignore) {

        }
        return token;
    }

    public static void removeSyncBarrier(int token) {
        try {
            Method method = MessageQueue.class.getDeclaredMethod("removeSyncBarrier", int.class);
            method.invoke(Looper.getMainLooper().getQueue(), token);
        } catch (Exception ignore) {

        }
    }

}
