package com.gxj.base.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * 时间格式转换工具
 */
object DateUtil {
    /**
     * UTC 时间格式转换成yyyy-MM-dd HH:mm:ss
     *
     * @param string
     * @return
     */
    fun utcToStr(string: String): String {
        var str = ""
        try {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            sdf.timeZone = TimeZone.getTimeZone("UTC")//时区定义并进行时间获取
            val date = sdf.parse(string)
            val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            str = format.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return str
    }
}