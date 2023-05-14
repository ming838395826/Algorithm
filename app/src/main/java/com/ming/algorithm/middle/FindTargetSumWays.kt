package com.ming.algorithm.middle

import android.nfc.Tag
import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.math.cos

/**
 * @Description 目标和
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FindTargetSumWays {

    companion object {
        /**
        给你一个整数数组 nums 和一个整数 target 。
        向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
        例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
        返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [1,1,1,1,1], target = 3
            输出：5
            解释：一共有 5 种方法让最终目标和为 3 。
            -1 + 1 + 1 + 1 + 1 = 3
            +1 - 1 + 1 + 1 + 1 = 3
            +1 + 1 - 1 + 1 + 1 = 3
            +1 + 1 + 1 - 1 + 1 = 3
            +1 + 1 + 1 + 1 - 1 = 3
             */
            print("结果是${solveOne(intArrayOf(1, 1, 1, 1, 1), 3)}\n")
        }

        /**
         * 动态规划
         * 1.矩阵意义：F[n] 表示 容量为n 的背包有多少种方法
         * 2.定义：IntArray[]
         * 3.公式：F(n) += F[n - weight]
         *        比如对于容量为5，那么
         *        当容量为1 的物品，方法有 f[5-1] 种方法
         *        当容量为2 的物品，方法有 f[5-2] 种方法
         *        所以F(n) += F[n - weight]
         *        目标值 left为正数 ,right 为负数
         *        left - right = target
         *        left + right = sum
         *        left = (target + sum) / 2
         * 4.初始化  初始化0 ，当容量为0 时候， 也是1种方式
         * 5.遍历顺序  从大到小，如果从小到大，会重复。因为是二维数组是压缩为一维，
         *        前面数值会移动到后面
         * 5.计算矩阵
         */
        fun solveOne(nums: IntArray, target: Int): Int {
            val sum = nums.sum()
            // 如果target过大 sum将无法满足
            if (target < 0 && sum < -target) return 0
            // 因为不能整除
            if ((target + sum) % 2 != 0) return 0
            val left = (target + sum) / 2
            val result = IntArray(left + 1)
            result[0] = 1
            nums.forEachIndexed { i, item ->
                for (j in left downTo item) {
                    result[j] += result[j - item]
                }
            }
            return result[left]
        }

        /**
         * 简易，
         * 二维数组
         * 公式 = F[n][j] = Math.max(F[n -1][j],F[n-1][j- weight[n]] + cost[n])
         *        f[n-1][j] 就是维持不放
         *        F[n-1][j- weight[n]] + cost[n] 放入的重量
         */
        fun solveTwo(nums: IntArray, target: Int): Int {
            val sum = nums.sum()
            // 如果target过大 sum将无法满足
            if (target < 0 && sum < -target) return 0
            // 因为不能整除
            if ((target + sum) % 2 != 0) return 0
            val left = (target + sum) / 2
            val result = Array(nums.size) { IntArray(left + 1) }
            for (i in 0 until nums.size) {
                result[i][0] = 1
            }
            for (j in 1..left) {
                if (nums[0] == left) {
                    result[0][j] = 1
                }
            }
            for (i in 1 until nums.size) {
                for (j in 1..left) {
                    result[i][j] += result[i-1][j-left]
                }
            }
            return result[nums.size - 1][left]
        }
    }
}