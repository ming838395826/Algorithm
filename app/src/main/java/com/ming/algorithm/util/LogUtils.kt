package com.ming.algorithm.util

/**
 * @Description 日志打印
 * @Author ming
 * @Date 2021/9/25 15:41
 */
object LogUtils {

    /**
     * 打印日志时间
     */
    fun printRunTime(isStart:Boolean){
        if (isStart){
            print("开始时间${DateUtils.formatTime(System.currentTimeMillis())}\n")
        }else{
            print("结束时间${DateUtils.formatTime(System.currentTimeMillis())}\n")
        }
    }
}