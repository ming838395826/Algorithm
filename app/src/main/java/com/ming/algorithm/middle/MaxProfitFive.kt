package com.ming.algorithm.middle

import java.util.*


/**
 * @Description 最佳买卖股票时机含冷冻期
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MaxProfitFive {

    companion object {
        /**
        给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
        设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
        卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: prices = [1,2,3,0,2]
            输出: 3
            解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
             */
            print("结果是${solveOne(intArrayOf(7, 1, 5, 3, 6, 4))}\n")
        }

        /**
         * 动态规范
         * 定义； F[n][0] 表示第n天持有股票所得现金
         *       F[n][1] 表示第n天不持有股票所得最多现金
         *       F[n][2] 表示第n天当天卖出股票最多现金
         *       F[n][3] 表示第n天冷冻期
         *       如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来
         *          1.第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
         *          2.第i天买入股票，有来自冷冻期买入 或者不持有股票买入
         *          公式还是和只能买卖一次一样，只不过买入不是-prices[i]
         *       如果第i天持有股票即dp[i][1]， 那么可以由两个状态推出来
         *          1.第i-1天就不持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
         *          2. 持有股票卖掉
         *       如果第i天当天卖出股票即dp[i][2]
         *          只有从持有状态的来
         *       如果第i天冷冻期[i][3]
         *          因为本题我们有冷冻期，而冷冻期的前一天，只能是 「今天卖出股票」状态，
         *          如果是 「不持有股票状态」那么就很模糊，因为不一定是 卖出股票的操作。
         *
         * 初始化： dp[0][0] -prices[0] dp[0][1] = 0 ，以此类推 得到k次
         * 顺序： 还是从小到大
         */
        fun solveOne(prices: IntArray): Int {
            if (prices.isEmpty()) return 0
            val result = Array(prices.size) { IntArray(4) }
            // 初始化,专门多出一个0 方便第一次的计算
            result[0][0] = -prices[0]
            result[0][1] = 0
            result[0][2] = 0
            result[0][3] = 0
            for (i in 1 until prices.size) {
                // 持有
                result[i][0] = Math.max(
                    //前面一直持有的
                    result[i - 1][0],
                    // 当天买入, 当天卖出的 隔天不能买入
                    Math.max(result[i - 1][1] - prices[i], result[i - 1][3] - prices[i])

                )
                // 不持有
                result[i][1] = Math.max(
                    //前面一直不持有的
                    result[i - 1][1],
                    // 前一天是冷冻期
                    result[i-1][3]
                )
                // 当天卖出
                result[i][2] = result[i - 1][0] + prices[i]
                // 冷冻期
                result[i][3] = result[i - 1][2]

            }
            // 最后有3种情况可能得到最大
            return Math.max(result[prices.size - 1][1],Math.max(result[prices.size - 1][2],result[prices.size - 1][3]))
        }

        /**
         * 动态规范
         * 定义； F[n][0] 表示第n天持有股票所得现金
         *       F[n][1] 表示第n天不持有股票所得最多现金
         *       如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来
         *          1.第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
         *          2.第i天买入股票，有来自冷冻期不能买入 那么就只能 i-2买入 不是冷冻期的话 那么就i-1
         *          由于冷冻期一样i-1,i-2
         *       如果第i天不持有股票即dp[i][1]， 那么可以由两个状态推出来
         *          1.第i-1天就不持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
         *          2. 持有股票卖掉
         *
         * 初始化： dp[0][0] -prices[0] dp[0][1] = 0 ，以此类推 得到k次
         * 顺序： 还是从小到大
         */
        fun solveTwo(prices: IntArray): Int {
            if (prices.isEmpty()) return 0
            // 因为 i- 2所以要多空余一列
            val result = Array(prices.size+1) { IntArray(2) }
            // 初始化,专门多出一个0 方便第一次的计算
            result[1][0] = -prices[0]
            for (i in 2 .. prices.size) {
                //情况一：第i天是冷静期，不能以dp[i-1][1]购买股票,所以以dp[i - 2][1]买股票，没问题
                //情况二：第i天不是冷静期，理论上应该以dp[i-1][1]购买股票，但是第i天不是冷静期说明，第i-1天没有卖出股票，
                //则dp[i-1][1]=dp[i-2][1],所以可以用dp[i-2][1]买股票，没问题
                result[i][0] = Math.max(result[i-1][0], result[i-2][1] - prices[i-1])
                result[i][1] = Math.max(result[i-1][1], result[i-1][0] + prices[i-1])
            }
            return result[prices.size][1]
        }
    }
}