package com.ming.algorithm.middle

import java.util.*


/**
 * @Description 在排序数组中查找元素的第一个和最后一个位置
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class SearchRange {

    companion object {
        /**
        给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
        如果数组中不存在目标值 target，返回 [-1, -1]。
        你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [5,7,7,8,8,10], target = 8
            输出：[3,4]
             */
            print("结果是${solveOne(intArrayOf(), 4)}\n")
        }

        fun getRightBord(nums: IntArray, target: Int): Int {
            // 取2是因为要获取的不是刚好相等的位数，而是相等的前一位 ，即 -1是有代表意义的
            var result = -2
            var start = 0
            var end = nums.size - 1
            while (start <= end) {
                val middle = start + (end - start) / 2
                val item = nums[middle]
                // 如果大于目前。则右边缩小
                // 如果小于 或者等于，则一直缩小左边，直到相等的数，压缩到最右边
                if (item > target) {
                    end = middle - 1
                } else {
                    start = middle + 1
                    // 如果不加1的话 到外面判断 无法判断是否相等 还是不相等刚好在中间，如 2，3，5  taget = 4
                    result = middle + 1
                }
            }
            return result
        }

        fun getLeftBord(nums: IntArray, target: Int): Int {
            // 取2是因为要获取的不是刚好相等的位数，而是相等的前一位 ，即 -1是有代表意义的
            var result = -2
            var start = 0
            var end = nums.size - 1
            while (start <= end) {
                val middle = start + (end - start) / 2
                val item = nums[middle]
                // 如果大于等于目前。则右边缩小,并且等于
                // 如果小于 或者等于，则一直缩小左边，直到相等的数，压缩到最右边
                if (item >= target) {
                    end = middle - 1
                    // 如果不加1的话 到外面判断 无法判断是否相等 还是不相等刚好在中间，如 2，3，5  taget = 4
                    result = middle - 1
                } else {
                    start = middle + 1
                }
            }
            return result
        }

        /**
         * 二分法
         * 左闭右闭
         * while(left <= right) ,当left==right，区间[left, right]依然有效
         */
        fun solveOne(nums: IntArray, target: Int): IntArray {
            // 得到的值 都是不相等的
            val left = getLeftBord(nums, target)
            val right = getRightBord(nums, target)
            // 在最右边或者是最左边，
            if (left == -2 || right == -2) return intArrayOf(-1, -1)
            // 处于中间，且相等 3 4
            if (right - left > 1) return intArrayOf(left + 1, right - 1)
            // 处于中间， 但不相等
            return intArrayOf(-1,-1)
        }

        /**
         * 暴力解法
         */
        fun solveTwo(nums: IntArray, target: Int): IntArray {
            val result = intArrayOf(-1, -1)
            var hasFind = false
            nums.forEachIndexed { index, item ->
                if (item == target) {
                    if (hasFind) {
                        result[1] = index
                    } else {
                        result[0] = index
                        result[1] = index
                        hasFind = true
                    }
                }
            }
            return result
        }
    }
}