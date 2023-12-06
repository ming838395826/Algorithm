package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.math.max

/**
 * @Description 杨辉三角
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Generate {

    companion object {
        /**
        给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
        在「杨辉三角」中，每个数是它左上方和右上方的数的和。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: numRows = 5
            输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
             */
            print("结果是${solveOne(5)}\n")
        }

        /**
         * 巧妙方法
         * 因为是对称的 所以只需要一半计算即可
         */
        fun solveOne(numRows: Int): List<List<Int>> {
            val result = mutableListOf(listOf(1))
            for (currentRow in 1 until numRows) {
                val item = mutableListOf<Int>()
                for (column in 0 until currentRow + 1) {
                    val left = result[currentRow - 1].getOrNull(column - 1) ?: 0
                    val right = result[currentRow - 1].getOrNull(column) ?: 0
                    item.add(left + right)
                }
                result.add(item)
            }
            return result
        }
    }
}