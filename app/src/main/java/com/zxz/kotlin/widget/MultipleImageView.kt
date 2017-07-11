package com.zxz.kotlin.widget

import android.content.Context
import android.util.AttributeSet
import android.util.SparseArray
import android.widget.ImageView
import android.widget.LinearLayout
import com.zxz.kotlin.utils.ImageLoder

/**
 * Created by zxz on 2017/7/10.
 */
class MultipleImageView : LinearLayout {
    var imgUrls: List<String> = ArrayList()
    val views = SparseArray<ImageView>()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun refresh(imgs: List<String>) {
        imgUrls = imgs
        creatImageView()
    }

    private fun creatImageView() {
        removeAllViews()
        for (i in imgUrls.indices) {
            var imgView = views.get(i)
            if (imgView == null) {
                imgView = ImageView(context)
                var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
                params.weight = 1f
                params.rightMargin = if (i < imgUrls.size) 4 else 0
                imgView.layoutParams=params
                views.put(i, imgView)
            }
            addView(imgView)
            ImageLoder.load(context, imgUrls[i], imgView)
        }
    }
}

