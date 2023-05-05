package com.ming.algorithm.middle

import java.util.*
import kotlin.Comparator


/**
 * @Description 单调递增的数字
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MonotoneIncreasingDigits {

    companion object {
        /**
        当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
        给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: n = 10
            输出: 9
             */
            print("结果是${solveOne(10)}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 从后遍历，发现前一位比后一位小，就应该减1，因为要最大递增，所以后面都替换为9
         */
        fun solveOne(n: Int): Int {
            if (n < 10) return n
            val result = n.toString().toCharArray()
            var resetIndex = result.size // 从哪里开始重置位置
            for (index in result.size - 1 downTo 1) {
                if (result[index] < result[index - 1]) {
                    result[index - 1] = result[index -1] - 1
                    resetIndex = index
                }
            }
            for (index in resetIndex until result.size) {
                result[index] = '9'
            }
            return result.joinToString(separator = "").toInt()
        }
    }
}