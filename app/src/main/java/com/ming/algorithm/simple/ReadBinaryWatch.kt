package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description 二进制手表
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ReadBinaryWatch {

    companion object {
        /**
        二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
        例如，下面的二进制手表读取 "4:51" 。
        给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
        小时不会以零开头：
        例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
        分钟必须由两位数组成，可能会以零开头：
        例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：turnedOn = 1
            输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
             */
            print("结果是${solveOne(1)}\n")
        }

        /**
         *  回溯法
         *  确定终结条件，当数字用完为结束
         *  参数 数字 小时 分钟 遍历到数组的第几位
         */
        fun solveOne(turnedOn: Int): List<String> {
            val result = mutableListOf<String>()
            // 前面4位为小时
            val record = arrayListOf(1, 2, 4, 8, 1, 2, 4, 8, 16, 32)
            fun getTime(turnedOn: Int, hour: Int, min: Int, start: Int) {
                // 满足条件了则放进去
                if (turnedOn == 0) {
                    result.add("$hour:${if (min < 10) "0" else ""}${min}")
                    return
                }
                var current = start
                while (current < record.size) {
                    // 如果当前是小时部分的话。则加到小时 否则加到分钟
                    val nextHour = if (current < 4) hour + record[current] else hour
                    val nextMin = if (current < 4) min else min + record[current]
                    // 剪枝，
                    // 如果i <4 则为小时加 则小时不能大于 12
                    // 如果i >4 则为分钟加 则分钟不能大于 60
                    if ((current<4 && nextHour > 11) || (current >= 4 && nextMin > 59)) {
                        current++
                    } else {
                        getTime(turnedOn - 1, nextHour, nextMin, current + 1)
                        current++
                    }
                }
            }
            getTime(turnedOn, 0, 0, 0)
            return result
        }
    }
}