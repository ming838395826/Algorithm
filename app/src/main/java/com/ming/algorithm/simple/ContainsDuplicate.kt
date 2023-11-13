package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  存在重复元素
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ContainsDuplicate {

    companion object {
        /**
        给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [1,2,3,1]
            输出：true
             */
            print("结果是${solveOne(intArrayOf())}\n")
        }

        /**
         * map动态更新
         */
        fun solveOne(nums: IntArray): Boolean {
            val record = mutableSetOf<Int>()
            nums.forEach {
                if (record.contains(it)) {
                    return true
                }
                record.add(it)
            }
            return false
        }
    }
}