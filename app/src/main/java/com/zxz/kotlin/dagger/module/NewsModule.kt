package com.zxz.kotlin.dagger.module

import com.zxz.kotlin.mvp.contract.NewsContract
import dagger.Module
import dagger.Provides

/**
 * Created by zxz on 2017/7/6.
 */
@Module
class NewsModule(val view: NewsContract.INewsView) {
    @Provides fun provideView() = view
}