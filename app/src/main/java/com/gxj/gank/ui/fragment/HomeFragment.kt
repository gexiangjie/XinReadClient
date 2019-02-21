package com.gxj.gank.ui.fragment

import android.util.Log
import com.gxj.gank.R
import com.gxj.gank.bean.TodayBean
import com.gxj.gank.http.RetrofitHelp
import com.gxj.module_base.base.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class HomeFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_home

    override fun initView() {
        RetrofitHelp.getGankApi().getToday().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<TodayBean> {
                override fun onComplete() {
                    Log.e("gxj : ", "onComplete")
                }

                override fun onSubscribe(s: Subscription?) {
                    Log.e("gxj : ", "onSubscribe")
                }

                override fun onNext(t: TodayBean?) {
                    Log.e("gxj : ", "onNext")
                    Log.e("gxj : ", "${t!!.results!!.android!!.forEach { it.desc }}}")
                }

                override fun onError(t: Throwable?) {
                    Log.e("gxj : ", "${t!!.message}")
                }

            })
    }
}