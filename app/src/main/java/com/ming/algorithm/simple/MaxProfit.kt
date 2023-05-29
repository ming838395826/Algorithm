package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.math.max

/**
 * @Description  买卖股票的最佳时机
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MaxProfit {

    companion object {
        /**
        给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
        你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
        返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：[7,1,5,3,6,4]
            输出：5
            解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
            注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
             */
            print("结果是${solveOne(intArrayOf())}\n")
        }

        /**
         * 动态规划之背包问题
         * 定义： F[n][0] 为持有的股票 F[n][1] 为不持有股票
         * 公式： F[n][0] = max(F[i - 1][0], -prices[i]);
         *       F[n][1] = max(F[i - 1][1], prices[i] + F[i - 1][0]);
         *       持有股票有2种情况
         *          1. 前0到 n-1已经买入 那么即等于 f[n-1]
         *          2. 当天买入 即 -cost[n]
         *          取最大 即买入 比 当天买入取最大
         *       卖出股票
         *          1. 已经卖出，即 f[n-1]
         *          2. 当天卖出，即 f[n-1] + cost[n]
         *          取最大，即已卖出 和 当天卖出取最大
         * 初始化： 初始化0 为持有的时候 肯定为-price[0] 当卖出即为0
         * 顺序： 因为有前面得来，所以为 从小到大
         */
        fun solveOne(prices: IntArray): Int {
            if (prices.size == 1) return 0
            val result = Array(prices.size) { IntArray(2) }
            result[0][0] = -prices[0]
            result[0][1] = 0
            for (i in 1 until prices.size) {
                result[i][0] = Math.max(result[i - 1][0], -prices[i])
                result[i][1] = Math.max(result[i - 1][1], result[i - 1][0] + prices[i])
            }
            return Math.max(result[prices.size - 1][0], result[prices.size - 1][1])
        }

        /**
         * 贪心算法
         * 取左边最小，右边最大
         */
        fun solveTwo(prices: IntArray): Int {
            var min = Int.MAX_VALUE
            var res = 0
            prices.forEach {
                // 取更小的那个
                min = Math.min(it, min)
                // 用后面遍历过的值，减去之前的最小值，得到差值取最大
                res = Math.max(it-min, res)
            }
            return res
        }
    }
}