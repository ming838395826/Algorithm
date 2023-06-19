package com.ming.algorithm.simple

import java.util.*


/**
 * @Description x 的平方根
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MySqrt {

    companion object {
        /**
        给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
        由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
        注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：x = 4
            输出：2
             */
            print("结果是${solveOne(8)}\n")
        }

        /**
         * 二分法
         * 左闭右闭
         * while(left <= right) ,当left==right，区间[left, right]依然有效
         */
        fun solveOne(x: Int): Int {
            var start = 1L
            var end = x.toLong()
            while (start <= end) {
                val middle = start + (end - start) / 2
                val item = middle * middle
                if (item > x) {
                    end = middle -1
                } else if (item < x) {
                    start = middle + 1
                } else {
                    return middle.toInt()
                }
            }
            return (start - 1).toInt()
        }
    }
}