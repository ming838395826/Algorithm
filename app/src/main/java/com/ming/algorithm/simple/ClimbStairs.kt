package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  爬楼梯
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ClimbStairs {

    companion object {
        /**
        假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 2
            输出：2
            解释：有两种方法可以爬到楼顶。
            1. 1 阶 + 1 阶
            2. 2 阶
             */
            print("结果是${solveTwo(2)}\n")
        }

        /**
         * 动态规划
         * 1.矩阵意义： 第n阶 有多少种方法，注意是多少种方法
         * 2.定义：IntArray
         * 3.公式：F(n) = F(n-1) + F(n-2)
         *        1阶有1种方法，2阶有2种方法， 3阶 可由 从1阶爬2步, 2阶爬1步。所以等于1 +2 ，即公式F(n) = F(n-1) + F(n-2)
         * 4.计算矩阵
         * 5.验证矩阵
         */
        fun solveOne(n: Int): Int {
            val result = IntArray(Math.max(n + 1, 3))
            result[0] = 0 //无需爬动
            result[1] = 1
            result[2] = 2
            for (index in 3..n) {
                result[index] = result[index - 1] + result[index - 2]
            }
            return result[n]
        }

        /**
         * 动态规划之背包问题
         * 公式： F[n] += F[n-cost[i]]
         *      可以爬1阶，2阶，到M阶.等价于有 物品重量 1 ，2 ，3 到m
         *      沾满背包为n的背包问题，因为1阶都可以重复利用，所以为完全背包
         * 初始化： 0 阶 为 1 种方法
         * 顺序： 先爬1 再爬2 和先爬1 再爬2 是不一样的，所以为排列。要先遍历背包
         */
        fun solveTwo(n: Int): Int {
            val result = IntArray(n + 1)
            result[0] = 1 //无需爬动
            for (j in 1..n) {
                for (i in 1..2) {
                    if (i <= j) {
                        result[j] += result[j - i]
                    }
                }
            }
            return result[n]
        }
    }
}