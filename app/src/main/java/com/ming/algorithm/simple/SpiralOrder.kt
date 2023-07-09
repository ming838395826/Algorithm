package com.ming.algorithm.simple

import android.print.PrintAttributes.Margins
import java.util.*

/**
 * @Description 顺时针打印矩阵
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class SpiralOrder {

    companion object {
        /**
        输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
            输出：[1,2,3,6,9,8,7,4,5]
             */
            print(
                "结果是${
                    solveOne(
                        arrayOf(
                            intArrayOf(7),
                            intArrayOf(9),
                            intArrayOf(6)
                        )
                    )
                }\n"
            )
        }

        /**
         * 注意递归细节
         * 左闭右开
         */
        fun solveOne(matrix: Array<IntArray>): IntArray {
            if (matrix.isEmpty()) return intArrayOf()
            val height = matrix.size
            val width = matrix[0].size
            val result = IntArray(width * height)
            var startX = 0
            var startY = 0
            var loop = 1 // loop count
            var count = 0
            // 关键点，要取最小的这样才能符合逻辑，避免有重复
            val maxLoop = Math.min(width, height)
            while (maxLoop - loop * 2 >= 0) {
                var x = startX
                var y = startY
                // 左到右
                while (x <= width - 1 - loop) {
                    result[count++] = matrix[y][x++]
                }
                // 上到下
                while (y <= height - 1 - loop) {
                    result[count++] = matrix[y++][x]
                }
                // 从右到左
                while (x > loop - 1) {
                    result[count++] = matrix[y][x--]
                }
                // 从下到上
                while (y > loop - 1) {
                    result[count++] = matrix[y--][x]
                }
                //循环结束
                startX++
                startY++
                loop++
            }
            // 如果高度不为0 大于1,中间一层, 并且还有得遍历
            if (loop * 2 - maxLoop == 1) {
                if (height > width) {
                    var y = startY
                    while (y <= height - loop) {
                        result[count++] = matrix[y++][startX]
                    }
                } else {
                    var x = startX
                    while (x <= width - loop) {
                        result[count++] = matrix[startY][x++]
                    }
                }

            }
            return result
        }
    }
}