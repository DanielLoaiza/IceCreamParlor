package com.dafelo.icecreamparlor.common

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.RelativeLayout


class RoundedRelativeLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {


    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        val paint = Paint()
        paint.color = Color.BLUE
        canvas.drawCircle(x, y, 90f, Paint())
    }
}
