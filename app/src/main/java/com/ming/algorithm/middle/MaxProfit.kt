package com.ming.algorithm.middle

import java.util.*


/**
 * @Description 买卖股票的最佳时机 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MaxProfit {

    companion object {
        /**
        给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
        在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
        返回 你能获得的 最大 利润 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：prices = [7,1,5,3,6,4]
            输出：7
            解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
            随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
            总利润为 4 + 3 = 7 。
             */
            print("结果是${solveOne(intArrayOf(7, 1, 5, 3, 6, 4))}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 只需要计算每天盈利的地方，只要是盈利的 就可以获取最大的利益
         */
        fun solveOne(prices: IntArray): Int {
            if (prices.size <= 1) return 0
            var result = 0
            // 最后一日无需买入
            for (index in 1 until prices.size) {
                // 差价大于0 就买入
                val diff = prices[index] - prices[index - 1]
                if (diff > 0) {
                    result += diff
                }
            }
            return result
        }

        /**
         * 动态规范
         * 定义； F[n][0] 表示第n天持有股票所得现金
         *       F[n][1] 表示第n天不持有股票所得最多现金
         *       如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来
         *          1.第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
         *          2.第i天买入股票，所得现金就是昨天不持有股票的所得现金减去 今天的股票价格 即：dp[i - 1][1] - prices[i]
         *          公式还是和只能买卖一次一样，只不过买入不是-prices[i]
         * 初始化： dp[0][0] -prices[0] dp[0][1] = 0
         * 顺序： 还是从小到大
         */
        fun solveTwo(prices: IntArray): Int {
            if (prices.isEmpty()) return 0
            val result = Array(prices.size) { IntArray(2) }
            result[0][0] = -prices[0]
            for (i in 1 until prices.size) {
                result[i][0] = Math.max(
                    //前面一直持有的
                    result[i-1][0],
                    // 当天买入
                    result[i-1][1] - prices[i]
                )
                result[i][1] = Math.max(
                    //前面一直持有的
                    result[i-1][1],
                    // 当天卖出
                    result[i-1][0] + prices[i]
                )
            }
            return result[prices.size - 1][1]
        }
    }
}