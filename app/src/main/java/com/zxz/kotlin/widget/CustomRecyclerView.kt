package com.zxz.kotlin.widget

import `in`.srain.cube.views.ptr.*
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.zxz.kotlin.R

/**
 * 下拉刷新
 * Created by zxz on 2017/7/11.
 */
class CustomRecyclerView : FrameLayout, PtrHandler {
    var refHander: RefreshHander? = null
    var recyclerView: RecyclerView
    var ptrView: PtrClassicFrameLayout

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        View.inflate(context, R.layout.custom_recyclerview, this)
        recyclerView = findViewById(R.id.custom_recycler) as RecyclerView
        //default LinearLayoutManager.VERTICAL
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        ptrView = findViewById(R.id.custom_ptr) as PtrClassicFrameLayout
        ptrView.addPtrUIHandler(PtrClassicDefaultHeader(context))
        ptrView.setPtrHandler(this)
    }

    /**
     * 开始刷新
     */
    override fun onRefreshBegin(p0: PtrFrameLayout) {
        refHander?.onRefreshBegin(p0)
    }

    /**
     * 是否可以刷新
     */
    override fun checkCanDoRefresh(frame: PtrFrameLayout?, content: View?, header: View?) =
            PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header)

    /**
     * 刷新完成
     */
    fun refreshComplete() {
        ptrView.refreshComplete()
    }

    interface RefreshHander {
        fun onRefreshBegin(prtFrame: PtrFrameLayout)
    }
}