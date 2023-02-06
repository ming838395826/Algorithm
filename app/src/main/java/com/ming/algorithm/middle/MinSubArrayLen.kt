package com.ming.algorithm.middle

import kotlin.math.min

/**
 * @Description 长度最小的子数组
 * @Author ming
 * @Date 2022/4/15 23:43
 */
class MinSubArrayLen {

    companion object {
        /**
        给定一个含有 n 个正整数的数组和一个正整数 target 。
        找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：target = 7, nums = [2,3,1,2,4,3]
            输出：2
            解释：子数组 [4,3] 是该条件下的长度最小的子数组。
             */
            print("结果是${solveOne(4, intArrayOf(1, 1, 1))}\n")
        }

        /**
         * 滑动窗口法
         */
        fun solveOne(target: Int, nums: IntArray): Int {
            var start = 0
            var result = Int.MAX_VALUE // 为了判断都不符合的情况
            var sum = 0
            nums.forEachIndexed { index, item ->
                sum += item
                while (sum >= target) { // 不用if 而是用while 是因为 比如 （1，1，1，1，100） target等于100的时候，需要一直向前遍历到小于100的数组
                    val length = index - start + 1
                    result = min(result, length)
                    sum -= nums[start++]
                }
            }
            return if (result == Int.MAX_VALUE) 0 else result
        }
    }
}