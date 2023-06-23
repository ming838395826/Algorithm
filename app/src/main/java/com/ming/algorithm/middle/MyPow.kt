package com.ming.algorithm.middle

import java.util.*


/**
 * @Description Pow(x, n)
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MyPow {

    companion object {
        /**
        实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：x = 2.00000, n = 10
            输出：1024.00000
             */
            print("结果是${solveOne(8.0,1)}\n")
        }

        /**
         * 二分法
         */
        fun solveOne(x: Double, n: Int): Double {
            val divider = n < 0
            var result = 1.0
            var n = if (divider) -1L * n else n * 1L
            // 倍数
            var multiple = x
            while (n > 0) {
                if (n % 2 == 1L) {
                    result *= multiple
                }
                multiple *= multiple
                n /= 2
            }
            return if (divider) 1/result else result
        }
    }
}