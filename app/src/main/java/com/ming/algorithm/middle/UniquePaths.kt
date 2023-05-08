package com.ming.algorithm.middle

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.math.cos

/**
 * @Description 不同路径
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class UniquePaths {

    companion object {
        /**
        一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
        问总共有多少条不同的路径？
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：m = 3, n = 7
            输出：28
             */
            print("结果是${solveOne(3, 7)}\n")
        }

        /**
         * 动态规划
         * 1.矩阵意义： 第m行n列 有多少种路劲到达
         * 2.定义：Array<IntArray>
         * 3.公式：F(m,n) = F[m-1][n] + F[m][n-1]
         *        因为规定了只能从上到下，从左到右，所以只能有2个方法到达某一点，故而推出公式
         * 4.初始化  第一行和第一列 都只能有一种情况
         * 5.遍历顺序  从左到右，从上到下
         * 5.计算矩阵
         * m是行数， n是列数
         */
        fun solveOne(m: Int, n: Int): Int {
            if (m == 0 || n == 0) return 0
            // 定义数组
            val result = Array(m) { IntArray(n) }
            // 初始化,第一行，第一列
            for (index in 0 until n) {
                result[0][index] = 1
            }
            for (index in 0 until m) {
                result[index][0] = 1
            }
            for (row in 1 until m) {
                for (column in 1 until n) {
                    result[row][column] = result[row - 1][column] + result[row][column - 1]
                }
            }
            return result[m - 1][n - 1]
        }
    }
}