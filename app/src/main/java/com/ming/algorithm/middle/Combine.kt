package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.Stack


/**
 * @Description  组合
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Combine {

    companion object {
        /**
        给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
        你可以按 任何顺序 返回答案。
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
            fun combine(startIndex: Int, path: MutableList<Int>) {
                // 当长度相等的时候
                if (path.size == k) {
                    result.add(path.toList())
                    return
                }
                for (index in startIndex..n) {
                    path.add(index)
                    combine(index + 1, path)
                    path.removeAt(path.size - 1)
                }
            }
            combine(1, mutableListOf())
            return result
        }

        /**
         * 递归法
         * 剪枝法
         */
        fun solveTwo(n: Int, k: Int): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            fun combine(startIndex: Int, path: MutableList<Int>) {
                // 当长度相等的时候
                if (path.size == k) {
                    result.add(path.toList())
                    return
                }
                // 因为开始包含所以要 + 1
                // 表示意义为 最多到哪里开始
                for (index in startIndex..n - (k - path.size) + 1) {
                    path.add(index)
                    combine(index + 1, path)
                    path.removeAt(path.size - 1)
                }
            }
            combine(1, mutableListOf())
            return result
        }
    }
}