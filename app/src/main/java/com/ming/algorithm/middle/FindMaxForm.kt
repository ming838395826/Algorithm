package com.ming.algorithm.middle

import java.util.*

/**
 * @Description 一和零
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FindMaxForm {

    companion object {
        /**
        给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
        请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
        如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
            输出：4
            解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
            其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
             */
            print("结果是${solveOne(arrayOf(""), 3,3)}\n")
        }

        /**
         * 动态规划
         * 1.矩阵意义：F[m][n] 表示 容量为m 1容量为你的背包最多有多少种方法
         * 2.定义：IntArray[][]
         * 3.公式：F[m][n] = Math.max(F[m-i]F[n-j] + 1,F[m][n])
         *        求的是最多有多少种，所以要取最大
         *        因为加上本身个数要加1
         * 4.初始化  初始化0 ，当容量为0 时候， 也是1种方式
         * 5.遍历顺序  从大到小，如果从小到大，会重复。因为是二维数组是压缩为一维，
         *        前面数值会移动到后面
         * 5.计算矩阵
         */
        fun solveOne(strs: Array<String>, m: Int, n: Int): Int {
            val result = Array(m + 1) { IntArray(n + 1) }
            for (i in 0 until strs.size) {
                val zero = strs[i].count { it == '0' }
                val one = strs[i].length - zero
                //倒序遍历
                for (i in m downTo zero) {
                    for (j in n downTo one) {
                        result[i][j] = Math.max(result[i][j], result[i - zero][j- one] + 1)
                    }
                }
            }
            return result[m][n]
        }
    }
}