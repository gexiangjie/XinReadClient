package com.gxj.gank.http.api

import com.gxj.gank.bean.TodayBean
import io.reactivex.Flowable
import retrofit2.http.GET

interface GankApi {

    @GET("today")
    fun getToday(): Flowable<TodayBean>
}