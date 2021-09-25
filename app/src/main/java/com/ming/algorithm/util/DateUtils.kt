package com.ming.algorithm.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * @Description 时间格式化工具
 * @Author ming
 * @Date 2021/9/25 15:34
 */
object DateUtils {

    /**
     * 格式化时间
     */
    fun formatTime(time: Long):String{
        val format = SimpleDateFormat("yyyy-MM-dd:HH:mm:ss")
        return format.format(time)

    }
}