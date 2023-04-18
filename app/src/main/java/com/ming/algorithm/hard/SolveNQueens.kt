package com.ming.algorithm.hard


/**
 * @Description N 皇后
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class SolveNQueens {

    companion object {
        /**
        按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
        n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
        给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
        每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 4
            输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
            解释：如上图所示，4 皇后问题存在两个不同的解法。
             */
            print("结果是${solveOne(4)}\n")
        }

        /**
         * 递归法
         * 按层递归，然后判断是否合法，不合法就跳过
         */
        fun solveOne(n: Int): List<List<String>> {
            val result = mutableListOf<List<String>>()

            // 判断是否符合
            fun isVaild(row: Int, column: Int, path: MutableList<CharArray>): Boolean {
                if (row > 0) {
                    // 判断同列是否包含
                    for (current in 0 until row) {
                        if (path[current][column] == 'Q') {
                            return false
                        }
                    }
                    // 判断对角
                    repeat(row) {
                        // 左对角
                        val leftColumn = column - it - 1
                        val rightColumn = column + it + 1
                        val currentRow = row - 1 - it
                        // 判断左边斜对角是否包含
                        if (leftColumn >= 0 && path[currentRow][leftColumn] == 'Q') {
                            return false
                        }
                        // 判断右边斜对角是否包含
                        if (rightColumn < n && path[currentRow][rightColumn] == 'Q') {
                            return false
                        }
                    }
                }
                return true
            }

            fun solveNQueens(row: Int, path: MutableList<CharArray>) {
                // 等于等于到底部
                if (row == n) {
                    val data = mutableListOf<String>()
                    path.forEach { item ->
                        data.add(item.joinToString(separator = ""))
                    }
                    result.add(data)
                    return
                }
                val chars = CharArray(n) { '.' }
                // 遍历一个的时候就放进去
                for (index in 0 until n) {
                    if (isVaild(row, index, path)) {
                        path.add(chars)
                        chars[index] = 'Q'
                        solveNQueens(row + 1, path)
                        path.removeAt(path.size - 1)
                        chars[index] = '.'
                    }
                }
            }
            solveNQueens(0, mutableListOf())
            return result
        }
    }
}