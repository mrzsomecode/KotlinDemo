package com.zxz.kotlin.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.File

/**
 * Created by zxz on 2017/7/10.
 */
class ImageLoder {
    companion object {
        fun load(context: Context, url: String, toView: ImageView) {
            Glide.with(context).load(url).into(toView)
        }

        fun load(context: Context, file: File, toView: ImageView) {
            Glide.with(context).load(file).into(toView)
        }

        fun load(context: Context, res: Int, toView: ImageView) {
            Glide.with(context).load(res).into(toView)
        }
    }
}