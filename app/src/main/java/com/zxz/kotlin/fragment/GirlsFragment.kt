package com.zxz.kotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zxz.kotlin.widget.GradientTextView

/**
 * Created by zxz on 2017/7/10.
 */
class GirlsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = GradientTextView(context)
        view.change(2f)
        view.text = "测试问童子"
        return view
    }
}