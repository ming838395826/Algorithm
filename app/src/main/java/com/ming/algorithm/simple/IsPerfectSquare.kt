package com.ming.algorithm.simple

import java.util.*


/**
 * @Description 有效的完全平方数
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class IsPerfectSquare {

    companion object {
        /**
        给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
        完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
        不能使用任何内置的库函数，如  sqrt 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：num = 16
            输出：true
            解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
            示例 2：
             */
            print("结果是${solveOne(5)}\n")
        }

        /**
         * 二分法
         * 左闭右闭
         * while(left <= right) ,当left==right，区间[left, right]依然有效
         */
        fun solveOne(num: Int): Boolean {
            if (num <= 1) return true
            var start = 0
            var end = num
            while (start <= end) {
                // 取中位数
                val middle = start + (end - start) / 2
                // 得到除以的数
                val item = num / middle
                // 如果大于 middle 则表明Middle数字比较小，需要向右边缩小
                // 9 / 2 = 4 则start 要向右边
                if (item > middle) {
                    start = middle + 1
                } else if (item < middle) {
                    end = middle - 1
                } else {
                    return item * middle == num
                }
            }
            return false
        }
    }
}