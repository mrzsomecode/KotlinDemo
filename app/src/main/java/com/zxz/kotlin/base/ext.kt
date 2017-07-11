package com.zxz.kotlin.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import com.zxz.kotlin.mvp.contract.BaseView
import com.zxz.kotlin.utils.activitytransition.ActivityTransitionLauncher

/**
 * Created by zxz on 2017/7/6.
 */
fun Activity.startActivity(context: Activity, view: View, params: Bundle) {
    intent = Intent(context, classLoader.javaClass)
    intent.putExtras(params)
    intent.putExtras(ActivityTransitionLauncher.with(context).from(view).createBundle())
    context.startActivity(intent)
}

fun Activity.startActivity(context: Context, params: Bundle) {
    intent = Intent(context, classLoader.javaClass)
    intent.putExtras(params)
    context.startActivity(intent)
}

fun Activity.log(msg: String) {
    Log.e(localClassName, msg)
}

fun Fragment.log(msg: String) {
    Log.e(javaClass.simpleName, msg)
}

fun BaseView.getMainComponent() = MApp.instance.api

//public inline fun ViewManager.gradientTextView() = gradientTextView {}
//
//public inline fun ViewManager.gradientTextView(init: GradientTextView.() -> Unit) = ankoView({ GradientTextView(it) }, 0, init)
