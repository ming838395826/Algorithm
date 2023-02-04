package com.ming.algorithm.simple

/**
 * @Description 二分查找
 * @Author ming
 * @Date 2022/4/15 23:43
 */
class Search {

    companion object {
        /**
        给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: nums = [-1,0,3,5,9,12], target = 9
            输出: 4
            解释: 9 出现在 nums 中并且下标为 4
             */
            print("结果是${solveTwo(intArrayOf(-1, 0, 3, 5, 9, 12), 2)}\n")
        }

        /**
         * 二分法 左闭右闭
         */
        fun solveOne(nums: IntArray, target: Int): Int {
            if (nums.isEmpty()) return -1
            var left = 0
            var right = nums.size - 1
            while (left <= right) { //因为右闭 所以要等于
                val middle = left + (right - left) / 2
                if (nums[middle] > target) {
                    right = middle - 1 // 因为右闭已经不等于target 所以要减1， 不然死循环
                } else if (nums[middle] < target) {
                    left = middle + 1 //因为左闭已经不等于target 所以要加1,不然死循环
                } else {
                    return middle
                }
            }
            return -1
        }

        /**
         * 二分法 左闭右开
         */
        fun solveTwo(nums: IntArray, target: Int): Int {
            if (nums.isEmpty()) return -1
            var left = 0
            var right = nums.size
            while (left < right) { //因为右开 所以不等于，例如 [1,1) //是冲突的
                val middle = left + (right - left) / 2
                if (nums[middle] > target) {
                    right = middle // 因为右开不包含， 所以不用减1， 不然死循环
                } else if (nums[middle] < target) {
                    left = middle + 1 //因为左闭已经不等于target 所以要加1,不然死循环
                } else {
                    return middle
                }
            }
            return -1
        }
    }
}