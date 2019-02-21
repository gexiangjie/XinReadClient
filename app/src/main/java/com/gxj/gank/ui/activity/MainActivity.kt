package com.gxj.gank.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import com.gxj.gank.R
import com.gxj.gank.ui.fragment.HomeFragment
import com.gxj.gank.ui.fragment.MineFragment
import com.gxj.gank.ui.fragment.SortFragment
import com.gxj.gank.ui.fragment.WelfareFragment
import com.gxj.gank.util.disableShiftMode
import com.gxj.gank.util.setUpWithViewPager
import kotlinx.android.synthetic.main.activity_main.bottom_navigation
import kotlinx.android.synthetic.main.activity_main.view_pager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.disableShiftMode()
        view_pager.adapter = BottomPagerAdapter(supportFragmentManager)
        view_pager.offscreenPageLimit = 3
        bottom_navigation.setUpWithViewPager(view_pager)
    }

    inner class BottomPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getItem(p0: Int): Fragment {
            return when (p0) {
                0 -> HomeFragment()
                1 -> SortFragment()
                2 -> WelfareFragment()
                else -> MineFragment()
            }
        }

        override fun getCount() = 2
    }
}
