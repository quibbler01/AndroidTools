package com.quibbler.androidtools.framework

object CrashHandler : Thread.UncaughtExceptionHandler {

    override fun uncaughtException(t: Thread, e: Throwable) {
        TODO("1.Report crash 2.Restart App 3.Save logs 4.Kill process")
    }

    /**
     * set UncaughtExceptionHandler setUncaughtExceptionHandler(UncaughtExceptionHandler eh)
     *
     * @param thread Thread
     */
    fun setCrashHandler(thread: Thread) {
        thread.uncaughtExceptionHandler = this
    }

    public fun init() {
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

}