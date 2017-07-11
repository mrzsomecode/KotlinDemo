package com.zxz.kotlin.mvp.presenter

import com.zxz.kotlin.bean.NewsBean
import com.zxz.kotlin.bean.Page
import com.zxz.kotlin.mvp.contract.NewsContract
import com.zxz.kotlin.mvp.model.NewsModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by zxz on 2017/7/6.
 */
class NewsPresenter @Inject constructor(val newsModel: NewsModel, mView: NewsContract.INewsView)
    : BasePresenter<NewsContract.INewsView>(mView), NewsContract.INewsPresenter {
    companion object {
        val ERR_CODE_NOT_MORE = 0
    }

    var newsDatas: List<NewsBean.DataBean>? = null

    override fun getData(type: String, page: Page) {
        if (newsDatas == null || newsDatas!!.isEmpty()) {
            addDisposable(newsModel.getData(type), {
                if (judgeData(it)) {
                    this.newsDatas = it.result.data
                    newsChange(page)
                }
            })
        } else {
            Observable.timer(500, TimeUnit.MILLISECONDS)
                    .compose(newsModel.schedulers())
                    .subscribe({
                        newsChange(page)
                    })
        }

    }

    private fun newsChange(page: Page) {
        var lastIndex = page.page * page.showCount
        if (newsDatas != null && lastIndex < newsDatas!!.size)
            mView.setData(newsDatas!!.subList(0, page.page * page.showCount))
        else
            mView.showErr("没有更多了", ERR_CODE_NOT_MORE)
    }

}