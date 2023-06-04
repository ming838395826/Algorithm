package com.ming.algorithm.middle

import java.util.*


/**
 * @Description 最长递增子序列
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class LengthOfLIS {

    companion object {
        /**
        给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
        子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
        例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [10,9,2,5,3,7,101,18]
            输出：4
            解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
             */
            print("结果是${solveOne(intArrayOf(7, 1, 5, 3, 6, 4))}\n")
        }

        /**
         * 动态规范
         * 定义； F[n] 表示 以n为结尾 最长的 升子序列
         *
         * 公式： 如果后一位数，比当前的数大那么应该加1
         *      if (nums[i] > nums[j]) dp[i] = max(dp[i], dp[j] + 1);
         *
         * 初始化： 每一个i，对应的dp[i]（即最长递增子序列）起始大小至少都是1.
         * 顺序： 还是从小到大
         */
        fun solveOne(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            var max = 1
            val result = IntArray(nums.size) { 1 }
            for (i in 1 until nums.size) {
                for (j in 0..i) {
                    if (nums[i] > nums[j]) {
                        result[i] = Math.max(result[i], result[j] + 1)
                        max = Math.max(result[i],max)
                    }
                }
            }
            return max
        }
    }
}