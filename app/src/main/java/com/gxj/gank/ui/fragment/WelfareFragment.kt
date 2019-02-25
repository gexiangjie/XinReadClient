package com.gxj.gank.ui.fragment

import com.gxj.gank.R
import com.gxj.gank.viewmodel.HomeViewModel
import com.gxj.base.base.BaseFragment

class WelfareFragment : BaseFragment<HomeViewModel>() {

    override fun getViewModel() = HomeViewModel()

    override fun getLayoutId() = R.layout.fragment_welfare

    override fun initView() {
    }

}