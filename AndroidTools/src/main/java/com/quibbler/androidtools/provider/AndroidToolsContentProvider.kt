package com.quibbler.androidtools.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.util.Log
import com.quibbler.androidtools.AndroidTools
import com.quibbler.androidtools.AndroidTools.TAG

/**
 *
 */
class AndroidToolsContentProvider : ContentProvider() {

    /**
     * get [Context] through this ContextProvider to init [AndroidTools]
     */
    override fun onCreate(): Boolean {
        Log.d(TAG, "AndroidToolsContentProvider ${context != null}")
        AndroidTools.init(context)
        return true
    }


    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        return 0
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        return null
    }

    override fun getType(uri: Uri): String? {
        return null
    }

}