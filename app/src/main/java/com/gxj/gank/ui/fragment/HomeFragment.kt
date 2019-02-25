package com.gxj.gank.ui.fragment

import android.arch.lifecycle.Observer
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.gxj.base.base.BaseFragment
import com.gxj.gank.R
import com.gxj.gank.bean.DailyData
import com.gxj.gank.ui.adapter.HomeAdapter
import com.gxj.gank.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.recycler_view

class HomeFragment : BaseFragment<HomeViewModel>() {

    private val mAdapter by lazy { HomeAdapter(arrayListOf()) }

    override fun getViewModel() = HomeViewModel()

    override fun getLayoutId() = R.layout.fragment_home

    override fun initView() {
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        recycler_view.adapter = mAdapter
        mViewModel.getTodayData()
        mViewModel.mDailyData.observe(this, Observer { list ->
            mAdapter.setNewData(list as MutableList<DailyData>)
        })
    }
}