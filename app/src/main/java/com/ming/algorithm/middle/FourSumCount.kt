package com.ming.algorithm.middle

import java.lang.StringBuilder

/**
 * @Description 四数相加 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FourSumCount {

    companion object {
        /**
        给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
        0 <= i, j, k, l < n
        nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
            输出：2
            解释：
            两个元组如下：
            1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
            2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
             */
            print(
                "结果是${
                    solveOne(
                        intArrayOf(1, 2),
                        intArrayOf(-2, -1),
                        intArrayOf(-1, 2),
                        intArrayOf(0, 2)
                    )
                }\n"
            )
        }

        /**
         *  因为 a + b + c + d = 0
         *  暴力解法要n的 4次方
         *  可以先2个 循环 得到 a + b的各种情况值
         *  然后遍历c d 让 0 - (c + d) = a + b
         *  关键用map 记录 a + b 的值 有多少种情况
         *  key 为 a +b  value 为 a + b 相同的次数(组合排列)
         */
        fun solveOne(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
            val sumMap = mutableMapOf<Int, Int>()
            var result = 0
            nums1.forEach { numA ->
                nums2.forEach { numB ->
                    val sum = numA + numB
                    sumMap[sum] = (sumMap[sum] ?: 0) + 1
                }
            }
            nums3.forEach { numC ->
                nums4.forEach { numD ->
                    val diff = 0 - numC - numD
                    result += sumMap[diff] ?: 0
                }
            }
            return result
        }
    }
}