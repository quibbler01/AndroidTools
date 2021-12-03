package com.quibbler.androidtools.image

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import org.jetbrains.annotations.Nullable

/**
 * This tool class is used to store tool methods related to pictures
 */
object BitmapUtils {

    /**
     * Calculate the memory size of the given [Bitmap]
     */
    @SuppressLint("ObsoleteSdkInt")
    fun calculateBitmapSize(@Nullable bitmap: Bitmap?): Int {
        return when {
            bitmap == null -> 0         //return 0 when bitmap is null
            bitmap.isRecycled -> 0      //or bitmap is recycled
            Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT -> bitmap.allocationByteCount
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1 -> bitmap.byteCount
            else -> bitmap.rowBytes * bitmap.height
        }
    }

}