package com.zxz.kotlin.mvp.contract

import com.zxz.kotlin.bean.BaseResult
import com.zxz.kotlin.bean.NewsBean
import com.zxz.kotlin.bean.Page
import io.reactivex.Observable

/**
 * Created by zxz on 2017/7/5.
 */
interface NewsContract {
    interface INewsModel {
        fun getData(type: String): Observable<BaseResult<NewsBean>>
    }

    interface INewsView : BaseView {
        fun setData(news: List<NewsBean.DataBean>)
    }

    interface INewsPresenter {
        fun getData(type: String, page: Page)
    }
}