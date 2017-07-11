package com.zxz.kotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flyco.tablayout.SlidingTabLayout
import com.zxz.kotlin.R

/**
 * Created by zxz on 2017/7/10.
 */
class NewsFragment : Fragment() {

    var content: View? = null
    var topTab: SlidingTabLayout? = null
    var viewPage: ViewPager? = null

    companion object {
        var types = listOf(Pair("top", "头条"), Pair("shehui", "社会"), Pair("guonei", "国内"), Pair("guoji", "国际"),
                Pair("yule", "娱乐"), Pair("tiyu", "体育"), Pair("junshi", "军事"), Pair("keji", "科技"),
                Pair("caijing", "财经"), Pair("shishang", "时尚"))
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (content == null) {
            content = View.inflate(context, R.layout.fragment_news, null)
            topTab = content!!.findViewById(R.id.topTab) as SlidingTabLayout
            viewPage = content!!.findViewById(R.id.viewPage) as ViewPager
            viewPage!!.adapter = NewsAdapter(childFragmentManager)
            topTab!!.setViewPager(viewPage)
        }
        return content
    }

    class NewsAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getPageTitle(position: Int) = types[position].second

        override fun getCount() = types.size

        override fun getItem(position: Int) = NewsChildFragment.create(types[position].first)

    }
    /**
     * Anko 感觉还是不够成熟，不好用，可能还没用会吧,展现出来的效果贼奇怪
     * 用xml习惯了，没有感觉到DSL好在哪里
     */
    //    private fun createView() = UI {
//        relativeLayout {
//            var tab = tabLayout {
//                id = 1
//                backgroundColor = R.color.gray
//            }.lparams(matchParent, wrapContent)
//            var pager = viewPager {
//                id = 2
//            }.lparams(matchParent, matchParent) {
//                below(tab)
//            }
//            var text = gradientTextView().lparams(wrapContent, wrapContent) {
//                centerInParent()
//            }
//            text.text = "测试"
//            tab.setTabTextColors(R.color.tab_normal_color, R.color.tab_selected_color)
//            tab.setupWithViewPager(pager)
//            tab.tabMode = TabLayout.MODE_SCROLLABLE
//            pager.adapter = NewsAdapter(owner.childFragmentManager)
//            pager.addOnPageChangeListener(owner as NewsFragment)
//        }
//    }.view

}