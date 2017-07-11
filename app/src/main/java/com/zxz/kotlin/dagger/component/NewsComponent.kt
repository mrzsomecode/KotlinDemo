package com.zxz.kotlin.dagger.component

import com.zxz.kotlin.dagger.module.NewsModule
import com.zxz.kotlin.fragment.NewsChildFragment
import dagger.Subcomponent

/**
 * Created by zxz on 2017/7/6.
 */
@Subcomponent(modules = arrayOf(NewsModule::class))
interface NewsComponent {
    fun inject(o: NewsChildFragment)
}
