package com.ming.algorithm.middle

import java.util.*

/**
 * @Description 零钱兑换 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Change {

    companion object {
        /**
        给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
        请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
        假设每一种面额的硬币有无限个。
        题目数据保证结果符合 32 位带符号整数。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：amount = 5, coins = [1, 2, 5]
            输出：4
            解释：有四种方式可以凑成总金额：
            5=5
            5=2+2+1
            5=2+1+1+1
            5=1+1+1+1+1
             */
            print("结果是${solveOne(3, intArrayOf())}\n")
        }

        /**
         * 动态规划
         * 1.矩阵意义：F[n] 表示 容量为n 容量为你的背包最多有多少种方法
         * 2.定义：IntArray[]
         * 3.公式：F[n] += F[n - i]
         *        求的是最多有多少种，减去对应要加的数 就是那个数有多少种方法
         *        因为一个硬币可以多次使用，那么就是要从小遍历到大
         * 4.初始化  初始化0 ，当容量为0 时候， 也是1种方式
         * 5.遍历顺序  从大到小，如果从小到大，会重复。因为是二维数组是压缩为一维，
         *        前面数值会移动到后面
         * 5.计算矩阵
         */
        fun solveOne(amount: Int, coins: IntArray): Int {
            val result = IntArray(amount + 1)
            result[0] = 1
            for (i in 0 until coins.size) {
                //正序遍历
                for (j in  coins[i] .. amount) {
                    result[j] += result[j - coins[i]]
                }
            }
            return result[amount]
        }
    }
}