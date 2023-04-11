package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.Stack


/**
 * @Description 组合总和 III
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class CombinationSum3 {

    companion object {
        /**
        找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
        只使用数字1到9
        每个数字 最多使用一次
        返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 4, k = 2
            输出：
            [
            [2,4],
            [3,4],
            [2,3],
            [1,2],
            [1,3],
            [1,4],
            ]
             */
            print("结果是${solveOne(4, 2)}\n")
        }

        /**
         * 递归法
         */
        fun solveOne(n: Int, k: Int): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            fun combine(startIndex: Int, sum: Int, path: MutableList<Int>) {
                // 当大于的时候就不需要了
                if (sum > n) {
                    return
                }
                // 当长度相等的时候
                if (path.size == k) {
                    if (n == sum) {
                        result.add(path.toList())
                    }
                    return
                }
                var sum = sum
                for (index in startIndex..9 - (k - path.size) + 1) {
                    path.add(index)
                    sum += index
                    combine(index + 1, sum, path)
                    path.removeAt(path.size - 1)
                    sum -= index
                }
            }
            combine(1, 0, mutableListOf())
            return result
        }
    }
}