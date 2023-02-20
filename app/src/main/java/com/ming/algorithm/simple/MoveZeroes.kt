package com.ming.algorithm.simple

import kotlin.text.StringBuilder

/**
 * @Description 移动零
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MoveZeroes {

    companion object {
        /**
        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
        请注意 ，必须在不复制数组的情况下原地对数组进行操作。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: nums = [0,1,0,3,12]
            输出: [1,3,12,0,0]
             */
            print("结果是${solveOne(intArrayOf(0, 1, 0, 3, 12))}\n")
        }

        /**
         * 双指针法
         * 关键要保持顺序
         */
        fun solveOne(nums: IntArray): Unit {
            var slow = 0
            var fast = 0
            while (fast < nums.size) {
                if (nums[fast] != 0) {
                    if (fast != slow) {
                        val temp = nums[fast]
                        nums[fast] = nums[slow]
                        nums[slow] = temp
                    }
                    slow++
                }
                fast++
            }
        }
    }
}