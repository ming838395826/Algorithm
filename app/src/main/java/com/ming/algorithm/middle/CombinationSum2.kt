package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.Stack


/**
 * @Description 组合总和 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class CombinationSum2 {

    companion object {
        /**
        给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
        candidates 中的每个数字在每个组合中只能使用 一次 。
        注意：解集不能包含重复的组合。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: candidates = [10,1,2,7,6,1,5], target = 8,
            输出:
            [
            [1,1,6],
            [1,2,5],
            [1,7],
            [2,6]
            ]
             */
            print("结果是${solveOne(intArrayOf(6, 3, 6, 7), 2)}\n")
        }

        /**
         * 递归法
         * 树层去重
         * 1. 因为有重复的数字，通过used数组，判断是否大于 相等 如果相等就是一条树枝遍历下来，如果不是就同层相等，需要抛弃.
         * 2. 通过排序后的数组，大于的话，后面已经可以不遍历了
         */
        fun solveOne(candidates: IntArray, target: Int): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            candidates.sort()
            val used = IntArray(candidates.size) { 0 }
            fun combine(startIndex: Int, sum: Int, path: MutableList<Int>) {
                // 当数值相等的时候
                if (target == sum) {
                    result.add(path.toList())
                    return
                }

                var sum = sum
                for (index in startIndex until candidates.size) {
                    val item = candidates[index]
                    // 前后2个数值相等，并且Used不相等，为同层不同树枝
                    if (index > 0 && candidates[index] == candidates[index - 1]
                        && used[index - 1] == 0
                    ) {
                        continue
                    }
                    // 当大于的时候就不需要了
                    if (sum + item > target) {
                        return
                    }
                    path.add(item)
                    sum += item
                    used[index] = 1
                    combine(index + 1, sum, path)
                    path.removeAt(path.size - 1)
                    sum -= item
                    used[index] = 0
                }
            }
            combine(0, 0, mutableListOf())
            return result
        }
    }
}