package com.zxz.kotlin.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.Shader
import android.util.AttributeSet
import android.widget.TextView
import com.zxz.kotlin.R

/**
 * Created by zxz on 2017/7/10.
 */
class GradientTextView : TextView {
    var pro: Float = 0f
    var mTranslate = 0f
    var normalColor: Int = 0
    var selectedColor: Int = 0
    var mGradientMatrix = Matrix()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        normalColor = resources.getColor(R.color.tab_normal_color)
        selectedColor = resources.getColor(R.color.tab_selected_color)
    }

    fun change(pro: Float) {
        mTranslate += measuredWidth * pro
        mGradientMatrix.setTranslate(measuredWidth * pro, 0f)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val mShader = if (pro > 0)
            LinearGradient(measuredWidth * 1.0f, 0f, 0f, 0f,
                    intArrayOf(normalColor, selectedColor),
                    null, Shader.TileMode.REPEAT)
        else
            LinearGradient(measuredWidth * 1.0f, 0f, measuredWidth * 1.0f, 0f,
                    intArrayOf(normalColor, selectedColor),
                    null, Shader.TileMode.REPEAT)
        mShader.getLocalMatrix(mGradientMatrix)
        paint.shader = mShader
    }
}