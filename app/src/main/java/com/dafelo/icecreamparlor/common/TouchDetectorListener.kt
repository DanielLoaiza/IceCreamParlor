package com.dafelo.icecreamparlor.common

import android.view.View

interface TouchDetectorListener {
    fun onDoubleTap(v: View?)
    fun onTripleTap(v: View?)
}