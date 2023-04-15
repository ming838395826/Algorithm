package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.Stack


/**
 * @Description 子集 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class SubsetsWithDup {

    companion object {
        /**
        给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
        解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [1,2,2]
            输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
             */
            print("结果是${solveOne(intArrayOf(1, 2, 3))}\n")
        }

        /**
         * 递归法
         * 剪枝
         * 元素相同，所以要去重，树层去重,用used 加排序
         */
        fun solveOne(nums: IntArray): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            val used = BooleanArray(nums.size) { false }
            nums.sort()
            fun subsets(startIndex: Int, path: MutableList<Int>) {
                result.add(path.toList())
                // 可加可不加
                if (startIndex == nums.size) {
                    return
                }
                for (index in startIndex until nums.size) {
                    // 即是用过的
                    if (index> 0 && nums[index] == nums[index-1] && !used[index-1]){
                        continue
                    }
                    used[index] = true
                    path.add(nums[index])
                    subsets(index + 1, path)
                    path.removeAt(path.size - 1)
                    used[index] = false
                }
            }
            subsets(0, mutableListOf())
            return result
        }
    }
}