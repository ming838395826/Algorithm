package com.ming.algorithm.simple

/**
 * @Description 有序数组的平方
 * @Author ming
 * @Date 2022/4/15 23:43
 */
class SortedSquares {

    companion object {
        /**
        给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [-4,-1,0,3,10]
            输出：[0,1,9,16,100]
            解释：平方后，数组变为 [16,1,0,9,100]
            排序后，数组变为 [0,1,9,16,100]
             */
            print("结果是${solveOne(intArrayOf(-7,-3,2,3,11))}\n")
        }

        /**
         * 双指针指向法
         */
        fun solveOne(nums: IntArray): IntArray {
            var left = 0
            var right = nums.size - 1
            var position = nums.size - 1
            val result = IntArray(nums.size)
            while (left <= right) {
                if (nums[left] * nums[left] < nums[right] * nums[right]) {
                    result[position--] = nums[right] * nums[right--]
                } else {
                    result[position--] = nums[left] * nums[left++]
                }
            }
            return result
        }
    }
}