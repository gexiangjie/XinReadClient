package com.gxj.gank.bean

import com.google.gson.JsonArray
import com.google.gson.annotations.SerializedName

/**
 * 最新数据
 */
class TodayBean {
    var category: JsonArray? = null
    var error = false
    var results: DailyResults? = null
}

class DailyResults {
    @SerializedName("Android")
    var android: List<DailyData>? = null
    @SerializedName("App")
    var app: List<DailyData>? = null
    @SerializedName("iOS")
    var ios: List<DailyData>? = null
    @SerializedName("休息视频")
    var video: List<DailyData>? = null
    @SerializedName("前端")
    var 前端: List<DailyData>? = null
    @SerializedName("拓展资源")
    var 拓展资源: List<DailyData>? = null
    @SerializedName("瞎推荐")
    var recommend: List<DailyData>? = null
    @SerializedName("福利")
    var welfare: List<DailyData>? = null
}

data class DailyData(
    val _id: String?,
    val createdAt: String?,
    val desc: String?,
    val images: List<String>?,
    val publishedAt: String?,
    val source: String?,
    val type: String?,
    val url: String?,
    val used: Boolean?,
    val who: String?
)

/*
{
category: [
    "iOS",
    "拓展资源",
    "瞎推荐",
    "Android",
    "App",
    "休息视频",
    "福利",
    "前端"
],
error: false,
results: {
    Android: [{
        _id: "5c0622429d2122308e7445cf",
        createdAt: "2018-12-04T06:44:18.364Z",
        desc: "一个基于ijkplayer的完整视频播放器封装，支持自定义，拓展性强，已经用于实际开发中",
        images: [
        "http://img.gank.io/0cd8baa4-7d96-40fb-ab0c-4b3668a7ac4d",
        "http://img.gank.io/35066fc9-4c67-498d-b9e1-f8e3ca7410e1",
        "http://img.gank.io/ad8b369e-c643-4631-afdd-4466aab4f7fd",
        "http://img.gank.io/101d45df-c66b-4610-809a-734fbca99967",
        "http://img.gank.io/d8755a02-fe71-4562-ac9f-4d7d6b0d3358"
        ],
        publishedAt: "2019-02-13T03:26:06.640Z",
        source: "web",
        type: "Android",
        url: "https://github.com/yangchong211/YCVideoPlayer",
        used: true,
        who: "fingdo"
        },
    ],
    App: [],
    iOS: [],
    休息视频: [],
    前端: [],
    拓展资源: [],
    瞎推荐: [],
    福利: []
}
}
 */