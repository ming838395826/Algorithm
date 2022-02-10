package com.ming.algorithm.simple

import java.lang.StringBuilder

/**
 * @Description 整数反转
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Reverse {

    companion object {
        /**
        给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

        如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

        假设环境不允许存储 64 位整数（有符号或无符号）。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            print("结果是${solveOne(120)}\n")
        }

        /**
         * 取模
         */
        fun solveOne(x: Int): Int {
            var data = x
            var result = 0
            while (data != 0) {
                //判断是否大于界限(最大数去掉要加的数除以10 是否大于当前的数)
                val digest = data % 10
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digest > 7))
                    return 0;
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digest < -8))
                    return 0;
                result = result * 10 + digest
                data /= 10
            }
            return result
        }
    }
}