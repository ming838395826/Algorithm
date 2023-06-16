package com.ming.algorithm.simple

import java.util.*


/**
 * @Description  搜索插入位置
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class SearchInsert {

    companion object {
        /**
        给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
        请必须使用时间复杂度为 O(log n) 的算法。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: nums = [1,3,5,6], target = 5
            输出: 2
             */
            print("结果是${solveOne(intArrayOf(1, 3, 5, 6), 5)}\n")
        }

        /**
         * 二分法
         * 左闭右闭
         * while(left <= right) ,当left==right，区间[left, right]依然有效
         */
        fun solveOne(nums: IntArray, target: Int): Int {
            var start = 0
            var end = nums.size - 1
            // 4种情况
            // 在最前
            // 在最后
            // 刚好等于
            // 在2个数字中间
            while (start <= end) { // 因为是左闭右闭， 所以= 是符合的
                val middle = start + (end - start) / 2
                val item = nums[middle]
                // 相等情况
                if (item > target) {
                    end = middle - 1 // 因为是右闭，所以要取前一个
                } else if (item < target) {
                    start = middle + 1  //// 因为是左闭，所以要取前一个
                } else {
                    return middle
                }
            }
            // 剩余的就是在中间的数字 或者是最前，最右
            return end + 1
        }

        /**
         * 二分法
         * 左闭右开
         * while(left < right) ,当left == right，区间[left, right]依然无效
         */
        fun solveTwo(nums: IntArray, target: Int): Int {
            var start = 0
            var end = nums.size
            // 4种情况
            // 在最前
            // 在最后
            // 刚好等于
            // 在2个数字中间
            while (start < end) { // 因为是左闭右闭， 所以= 是符合的
                val middle = start + (end - start) / 2
                val item = nums[middle]
                // 相等情况
                if (item > target) {
                    end = middle // 因为是右闭，所以要取前一个
                } else if (item < target) {
                    start = middle + 1  //// 因为是左闭，所以要取前一个
                } else {
                    return middle
                }
            }
            // 剩余的就是在中间的数字 或者是最前，最右
            return end
        }

        /**
         * 暴力解法
         */
        fun solveThree(nums: IntArray, target: Int): Int {
            // 当在头插入 因为一开始就大于，所以返回0
            // 当等于或者介于中间，返回i
            // 结束都没比他大，所以Nums。size
            nums.forEachIndexed { index, i ->
                if (i >= target) {
                    return index
                }
            }
            return nums.size
        }
    }
}