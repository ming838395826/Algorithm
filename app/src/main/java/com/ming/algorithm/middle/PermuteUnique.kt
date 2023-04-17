package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.Stack


/**
 * @Description 全排列 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class PermuteUnique {

    companion object {
        /**
        给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [1,1,2]
            输出：
            [[1,1,2],
            [1,2,1],
            [2,1,1]]
             */
            print("结果是${solveOne(intArrayOf(1, 2, 3))}\n")
        }

        /**
         * 递归法
         * 剪枝
         * 元素相同，所以要去重，要先排列
         */
        fun solveOne(nums: IntArray): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            val used = BooleanArray(nums.size) { false }
            nums.sort()
            fun permute(path: MutableList<Int>) {
                // 等于等于到底部
                if (path.size == nums.size) {
                    result.add(path.toList())
                    return
                }
                nums.forEachIndexed { index, item ->
                    // 判断是否已经用过 ，树层去重
                    if (!used[index] && !(index > 0 && item == nums[index - 1] && !used[index - 1])) {
                        path.add(item)
                        used[index] = true
                        permute(path)
                        path.removeAt(path.size - 1)
                        used[index] = false
                    }
                }
            }
            permute(mutableListOf())
            return result
        }
    }
}