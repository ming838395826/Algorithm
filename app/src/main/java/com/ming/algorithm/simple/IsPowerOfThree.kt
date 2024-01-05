package com.ming.algorithm.simple


/**
 * @Description 3 的幂
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class IsPowerOfThree {

    companion object {
        /**
        给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
        整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 27
            输出：true
             */
            print("结果是${solveOne(6)}\n")
        }

        /**
         * 博弈论
         */
        fun solveOne(n: Int): Boolean {
            var n = n
            if (n < 1) return false
            while (n % 3 == 0) {
                n /= 3
            }
            return n == 1
        }
    }
}