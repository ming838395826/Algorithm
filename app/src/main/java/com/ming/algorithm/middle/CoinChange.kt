package com.ming.algorithm.middle

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  零钱兑换
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class CoinChange {

    companion object {
        /**
        给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
        计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
        你可以认为每种硬币的数量是无限的。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：coins = [1, 2, 5], amount = 11
            输出：3
            解释：11 = 5 + 5 + 1
             */
            print("结果是${solveOne(intArrayOf(1, 2, 5), 11)}\n")
        }

        /**
         * 动态规划之背包问题
         * 定义： F[n]  为 凑成目标值 最小的组合
         * 公式： F[n] = Math.min(F[n-cost[i]]+ 1, F[n])
         *      等于当前数值得到上一个最少的组合 加上自身1 的个数 与本来的数值 取最小
         * 初始化： 目标为0 为
         * 顺序： 为最小的组合，为组合，先遍历物品，完全背包 从小到大遍历
         */
        fun solveOne(coins: IntArray, amount: Int): Int {
            val result = IntArray(amount + 1) { -1 }
            result[0] = 0 // 目标为0 即为0种组合
            coins.forEachIndexed { i, coin ->
                for (j in 1..amount) {
                    if (coin <= j && result[j - coin] != -1) {
                        if (result[j] == -1) {
                            result[j] = result[j - coin] + 1
                        }else{
                            result[j] = Math.min(result[j], result[j - coin] + 1)
                        }
                    }
                }
            }
            return result[amount]
        }

        fun solveTwo(coins: IntArray, amount: Int): Int {
            val result = IntArray(amount + 1) { Int.MAX_VALUE }
            result[0] = 0 // 目标为0 即为0种组合
            coins.forEachIndexed { i, coin ->
                for (j in coin..amount) {
                    if (result[j - coin] != Int.MAX_VALUE) {
                        result[j] = Math.min(result[j], result[j - coin] + 1)
                    }
                }
            }
            return if (result[amount] == Int.MAX_VALUE) -1 else result[amount]
        }
    }
}