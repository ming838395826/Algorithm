package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.Stack


/**
 * @Description 递增子序列
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FindSubsequences {

    companion object {
        /**
        给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
        数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [4,6,7,7]
            输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
             */
            print("结果是${solveOne(intArrayOf(1, 2, 3))}\n")
        }

        /**
         * 递归法
         * 剪枝
         * 元素相同，所以要去重，但是不能排序先，不然所有元素就自增了。所以用map
         */
        fun solveOne(nums: IntArray): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            fun subsets(startIndex: Int, path: MutableList<Int>) {
                if (path.size > 1) {
                    result.add(path.toList())
                }
                // 可加可不加
                if (startIndex == nums.size) {
                    return
                }
                val map = mutableMapOf<Int, Boolean>()
                for (index in startIndex until nums.size) {
                    // 因为是要递增的，所以要判断元素是否小于上一个节点的值
                    if (path.size > 0 && nums[index] < path[path.size - 1]) {
                        continue
                    }
                    if (map[nums[index]] == true) {
                        continue
                    }
                    map[nums[index]] = true
                    path.add(nums[index])
                    subsets(index + 1, path)
                    path.removeAt(path.size - 1)
                }
            }
            subsets(0, mutableListOf())
            return result
        }
    }
}