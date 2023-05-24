package com.ming.algorithm.middle

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  完全平方数
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class NumSquares {

    companion object {
        /**
        给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
        完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，
        其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 12
            输出：3
            解释：12 = 4 + 4 + 4
             */
            print("结果是${solveOne(12)}\n")
        }

        /**
         * 动态规划之背包问题
         * 定义： F[n]  为 凑成目标值 最小的组合
         * 公式： F[n] = Math.min(F[n-cost[i]]+ 1, F[n])
         *      等于当前数值得到上一个最少的组合 加上自身1 的个数 与本来的数值 取最小
         * 初始化： 目标为0 为
         * 顺序： 为最小的组合，为组合，先遍历物品，完全背包 从小到大遍历, 求的是最小组合，取得的都是组合个数，所以正反遍历无所谓
         */
        fun solveOne(n: Int): Int {
            val result = IntArray(n + 1) { Int.MAX_VALUE }
            result[0] = 0 // 目标为0 即为0种组合
            var i = 1
            while (i * i <= n) {
                for (j in i * i..n) {
                    if (result[j - i * i] != Int.MAX_VALUE) {
                        result[j] = Math.min(result[j], result[j - i * i] + 1)
                    }
                }
                i++
            }
            return result[n]
        }

        /**
         * 先遍历背包，再遍历物品
         */
        fun solveTwo(n: Int): Int {
            val result = IntArray(n + 1) { Int.MAX_VALUE }
            result[0] = 0 // 目标为0 即为0种组合
            for (j in 1..n) {
                var i = 1
                while (i * i <= j) {
                    if (result[j - i * i] != Int.MAX_VALUE) {
                        result[j] = Math.min(result[j], result[j - i * i] + 1)
                    }
                    i++
                }
            }
            return result[n]
        }
    }
}