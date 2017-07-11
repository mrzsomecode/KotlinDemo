package com.zxz.kotlin.dagger.component

import com.zxz.kotlin.base.MApp
import com.zxz.kotlin.dagger.module.ApiModule
import com.zxz.kotlin.dagger.module.NewsModule
import dagger.Component

/**
 * Created by zxz on 2017/7/6.
 */
@Component(modules = arrayOf(ApiModule::class))
interface ApiComponent {
    fun inject(app: MApp)
    fun plus(newsModule: NewsModule): NewsComponent
}