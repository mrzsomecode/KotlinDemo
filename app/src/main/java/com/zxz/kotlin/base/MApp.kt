package com.zxz.kotlin.base

import android.app.Application
import com.zxz.kotlin.dagger.component.ApiComponent
import com.zxz.kotlin.dagger.component.DaggerApiComponent
import com.zxz.kotlin.dagger.module.ApiModule
import javax.inject.Inject


/**
 * Created by zxz on 2017/7/6.
 */
class MApp : Application() {
    init {
        instance = this
    }

    @Inject lateinit var api: ApiComponent
    override fun onCreate() {
        super.onCreate()
        DaggerApiComponent.builder().apiModule(ApiModule(this)).build().inject(this)
    }

    companion object {
        lateinit var instance: MApp
    }

}
