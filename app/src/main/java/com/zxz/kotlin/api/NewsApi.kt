package com.zxz.kotlin.api

import com.zxz.kotlin.bean.BaseResult
import com.zxz.kotlin.bean.NewsBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by zxz on 2017/7/6.
 */
interface NewsApi {
    @GET("toutiao/index")
    fun getNews(@Query("type") page: String, @Query("key") appkey: String): Observable<BaseResult<NewsBean>>
}