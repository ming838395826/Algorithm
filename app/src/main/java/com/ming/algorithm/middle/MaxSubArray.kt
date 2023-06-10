package com.ming.algorithm.middle

import java.util.*


/**
 * @Description 最大子数组和
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MaxSubArray {

    companion object {
        /**
        给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
        子数组 是数组中的一个连续部分。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
            输出：6
            解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
             */
            print("结果是${solveOne(intArrayOf(-1))}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 当连续加完为负数，则表示开始递减，此时需要重新计算起点 因为负数加上下一个元素 “连续和”只会越来越小
         */
        fun solveOne(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            // 当全部为负数的时候，跟第一个比较.因为万一后面都为负数 比如 -1 那max 函数 因为默认为0 所以会一直为0
            var result = nums[0]
            var count = 0 // 表示连续相加的和
            for (index in nums.indices) {
                count += nums[index]
                // 取最大
                result = Math.max(count, result)
                // 证明会拖累后面的相加了
                if (count < 0) {
                    // 重置
                    count = 0
                }
            }
            return result
        }

        /**
         * 动态规范
         * 定义： dp[i] 为以i为结尾 最大的序列长度
         * 公式： d[i] = Math.max(dp[i-1] + nums[i], num[i])
         *       如果相加大于 那么取他 如果小于即不取重新计算
         * 初始化 0 为 nums[0]
         * 方向： 从前到后地推
         */
        fun solveTwo(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            val result = IntArray(nums.size)
            result[0] = nums[0]
            var max = nums[0]
            for (i in 1 until nums.size) {
                // 如果加完 还小于自身 ，则重新开始计算
                result[i] = Math.max(result[i - 1] + nums[i], nums[i])
                max = Math.max(result[i], max)
            }
            return max
        }
    }
}