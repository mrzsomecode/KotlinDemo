package com.zxz.kotlin.utils

import android.content.Context
import android.widget.Toast


/**
 * Created by Administrator on 2017/5/2.
 */

object Toastor {
    private var toast: Toast? = null

    // 长吐司
    fun longToast(context: Context, text: String) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_LONG)
        }
        toast!!.setText(text)
        toast!!.duration = Toast.LENGTH_LONG
        toast!!.show()
    }

    // 短吐司
    fun shortToast(context: Context, text: String) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
        }
        toast!!.setText(text)
        toast!!.duration = Toast.LENGTH_SHORT
        toast!!.show()
    }

    fun shortErr(context: Context) {
        shortToast(context, "网络异常")
    }

    fun shortToast(context: Context, textId: Int) {
        if (toast == null) {
            toast = Toast.makeText(context, context.getString(textId), Toast.LENGTH_SHORT)
        }
        toast!!.setText(context.getString(textId))
        toast!!.duration = Toast.LENGTH_SHORT
        toast!!.show()
    }
}
