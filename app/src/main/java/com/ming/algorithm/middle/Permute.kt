package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.Stack


/**
 * @Description 全排列
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Permute {

    companion object {
        /**
        给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [1,2,3]
            输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
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
            val used = BooleanArray(nums.size) { false }
            fun permute(path: MutableList<Int>) {
                // 等于等于到底部
                if (path.size == nums.size) {
                    result.add(path.toList())
                    return
                }
                nums.forEachIndexed { index, item ->
                    if (!used[index]) {
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