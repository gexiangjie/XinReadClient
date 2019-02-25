package com.gxj.gank.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.gxj.gank.bean.DailyData
import com.gxj.gank.http.RetrofitHelp
import com.gxj.base.base.BaseViewModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel : BaseViewModel() {

    val mDailyData: MutableLiveData<List<DailyData>> = MutableLiveData()

    fun getTodayData() {
        RetrofitHelp.getGankApi()
            .getToday()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { t ->
                val list: MutableList<DailyData> = arrayListOf<DailyData>()
                with(t.results!!) {
                    android.let {
                        list.addAll(it!!)
                    }
                    app.let {
                        list.addAll(it!!)
                    }
                    ios.let {
                        list.addAll(it!!)
                    }
                    前端.let {
                        list.addAll(it!!)
                    }
                    拓展资源.let {
                        list.addAll(it!!)
                    }
                    recommend.let {
                        list.addAll(it!!)
                    }
                    welfare.let {
                        list.addAll(it!!)
                    }
                    video.let {
                        list.addAll(it!!)
                    }
                }
                Flowable.just(list)
            }.subscribe {
                Log.e("gxj : ", "${it[0].desc}")
                mDailyData.value = it!!
            }.addDisposable()
    }
}