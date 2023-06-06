package com.ming.algorithm.middle

import java.util.*


/**
 * @Description 最长重复子数组
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FindLength {

    companion object {
        /**
        给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
        ，其实就是连续子序列
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
            输出：3
            解释：长度最长的公共子数组是 [3,2,1] 。
             */
            print("结果是${solveOne(intArrayOf(7, 1, 5, 3, 6, 4), intArrayOf(7))}\n")
        }

        /**
         * 动态规范
         * 定义； dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]
         * 公式： 根据dp[i][j]的定义，dp[i][j]的状态只能由dp[i - 1][j - 1]推导出来
         *       即当A[i - 1] 和B[j - 1]相等的时候，dp[i][j] = dp[i - 1][j - 1] + 1;
         *       也是因为I-1 避免初始化 ，所以采用i-1表示i 也就是扩大一列s
         * 初始化： 因为0 -1 等于-1 无意义，所以取0
         * 顺序： 还是从小到大
         */
        fun solveOne(nums1: IntArray, nums2: IntArray): Int {
            var max = 0
            val result = Array(nums1.size + 1) { IntArray(nums2.size + 1) }
            for (i in 1..nums1.size) {
                for (j in 1..nums2.size) {
                    // 2个相等，则拿前面相等的2个,连续的所以是 i-1,j-1
                    if (nums1[i - 1] == nums2[j - 1]) {
                        result[i][j] = result[i - 1][j - 1] + 1
                        max = Math.max(max, result[i][j])
                    }
                }
            }
            return max
        }

        /**
         * 动态规范， dp[i][j] 表示以i结尾 j为结尾的大小, 因为0 表示 i的0 所以要初始化
         */
        fun solveTwo(nums1: IntArray, nums2: IntArray): Int {
            var max = 0
            val result = Array(nums1.size) { IntArray(nums2.size) }
            nums2.forEachIndexed { j, item ->
                if (nums1[0] == item) {
                    result[0][j] = 1
                }
            }
            nums1.forEachIndexed { i, item ->
                if (nums2[0] == item) {
                    result[i][0] = 1
                }
            }
            // 要从0开始 因为要0开始对比num2后面的值
            for (i in 0 until nums1.size) {
                for (j in 0 until nums2.size) {
                    // 2个相等，则拿前面相等的2个,连续的所以是 i-1,j-1
                    if (nums1[i] == nums2[j] && i > 0 && j > 0) {
                        result[i][j] = result[i - 1][j - 1] + 1
                    }
                    // 因为可能第一个等于1 即不会走
                    max = Math.max(max, result[i][j])
                }
            }
            return max
        }
    }
}