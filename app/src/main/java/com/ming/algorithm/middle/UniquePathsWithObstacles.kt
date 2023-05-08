package com.ming.algorithm.middle

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.math.cos

/**
 * @Description 不同路径 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class UniquePathsWithObstacles {

    companion object {
        /**
        一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
        现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
        网格中的障碍物和空位置分别用 1 和 0 来表示。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
            输出：2
            解释：3x3 网格的正中间有一个障碍物。
            从左上角到右下角一共有 2 条不同的路径：
            1. 向右 -> 向右 -> 向下 -> 向下
            2. 向下 -> 向下 -> 向右 -> 向右
             */
            print("结果是${solveOne(arrayOf(intArrayOf()))}\n")
        }

        /**
         * 动态规划
         * 1.矩阵意义： 第m行n列 有多少种路劲到达
         * 2.定义：Array<IntArray>
         * 3.公式：F(m,n) = F[m-1][n] + F[m][n-1]
         *        因为规定了只能从上到下，从左到右，所以只能有2个方法到达某一点，故而推出公式
         * 4.初始化  第一行和第一列 都只能有一种情况,因为有阻碍，所以当第一行，第一列有阻碍后，应该置为0，因为后面没路径到达了
         * 5.遍历顺序  从左到右，从上到下
         * 5.计算矩阵
         */
        fun solveOne(obstacleGrid: Array<IntArray>): Int {
            if (obstacleGrid.isEmpty() || obstacleGrid[0].isEmpty()) return 0
            // 得到行列数
            val totalRow = obstacleGrid.size
            val totalColumn = obstacleGrid[0].size
            // 定义数组
            val result = Array(totalRow) { IntArray(totalColumn) }
            // 初始化,第一行，第一列
            for (index in 0 until totalColumn) {
                if (obstacleGrid[0][index] == 1) {
                    break
                }
                result[0][index] = 1
            }
            for (index in 0 until totalRow) {
                if (obstacleGrid[index][0] == 1) {
                    break
                }
                result[index][0] = 1
            }
            for (row in 1 until totalRow) {
                for (column in 1 until totalColumn) {
                    if (obstacleGrid[row][column] == 0) {
                        result[row][column] = result[row - 1][column] + result[row][column - 1]
                    }
                }
            }
            return result[totalRow - 1][totalColumn - 1]
        }
    }
}