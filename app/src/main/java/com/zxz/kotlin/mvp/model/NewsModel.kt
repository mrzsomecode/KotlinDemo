package com.zxz.kotlin.mvp.model

import com.zxz.kotlin.api.NewsApi
import com.zxz.kotlin.utils.Constans
import com.zxz.kotlin.bean.BaseResult
import com.zxz.kotlin.bean.NewsBean
import com.zxz.kotlin.mvp.contract.NewsContract
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by zxz on 2017/7/6.
 */
class NewsModel @Inject constructor(val newsApi: NewsApi) : BaseModel(), NewsContract.INewsModel {
    override fun getData(type: String): Observable<BaseResult<NewsBean>> = newsApi.getNews(type, Constans.NEWS_KEY).compose(schedulers())
}