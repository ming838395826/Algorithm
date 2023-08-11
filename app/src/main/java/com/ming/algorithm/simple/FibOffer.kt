package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  剑指 Offer 10- I. 斐波那契数列
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FibOffer {

    companion object {
        /**
        写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
        F(0) = 0,   F(1) = 1
        F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
        斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
        答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 2
            输出：1
             */
            print("结果是${solveOne(5)}\n")
        }

        /**
         * 动态规划
         * 1.矩阵意义： 第多少位的数值
         * 2.定义：IntArray
         * 3.公式：F(n) = (F(n-1) + F(n-2)) % 1000000007
         * 4.计算矩阵
         * 5.验证矩阵
         */
        fun solveOne(n: Int): Int {
            if (n == 0) return 0
            val result = IntArray(n + 1)
            result[0] = 0
            result[1] = 1
            for (index in 2..n) {
                result[index] = (result[index - 1] + result[index - 2]) % 1000000007
            }
            return result[n]
        }
    }
}