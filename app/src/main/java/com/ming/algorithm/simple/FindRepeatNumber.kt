package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  剑指 Offer 03. 数组中重复的数字
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FindRepeatNumber {

    companion object {
        /**
        找出数组中重复的数字。
        在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
        但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：
            [2, 3, 1, 0, 2, 5, 3]
            输出：2 或 3
             */
            print("结果是${solveOne(intArrayOf())}\n")
        }

        /**
         * 因为排序 并且范围为-100 到100
         * -100 <= Node.val <= 100
         */
        fun solveOne(nums: IntArray): Int {
            val record = mutableSetOf<Int>()
            nums.forEach {
                if (record.contains(it)) {
                    return it
                }
                record.add(it)
            }
            return 0
        }
    }
}