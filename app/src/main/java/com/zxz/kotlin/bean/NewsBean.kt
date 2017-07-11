package com.zxz.kotlin.bean

/**
 * Created by zxz on 2017/7/6.
 */

data class NewsBean(var stat: String, var data: List<DataBean>) {
    data class DataBean(
            var uniquekey: String,
            var title: String,
            var date: String,
            var category: String,
            var author_name: String,
            var url: String,
            var thumbnail_pic_s: String?,
            var thumbnail_pic_s02: String?,
            var thumbnail_pic_s03: String?)
}
