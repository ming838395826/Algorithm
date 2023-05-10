package com.ming.algorithm.middle

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.math.cos

/**
 * @Description 不同的二叉搜索树
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class NumTrees {

    companion object {
        /**
        给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 3
            输出：5
             */
            print("结果是${solveOne(3)}\n")
        }

        /**
         * 动态规划
         * 1.矩阵意义： 根节点是n 的 有多少种可能
         * 2.定义：IntArray[]
         * 3.公式：F(n) += dp[j - 1] * dp[n - j];
         *        因为是二叉搜索树，所以大小排列
         *        相当于所有1 到 n节点的连接 F[n] = F[j - 1] * f[n-j] 的相加
         *        两边相乘是因为排列，一边对应另一边的情况
         * 4.初始化  初始化从 0 ， 1的数据
         * 5.遍历顺序  从小到大
         * 5.计算矩阵
         */
        fun solveOne(n: Int): Int {
            val result = IntArray(n + 1)
            result[0] = 1 // 为空 只有1种情况
            result[1] = 1 // 1 也只有1种
            for (index in 2..n) {
                for (root in 1..index) {
                    result[index] += result[root -1] * result[index - root]
                }
            }
            return result[n]
        }
    }
}