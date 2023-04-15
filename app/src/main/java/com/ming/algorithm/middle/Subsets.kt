package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.Stack


/**
 * @Description 子集
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Subsets {

    companion object {
        /**
        给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
        解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [1,2,3]
            输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
             */
            print("结果是${solveOne(intArrayOf(1, 2, 3))}\n")
        }

        /**
         * 递归法
         * 剪枝
         * 因为元素不相同,所以无需
         */
        fun solveOne(nums: IntArray): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            fun subsets(startIndex: Int, path: MutableList<Int>) {
                result.add(path.toList())
                // 可加可不加
                if (startIndex == nums.size) {
                    return
                }
                for (index in startIndex until nums.size) {
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