package com.ming.algorithm.middle

import android.nfc.Tag
import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.math.cos

/**
 * @Description 分割等和子集
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class CanPartition {

    companion object {
        /**
        给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [1,5,11,5]
            输出：true
            解释：数组可以分割成 [1, 5, 5] 和 [11] 。
             */
            print("结果是${solveTwo(intArrayOf(1, 5, 10, 6))}\n")
        }

        /**
         * 动态规划
         * 1.矩阵意义： 01背包 F[n] 代表重量为n 的最大价值
         * 2.定义：IntArray[]
         * 3.公式：F(n) = Math.max(F[n],F[n-weight] + price
         *        等于放和不放，取最大的价值
         * 4.初始化  初始化0 ，假设价值和重量一样
         * 5.遍历顺序  从大到小，如果从小到大，会重复。因为是二维数组是压缩为一维，
         *        前面数值会移动到后面
         * 5.计算矩阵
         */
        fun solveOne(nums: IntArray): Boolean {
            if (nums.isEmpty()) return false
            val sum = nums.sum()
            if (sum % 2 == 1) return false
            val target = sum / 2
            val result = IntArray(target + 1)
            result[0] = 0 // 重量为0 只有0
            // 假设价值和重量一样
            for (bagIndex in 0 until nums.size) {
                for (weight in target downTo nums[bagIndex]) {
                    result[weight] =
                        Math.max(result[weight], result[weight - nums[bagIndex]] + nums[bagIndex])
                }
            }
            return result[target] == target
        }

        /**
         * 简易，
         * 二维数组
         * 公式 = F[n][j] = Math.max(F[n -1][j],F[n-1][j- weight[n]] + cost[n])
         *        f[n-1][j] 就是维持不放
         *        F[n-1][j- weight[n]] + cost[n] 放入的重量
         */
        fun solveTwo(nums: IntArray): Boolean {
            if (nums.isEmpty()) return false
            val sum = nums.sum()
            if (sum % 2 == 1) return false
            val target = sum / 2
            // 初始化二维数组
            // 当容量为0的时候, 任何物品都放不下，即第一列为0
            val result = Array(nums.size) { IntArray(target + 1) { 0 } }
            // 当第一个物品时候，符合条件需要替换第一物品价值
            for (index in 1 until result[0].size) {
                if (nums[0] <= index)
                    result[0][index] = nums[0]
            }
            for (i in 1 until nums.size) {
                for (j in 1..target) {
                    // 先赋值，不然会导致后面比他小的容量都为0
                    result[i][j] = result[i - 1][j]
                    // nums[j] 表示重量，表示当前物品重量为这么多，能否放进去重量为j的背包
                    if (j >= nums[i])
                        result[i][j] =
                            Math.max(result[i - 1][j], result[i - 1][j - nums[i]] + nums[i])
                }
            }
            return result[nums.size - 1][target] == target
        }
    }
}