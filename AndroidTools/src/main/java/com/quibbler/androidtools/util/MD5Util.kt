package com.quibbler.androidtools.util

import android.util.Log
import com.quibbler.androidtools.AndroidTools.TAG
import java.lang.StringBuilder
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 *
 */
private val HEX_DIGITS = charArrayOf(
    '0', '1', '2', '3', '4', '5',
    '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
)

/**
 *
 * @param s String?
 * @return String?
 */
fun encodeStr2MD5(s: String?): String? {
    if (s == null || s.isEmpty()) return null
    try {
        val digest = MessageDigest.getInstance("MD5")
        digest.update(s.toByteArray())
        val messageDigest = digest.digest()
        return toHexString(messageDigest)
    } catch (e: NoSuchAlgorithmException) {
        Log.e(TAG, "encodeStr2MD5 error: ${e.message}")
    }
    return s
}

/**
 *
 * @param b ByteArray
 * @return String
 */
private fun toHexString(b: ByteArray): String {
    val sb = StringBuilder(b.size * 2)
    for (i in b.indices) {
        sb.append(HEX_DIGITS[b[i].toInt() and 0xf0 ushr 4])
        sb.append(HEX_DIGITS[b[i].toInt() and 0x0f])
    }
    return sb.toString()
}
