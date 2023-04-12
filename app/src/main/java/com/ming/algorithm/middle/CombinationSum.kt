package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.Stack


/**
 * @Description 组合总和
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class CombinationSum {

    companion object {
        /**
        给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
        并以列表形式返回。你可以按 任意顺序 返回这些组合。
        candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
        对于给定的输入，保证和为 target 的不同组合数少于 150 个。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：candidates = [2,3,6,7], target = 7
            输出：[[2,2,3],[7]]
            解释：
            2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
            7 也是一个候选， 7 = 7 。
            仅有这两种组合。
             */
            print("结果是${solveOne(intArrayOf(6, 3, 6, 7), 2)}\n")
        }

        /**
         * 递归法
         * 树枝去重
         * 1. 用的是上一层启始的位置。如果一直用全部，会导致有重复存在
         * 2. 通过排序后的数组，大于的话，后面已经可以不遍历了
         */
        fun solveOne(candidates: IntArray, target: Int): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            candidates.sort()
            fun combine(index: Int, sum: Int, path: MutableList<Int>) {
                // 当数值相等的时候
                if (target == sum) {
                    result.add(path.toList())
                    return
                }

                var sum = sum
                for (ids in index until candidates.size) {
                    val item = candidates[ids]
                    // 当大于的时候就不需要了
                    if (sum + item > target) {
                        break
                    }
                    path.add(item)
                    sum += item
                    combine(ids, sum, path)
                    path.removeAt(path.size - 1)
                    sum -= item
                }
            }
            combine(0, 0, mutableListOf())
            return result
        }
    }
}