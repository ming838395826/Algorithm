package com.ming.algorithm.simple

import android.support.v4.app.INotificationSideChannel


/**
 * @Description 排列硬币
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ArrangeCoins {

    companion object {
        /**
        你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
        给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 5
            输出：2
            解释：因为第三行不完整，所以返回 2 。
             */
            print("结果是${solveOne(5)}\n")
        }

        fun solveOne(n: Int): Int {
            var row = 0
            var data = n
            while (data > row) {
                data -= ++row
            }
            return row
        }
    }
}