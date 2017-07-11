package com.zxz.kotlin.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zxz.kotlin.R
import com.zxz.kotlin.bean.NewsBean
import com.zxz.kotlin.widget.MultipleImageView

/**
 * Created by zxz on 2017/7/7.
 */
class NewsAdapter(layoutRes: Int, datas: List<NewsBean.DataBean>?) : BaseQuickAdapter<NewsBean.DataBean, BaseViewHolder>(layoutRes, datas) {
    override fun convert(helper: BaseViewHolder, item: NewsBean.DataBean) {
        val title: TextView = helper.getView(R.id.news_title)
        val images: MultipleImageView = helper.getView(R.id.news_img)
        val info: TextView = helper.getView(R.id.news_info)
        title.text = item.title
        info.text = item.author_name + "  " + item.date
        images.refresh(listOfNotNull(item.thumbnail_pic_s, item.thumbnail_pic_s02, item.thumbnail_pic_s03))
    }


}