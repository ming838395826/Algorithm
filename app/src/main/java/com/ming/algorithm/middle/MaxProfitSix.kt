package com.ming.algorithm.middle

import java.util.*


/**
 * @Description 买卖股票的最佳时机含手续费
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MaxProfitSix {

    companion object {
        /**
        给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
        你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
        返回获得利润的最大值。
        注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
            输出：8
            解释：能够达到的最大利润:
            在此处买入 prices[0] = 1
            在此处卖出 prices[3] = 8
            在此处买入 prices[4] = 4
            在此处卖出 prices[5] = 9
            总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
             */
            print("结果是${solveOne(intArrayOf(7, 1, 5, 3, 6, 4),2)}\n")
        }

        /**
         * 动态规范
         * 定义； F[n][0] 第i天持有股票所省最多现金
         *       F[n][1] 表示第n天不持有股票所得最多现金
         *       如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来
         *          1.第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
         *          2.第i天买入股票，f[i-1][1] -price[i]
         *       如果第i天不持有股票即dp[i][1]， 那么可以由两个状态推出来
         *          1.第i-1天就不持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
         *          2. 持有股票卖掉 卖掉的时候要扣除手续费
         *
         * 初始化： dp[0][0] -prices[0] dp[0][1] = 0 ，以此类推 得到k次
         * 顺序： 还是从小到大
         */
        fun solveOne(prices: IntArray, fee: Int): Int {
            if (prices.isEmpty()) return 0
            // 因为 i- 2所以要多空余一列
            val result = Array(prices.size) { IntArray(2) }
            // 初始化,专门多出一个0 方便第一次的计算
            result[0][0] = -prices[0]
            for (i in 1 until  prices.size) {
                result[i][0] = Math.max(result[i-1][0], result[i-1][1] - prices[i])
                result[i][1] = Math.max(result[i-1][1], result[i-1][0] + prices[i] - fee)
            }
            return Math.max(result[prices.size-1][1],result[prices.size-1][0])
        }
    }
}