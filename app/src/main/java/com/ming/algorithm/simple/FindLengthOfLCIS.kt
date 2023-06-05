package com.ming.algorithm.simple

import java.util.*


/**
 * @Description 最长连续递增序列
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FindLengthOfLCIS {

    companion object {
        /**
        给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
        连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1]
        ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [1,3,5,4,7]
            输出：3
            解释：最长连续递增序列是 [1,3,5], 长度为3。
            尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
             */
            print("结果是${solveOne(intArrayOf(7, 1, 5, 3, 6, 4))}\n")
        }

        /**
         * 动态规范
         * 定义； F[n] 表示 以n为结尾 最长的 升子序列
         * 公式： 如果后一位数，比当前的数大那么应该加1，否则则为0 开始计算
         *       dp[i] = dp[i - 1] + 1;
         *
         * 初始化： 每一个i，对应的dp[i]（即最长递增子序列）起始大小至少都是1.
         * 顺序： 还是从小到大
         */
        fun solveOne(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            var max = 1
            val result = IntArray(nums.size) { 1 }
            for (i in 1 until nums.size) {
                if (nums[i] > nums[i - 1]) {
                    result[i] = result[i - 1] + 1
                }
                max = Math.max(result[i], max)
            }
            return max
        }

        /**
         * 贪心算法s
         */
        fun solveTwo(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            var res = 1 // 连续子序列最少也是1
            var count = 1
            for (i in 1 until nums.size) {
                if (nums[i] > nums[i - 1]) {
                    count++
                } else {
                    count = 1
                }
                res = Math.max(count, res)
            }
            return res
        }
    }
}