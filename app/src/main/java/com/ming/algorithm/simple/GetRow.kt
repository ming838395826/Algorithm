package com.ming.algorithm.simple


/**
 * @Description 杨辉三角 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class GetRow {

    companion object {
        /**
        给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
        在「杨辉三角」中，每个数是它左上方和右上方的数的和。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: rowIndex = 3
            输出: [1,3,3,1]
             */
            print("结果是${solveOne(3)}\n")
        }

        /**
         */
        fun solveOne(rowIndex: Int): List<Int> {
            var pre = 1
            val current = mutableListOf<Int>()
            current.add(1)
            for (i in 1..rowIndex) {
                for (j in 1 until i) {
                    val temp = current[j]
                    current.set(j, current[j] + pre)
                    pre = temp
                }
                current.add(1)
            }
            return current
        }
    }
}