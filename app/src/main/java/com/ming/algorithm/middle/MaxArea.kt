package com.ming.algorithm.middle

/**
 * @Description 盛最多水的容器
 * @Author ming
 * @Date 2021/9/28 19:50
 */
class MaxArea {
    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    返回容器可以储存的最大水量。
    说明：你不能倾斜容器。
     */
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：[1,8,6,2,5,4,8,3,7]
            输出：49
            解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
             */
            print("结果是${solveTwo(intArrayOf(1,8,6,2,5,4,8,3,7))}\n")
        }

        /**
         * 暴力破解
         */
        private fun solveOne(height: IntArray): Int {
            var maxArea = 0
            for ((index, item) in height.withIndex()) {
                for (secondIndex in index until height.size) {
                    maxArea = ((secondIndex - index) * item.coerceAtMost(height[secondIndex])).coerceAtLeast(maxArea)
                }
            }
            return maxArea
        }

        /**
         * 双指针写法
         * 因为最长的向内收缩 永远比以前小
         */
        private fun solveTwo(height: IntArray): Int {
            var i = 0
            var j = height.size - 1
            var maxArea = 0
            while(i < j) {
                maxArea = if (height[i] < height[j]){
                    ((j-i)* height[i++]).coerceAtLeast(maxArea)
                }else {
                    ((j-i)* height[j--]).coerceAtLeast(maxArea)
                }
            }
            return maxArea
        }
    }
}