package com.ming.algorithm.hard


/**
 * @Description 解数独
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class SolveSudoku {

    companion object {
        /**
        编写一个程序，通过填充空格来解决数独问题。
        数独的解法需 遵循如下规则：
        数字 1-9 在每一行只能出现一次。
        数字 1-9 在每一列只能出现一次。
        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
        数独部分空格内已填入了数字，空白格用 '.' 表示。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：board = [['5','3','.','.','7','.','.','.','.'],['6','.','.','1','9','5','.','.','.'],['.','9','8','.','.','.','.','6','.'],['8','.','.','.','6','.','.','.','3'],['4','.','.','8','.','3','.','.','1'],['7','.','.','.','2','.','.','.','6'],['.','6','.','.','.','.','2','8','.'],['.','.','.','4','1','9','.','.','5'],['.','.','.','.','8','.','.','7','9']]
            输出：[['5','3','4','6','7','8','9','1','2'],['6','7','2','1','9','5','3','4','8'],['1','9','8','3','4','2','5','6','7'],['8','5','9','7','6','1','4','2','3'],['4','2','6','8','5','3','7','9','1'],['7','1','3','9','2','4','8','5','6'],['9','6','1','5','3','7','2','8','4'],['2','8','7','4','1','9','6','3','5'],['3','4','5','2','8','6','1','7','9']]
             */
            print(
                "结果是${
                    solveOne(
                        arrayOf(
                            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.')
                        )
                    )
                }\n"
            )
        }

        /**
         * 递归法
         * 按层递归，然后判断是否合法，不合法就跳过
         */
        fun solveOne(board: Array<CharArray>): Unit {
            // 判断是否符合
            fun isVaild(row: Int, column: Int, data: Char): Boolean {
                // 判断行是否有相等的数字
                for (currentColumn in 0 until board[row].size) {
                    if (currentColumn != column && board[row][currentColumn] == data) {
                        return false
                    }
                }
                // 判断列是否有相等的数字
                for (currentRow in board.indices) {
                    if (currentRow != row && board[currentRow][column] == data) {
                        return false
                    }
                }
                // 判断一个方格里面是否包含同一个
                val startColumn = (column / 3) * 3
                val startRow = (row / 3) * 3
                for (currentColumn in startColumn until startColumn + 3) {
                    // 已经校验过了，跳过
                    if (currentColumn == column) {
                        continue
                    }
                    for (currentRow in startRow until startRow + 3) {
                        if (currentRow == row) {
                            continue
                        }
                        if (board[currentRow][currentColumn] == data) {
                            return false
                        }
                    }
                }
                return true
            }

            /**
             * 不用行加列的原因
             * 单用行做参数，因为 一行还有很多的列空
             * 用行和列做参数，又因为不一定最尾的是空格，有可能是展位的地方午发判断到列切换行
             */
            fun solveSudoku(): Boolean {
                // 无需终止条件，遍历完就为结束
                for (row in board.indices) {
                    // 先遍历列
                    for (colum in 0 until board[row].size) {
                        if (board[row][colum] != '.') { // 跳过原始数字
                            continue
                        }
                        for (value in '1'..'9') {
                            if (isVaild(row, colum, value)) {
                                board[row][colum] = value
                                // 遍历的时候
                                val result = solveSudoku()
                                if (result)
                                    return true
                                board[row][colum] = '.'
                            }
                            //不能在这返回false 因为1 不符合 不代表2不符合
                        }
                        // 全部都遍历不到 表面没有符合的，返回直接结束
                        return false
                    }
                }
                // 全部都遍历完代表结束
                return true
            }
            solveSudoku()
        }
    }
}