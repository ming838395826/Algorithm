package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  斐波那契数
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Fib {

    companion object {
        /**
        斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，
        后面的每一项数字都是前面两项数字的和。也就是：
        F(0) = 0，F(1) = 1
        F(n) = F(n - 1) + F(n - 2)，其中 n > 1
        给定 n ，请计算 F(n) 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 2
            输出：1
            解释：F(2) = F(1) + F(0) = 1 + 0 = 1
             */
            print("结果是${solveOne(5)}\n")
        }

        /**
         * 动态规划
         * 1.矩阵意义： 第多少位的数值
         * 2.定义：IntArray
         * 3.公式：F(n) = F(n-1) + F(n-2)
         * 4.计算矩阵
         * 5.验证矩阵
         */
        fun solveOne(n: Int): Int {
            if (n == 0) return 0
            val result = IntArray(n + 1)
            result[0] = 0
            result[1] = 1
            for (index in 2..n) {
                result[index] = result[index - 1] + result[index - 2]
            }
            return result[n]
        }
    }
}