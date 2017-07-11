package com.zxz.kotlin.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.zxz.kotlin.R
import com.zxz.kotlin.fragment.GirlsFragment
import com.zxz.kotlin.fragment.NewsFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : FragmentActivity() {
    lateinit var newsFragment: NewsFragment
    lateinit var girlsFragment: GirlsFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
        initBottom()
    }


    private fun initFragment() {
        newsFragment = NewsFragment()
        girlsFragment = GirlsFragment()
        var tr = supportFragmentManager.beginTransaction()
        tr.add(R.id.contentPanel, newsFragment)
                .add(R.id.contentPanel, girlsFragment)
                .hide(girlsFragment)
                .show(newsFragment)
        tr.commit()

    }

    private fun initBottom() {
        bottomTab.setMode(BottomNavigationBar.MODE_DEFAULT)
        bottomTab.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        bottomTab.setFab(fab_home)
        bottomTab.addItem(BottomNavigationItem(R.drawable.news_icon, "news").setActiveColor("#079dfe"))
                .addItem(BottomNavigationItem(R.drawable.girls_icon, "girls").setActiveColor(Color.RED))
                .addItem(BottomNavigationItem(R.drawable.weather_00, "weather").setActiveColor("#079dfe"))
                .setFirstSelectedPosition(0)
                .initialise()
    }

}

