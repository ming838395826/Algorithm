package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  各位相加
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class AddDigits {

    companion object {
        /**
        给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: num = 38
            输出: 2
            解释: 各位相加的过程为：
            38 --> 3 + 8 --> 11
            11 --> 1 + 1 --> 2
            由于 2 是一位数，所以返回 2。
             */
            print("结果是${solveOne(38)}\n")
        }

        /**
         * 遍历每个数字
         */
        fun solveOne(num: Int): Int {
            fun getSum(data: Int): Int {
                var sum = 0
                var current = data
                while (current != 0) {
                    val item = current % 10
                    current /= 10
                    sum += item
                }
                return sum
            }

            var result = num
            while (result >= 10) {
                result = getSum(result)
            }
            return result
        }
    }
}