package com.ming.algorithm.middle

import java.util.*


/**
 * @Description 不相交的线
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MaxUncrossedLines {

    companion object {
        /**
        在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
        现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
        nums1[i] == nums2[j]
        且绘制的直线不与任何其他连线（非水平线）相交。
        请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
        以这种方法绘制线条，并返回可以绘制的最大连线数。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums1 = [1,4,2], nums2 = [1,2,4]
            输出：2
            解释：可以画出两条不交叉的线，如上图所示。
            但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
             */
            print("结果是${solveOne(intArrayOf(7, 1, 5, 3, 6, 4), intArrayOf(7))}\n")
        }

        /**
         * 动态规范
         * 定义； dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]
         * 公式： 不相交等于找到最长子序列
         *       根据dp[i][j]的定义，dp[i][j]的状态只能由dp[i - 1][j - 1]推导出来
         *       即当A[i - 1] 和B[j - 1]相等的时候，dp[i][j] = dp[i - 1][j - 1] + 1;
         * 初始化： 因为0 -1 等于-1 无意义，所以取0
         * 顺序： 还是从小到大
         */
        fun solveOne(nums1: IntArray, nums2: IntArray): Int {
            val result = Array(nums1.size + 1) { IntArray(nums2.size + 1) }
            for (i in 1..nums1.size) {
                for (j in 1..nums2.size) {
                    // 2个相等，则拿前面相等的2个,连续的所以是 i-1,j-1
                    if (nums1[i - 1] == nums2[j - 1]) {
                        result[i][j] = result[i - 1][j - 1] + 1
                    } else {
                        result[i][j] = Math.max(result[i - 1][j], result[i][j - 1])
                    }
                }
            }
            return result[nums1.size][nums2.size]
        }

        /**
         * 动态规范， dp[i][j] 表示以i结尾 j为结尾的大小, 因为0 表示 i的0 所以要初始化
         */
        fun solveTwo(nums1: IntArray, nums2: IntArray): Int {
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
                    } else {
                        result[i][j] = Math.max(result[Math.max(i - 1,0)][j],result[i][Math.max(j - 1,0)])
                    }
                    // 因为可能第一个等于1 即不会走
                }
            }
            return result[nums1.size - 1][nums2.size - 1]
        }
    }
}