package com.zxz.kotlin.mvp.presenter

import android.util.Log
import com.zxz.kotlin.bean.BaseResult
import com.zxz.kotlin.mvp.contract.BaseView
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by zxz on 2017/7/6.
 */
open class BasePresenter<out T : BaseView>(val mView: T) {
    /**
     * Rx任务管理
     */
    protected var compositeDisposable = CompositeDisposable()

    protected fun <T> addDisposable(subscription: Observable<T>, next: (T) -> Unit) {
        compositeDisposable.add(subscription.subscribe(next, {
            it.printStackTrace()
        }, { Log.e(javaClass.simpleName, "ok") }))
    }

    protected fun dispose() {
        compositeDisposable.clear()
    }

    protected fun judgeData(data: BaseResult<out Any>) =
            if (data.errorCode == 0) {
                true
            } else {
                mView.showErr(data.reason, data.errorCode)
                false
            }

}