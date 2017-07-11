package com.zxz.kotlin.utils

import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.view.View


/**
 * Created by zxz on 2017/7/7.
 */
class BottomNavigationViewBehavior : CoordinatorLayout.Behavior<View>() {
    override fun onLayoutChild(parent: CoordinatorLayout, child: View, layoutDirection: Int): Boolean {
        (child.getLayoutParams() as CoordinatorLayout.LayoutParams).topMargin = parent.measuredHeight - child.getMeasuredHeight()
        return super.onLayoutChild(parent, child, layoutDirection)
    }

    override fun layoutDependsOn(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        return true
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        //得到依赖View的滑动距离
        val top = ((dependency.getLayoutParams() as CoordinatorLayout.LayoutParams).behavior as AppBarLayout.Behavior).topAndBottomOffset
        //因为BottomNavigation的滑动与ToolBar是反向的，所以取-top值
        ViewCompat.setTranslationY(child, (-top).toFloat())
        return false
    }

    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout?, child: View?, target: View?, dx: Int, dy: Int, consumed: IntArray?) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed)

    }
}