package com.ming.algorithm.middle

import android.nfc.Tag
import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.math.cos

/**
 * @Description 最后一块石头的重量 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class LastStoneWeightII {

    companion object {
        /**
        有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
        每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
        如果 x == y，那么两块石头都会被完全粉碎；
        如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
        最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：stones = [2,7,4,1,8,1]
            输出：1
            解释：
            组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
            组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
            组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
            组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
             */
            print("结果是${solveTwo(intArrayOf(1, 5, 10, 6))}\n")
        }

        /**
         * 动态规划
         * 1.矩阵意义： 01背包 F[n] 代表重量为n 的最大价值
         * 2.定义：IntArray[]
         * 3.公式：F(n) = Math.max(F[n],F[n-weight] + price
         *        等于放和不放，取最大的价值
         *        重量等于价值，将石头分开2半，2边最接近的数为最小剩余的数
         * 4.初始化  初始化0 ，假设价值和重量一样
         * 5.遍历顺序  从大到小，如果从小到大，会重复。因为是二维数组是压缩为一维，
         *        前面数值会移动到后面
         * 5.计算矩阵
         */
        fun solveOne(stones: IntArray): Int {
            val sum = stones.sum()
            // 如果sum 是不整分，该数也是最小的
            val target = sum / 2
            val result = IntArray(target + 1) { 0 }
            stones.forEachIndexed { index, item ->
                for (j in target downTo item) {
                    result[j] = Math.max(result[j], result[j - item] + item)
                }
            }
            val other = sum - result[target]
            return other - result[target]
        }

        /**
         * 简易，
         * 二维数组
         * 公式 = F[n][j] = Math.max(F[n -1][j],F[n-1][j- weight[n]] + cost[n])
         *        f[n-1][j] 就是维持不放
         *        F[n-1][j- weight[n]] + cost[n] 放入的重量
         */
        fun solveTwo(stones: IntArray): Int {
            if (stones.isEmpty()) return 0
            val sum = stones.sum()
            val target = sum / 2
            val result = Array(stones.size) { IntArray(target + 1) }
            for (j in 1..target) {
                if (stones[0] <= j) {
                    result[0][j] = stones[0]
                }
            }
            for (i in 1 until stones.size) {
                for (j in 1..target) {
                    if (stones[i] > j) {
                        result[i][j] = result[i-1][j]
                    }else {
                        result[i][j] = Math.max(result[i-1][j], result[i-1][j-stones[i]] + stones[i])
                    }
                }
            }
            val other = sum - result[stones.size-1][target]
            return other - result[stones.size-1][target]
        }
    }
}