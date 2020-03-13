package com.dafelo.icecreamparlor.common

import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration


class TabDetectorListener(private val listener: TouchDetectorListener) : View.OnTouchListener {
    var handler: Handler = Handler()

    var numberOfTaps = 0
    var lastTapTimeMs: Long = 0
    var touchDownMs: Long = 0

    override fun onTouch(v: View?, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> touchDownMs = System.currentTimeMillis()
            MotionEvent.ACTION_UP -> {
                handler.removeCallbacksAndMessages(null)
                if (System.currentTimeMillis() - touchDownMs > ViewConfiguration.getTapTimeout()) {
                    //it was not a tap
                    numberOfTaps = 0
                    lastTapTimeMs = 0
                } else {
                    if (numberOfTaps > 0
                        && System.currentTimeMillis() - lastTapTimeMs < ViewConfiguration.getDoubleTapTimeout()
                    ) {
                        numberOfTaps += 1
                    } else {
                        numberOfTaps = 1
                    }
                    lastTapTimeMs = System.currentTimeMillis()
                    if (numberOfTaps == 3) {
                       listener.onTripleTap(v)
                    } else if (numberOfTaps == 2) {
                        handler.postDelayed(Runnable { //handle double tap
                            listener.onDoubleTap(v)
                        }, ViewConfiguration.getDoubleTapTimeout().toLong())
                    }
                }
            }

        }
        return true
    }

}