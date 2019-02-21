package com.gxj.gank.http

import com.gxj.gank.common.Constant
import com.gxj.gank.http.api.GankApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelp {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.GANK_API_HOST)
            .build()
    }

    fun getGankApi(): GankApi {
        return retrofit.create(GankApi::class.java)
    }
}