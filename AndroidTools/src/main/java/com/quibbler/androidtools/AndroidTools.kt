package com.quibbler.androidtools

import android.app.Application
import android.content.Context
import java.lang.Exception

/**
 * This tool library provides developers with various tools and methods commonly used in Android development.
 * Usually there is no need to initialize manually,
 * but developers can manually initialize the library through the [init] method and pass in an application Application
 */
object AndroidTools {

    /**
     * Print the TAG of Log during debugging
     */
    public const val TAG: String = "TAG_AndroidTools"

    /**
     * [Application] instance of the current application
     */
    private lateinit var application: Application

    /**
     * Whenever Context is needed, obtain a non-empty Context instance through this method
     */
    fun getContext(): Application {
        return application
    }

    /**
     * If the Application has not been initialized,
     * the developer can use this method to initialize the tool library
     */
    fun init(context: Context?) {
        if (context is Application) {
            application = context
        } else if (context is Context) {
            application = context.applicationContext as Application
        }
    }

}