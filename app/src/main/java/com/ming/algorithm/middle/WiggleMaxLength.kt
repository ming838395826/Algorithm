package com.ming.algorithm.middle

import java.util.*


/**
 * @Description 摆动序列
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class WiggleMaxLength {

    companion object {
        /**
        如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
        例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
        相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
        子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
        给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [1,7,4,9,2,5]
            输出：6
            解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
             */
            print("结果是${solveOne(intArrayOf(1, 2, 3))}\n")
        }

        /**
         * 贪心算法
         * 同波 平波的 去掉
         */
        fun solveOne(nums: IntArray): Int {
            if (nums.size <= 1) return nums.size
            var result = 1
            var preDiff = 0
            for (index in 1 until nums.size) {
                val curDiff = nums[index] - nums[index - 1]
                if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                    result++
                    // 没必要一直变化，这样遇到平波 一直上波的时候 会导致加1
                    preDiff = curDiff
                }
            }
            return result
        }
    }
}