package com.zxz.kotlin.activity

import android.app.Activity
import android.os.Bundle

import com.zxz.kotlin.R

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
