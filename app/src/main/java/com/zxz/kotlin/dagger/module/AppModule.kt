package com.zxz.kotlin.dagger.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by zxz on 2017/7/6.
 */
@Module
class AppModule(val context: Context) {
    @Provides fun provideContext() = context
}
