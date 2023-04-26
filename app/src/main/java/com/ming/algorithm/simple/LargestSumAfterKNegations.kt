package com.ming.algorithm.simple

import java.util.*
import kotlin.math.max
import kotlin.math.sign


/**
 * @Description K 次取反后最大化的数组和
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class LargestSumAfterKNegations {

    companion object {
        /**
        给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
        选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
        重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
        以这种方式修改数组后，返回数组 可能的最大和 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [4,2,3], k = 1
            输出：5
            解释：选择下标 1 ，nums 变为 [4,-2,3] 。
             */
            print("结果是${solveOne(intArrayOf(4, 2, 3), 1)}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 首先将负数 取反， 在判断是否奇数次，将最小的数字取反
         */
        fun solveOne(nums: IntArray, k: Int): Int {
            // 先按绝对值排序
            val nums = nums.sortedWith(object : Comparator<Int> {
                override fun compare(o1: Int, o2: Int): Int {
                    return Math.abs(o2) - Math.abs(o1)
                }
            }).toIntArray()
            var count = 0
            nums.forEachIndexed { index, item ->
                if (count == k) {
                    return@forEachIndexed
                }
                if (item < 0) {
                    nums[index] = -1 * item
                    count++
                }
            }
            if ((k - count) % 2 != 0) nums[nums.size - 1] = -1 * nums[nums.size - 1]
            return nums.sum()
        }
    }
}