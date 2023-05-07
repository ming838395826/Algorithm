package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.math.cos

/**
 * @Description 使用最小花费爬楼梯
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MinCostClimbingStairs {

    companion object {
        /**
        给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
        一旦你支付此费用，即可选择向上爬一个或者两个台阶。
        你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
        请你计算并返回达到楼梯顶部的最低花费。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：cost = [10,15,20]
            输出：15
            解释：你将从下标为 1 的台阶开始。
            - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
            总花费为 15 。
             */
            print("结果是${solveOne(intArrayOf(10, 15, 20))}\n")
        }

        /**
         * 动态规划
         * 1.矩阵意义： 第n阶 最小的消耗, 要超过数组才算楼顶
         * 2.定义：IntArray
         * 3.公式：F(n) = Math.min(F(n-1)+Cost[n-1] + F(n-2)+Cost[n-2])
         *        1阶最小消耗0，2阶最小消耗有15， 3阶 可由 从1阶爬2步, 2阶爬1步。再加上当前需要的消耗，取最小值。
         *        即公式F(n) = Math.min(F(n-1)+Cost[n-1] + F(n-2)+Cost[n-2])
         * 4.计算矩阵
         * 5.验证矩阵
         */
        fun solveOne(cost: IntArray): Int {
            if (cost.isEmpty()) return cost[0]
            if (cost.size == 1) return Math.min(cost[0], cost[1])
            // 因为要爬上楼顶要超过
            val result = IntArray(cost.size + 1)
            result[0] = 0 //无需爬动
            result[1] = 0
            for (index in 2..cost.size) {
                result[index] = Math.min(
                    result[index - 1] + cost[index - 1],
                    result[index - 2] + cost[index - 2]
                )
            }
            return result[cost.size]
        }
    }
}