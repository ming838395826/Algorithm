package com.ming.algorithm.hard

import java.util.*


/**
 * @Description 买卖股票的最佳时机 IV
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MaxProfitFour {

    companion object {
        /**
        给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格，和一个整型 k 。
        设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：k = 2, prices = [2,4,1]
            输出：2
            解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
             */
            print("结果是${solveOne(3, intArrayOf(7, 1, 5, 3, 6, 4))}\n")
        }

        /**
         * 动态规范
         * 定义； F[n][0] 表示第n天持有股票所得现金
         *       F[n][1] 表示第n天不持有股票所得最多现金
         *       F[n][3] 表示第n天第二次持有股票所得现金
         *       F[n][4] 表示第n天第二次不持有股票所得最多现金
         *       因为k次 所有有k/2的数组
         *       如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来
         *          1.第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
         *          2.第i天买入股票，所得现金就是昨天不持有股票的所得现金减去 今天的股票价格 即：dp[i - 1][1] - prices[i]
         *          公式还是和只能买卖一次一样，只不过买入不是-prices[i]
         *          第二天要从第一提案推导而来
         * 初始化： dp[0][0] -prices[0] dp[0][1] = 0 ，以此类推 得到k次
         * 顺序： 还是从小到大
         */
        fun solveOne(k: Int, prices: IntArray): Int {
            if (prices.isEmpty()) return 0
            val result = Array(prices.size) { IntArray(2 * k + 1) }
            // 初始化,专门多出一个0 方便第一次的计算
            repeat(k) {
                result[0][2 * it + 1] = -prices[0]
            }
            for (i in 1 until prices.size) {
                repeat(k) {
                    result[i][2 * it + 1] = Math.max(
                        //前面一直持有的
                        result[i - 1][2 * it + 1],
                        // 当天卖出
                        result[i - 1][2 * it] - prices[i]
                    )
                    result[i][2 * it + 2] = Math.max(
                        //前面一直持有的
                        result[i - 1][2 * it + 2],
                        // 当天卖出
                        result[i - 1][2 * it + 1] + prices[i]
                    )
                }
            }
            // 如果第一次卖出已经是最大值了，那么我们可以在当天立刻买入再立刻卖出。
            // 所以dp[4][3]已经包含了dp[4][1]的情况。也就是说第二次卖出手里所剩的钱一定是最多的。
            return result[prices.size - 1][2 * k]
        }
    }
}