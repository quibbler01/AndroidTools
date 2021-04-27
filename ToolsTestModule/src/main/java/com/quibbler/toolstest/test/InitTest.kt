package com.quibbler.toolstest.test

import com.quibbler.androidtools.AndroidTools

class InitTest {

    fun test() {
        assert(AndroidTools.getContext() != null)
    }

}