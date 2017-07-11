package com.zxz.kotlin.fragment

import `in`.srain.cube.views.ptr.PtrFrameLayout
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.zxz.kotlin.R
import com.zxz.kotlin.adapter.NewsAdapter
import com.zxz.kotlin.base.getMainComponent
import com.zxz.kotlin.bean.NewsBean
import com.zxz.kotlin.bean.Page
import com.zxz.kotlin.dagger.module.NewsModule
import com.zxz.kotlin.mvp.contract.NewsContract
import com.zxz.kotlin.mvp.presenter.NewsPresenter
import com.zxz.kotlin.utils.Toastor
import com.zxz.kotlin.widget.CustomRecyclerView
import kotlinx.android.synthetic.main.custom_recyclerview.view.*
import javax.inject.Inject


/**
 * NewsChild-Type
 * Created by zxz on 2017/7/7.
 */
class NewsChildFragment : Fragment(), NewsContract.INewsView, CustomRecyclerView.RefreshHander, BaseQuickAdapter.RequestLoadMoreListener {

    lateinit var newsAdapter: NewsAdapter
    lateinit var type: String
    @Inject lateinit var newsPresenter: NewsPresenter
    var contentView: CustomRecyclerView? = null
    var page = Page(1, 10)

    companion object {
        fun create(type: String) = with(type) {
            var news = NewsChildFragment()
            val args = Bundle()
            args.putString("type", type)
            news.arguments = args
            news
        }
    }

    /**
     * 数据加载成功
     */
    override fun setData(news: List<NewsBean.DataBean>) {
        newsAdapter.setNewData(news)
        contentView!!.refreshComplete()
    }

    /**
     * 加载更多
     */
    override fun onLoadMoreRequested() {
        page.page++
        getData()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (arguments != null) {
            type = arguments.getString("type")
        }
        getMainComponent().plus(NewsModule(this)).inject(this)
    }

    /**
     * the Null-security Really too CaoDan,Each must be used '!!'
     * set lateinit contentView ... or contentView ...=null!! 编译没问题，运行就会报错
     * 不知道这里最优的写法是什么
     */
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (contentView == null) {
            contentView = CustomRecyclerView(context)
            //适配器，加载更多
            newsAdapter = NewsAdapter(R.layout.news_single_img_item, null)
            newsAdapter.setOnLoadMoreListener(this, contentView!!.custom_recycler)
            newsAdapter.setEnableLoadMore(true)
            contentView!!.recyclerView.adapter = newsAdapter
            contentView!!.refHander = this
            contentView!!.ptrView.autoRefresh()
            getData()
        }
        return contentView
    }

    /**
     * 刷新
     */
    override fun onRefreshBegin(prtFrame: PtrFrameLayout) {
        page.page = 1
        getData()
    }

    fun getData() {
        newsPresenter.getData(type, page)
    }

    /**
     * 加载失败了
     */
    override fun showErr(msg: String, code: Int) {
        if (code == NewsPresenter.ERR_CODE_NOT_MORE)
            newsAdapter.setEnableLoadMore(false)
        Toastor.shortToast(context, msg)
    }

}