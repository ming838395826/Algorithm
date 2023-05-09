package com.ming.algorithm.middle

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.math.cos

/**
 * @Description 整数拆分
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class IntegerBreak {

    companion object {
        /**
        给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
        返回 你可以获得的最大乘积 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: n = 2
            输出: 1
            解释: 2 = 1 + 1, 1 × 1 = 1。
             */
            print("结果是${solveOne(2)}\n")
        }

        /**
         * 动态规划
         * 1.矩阵意义： 第n个数可以取得的最大值
         * 2.定义：IntArray[]
         * 3.公式：F(n) = Math.max(Math.max(j * F[n-j], j * (n-j)), F(n))
         *        可以当成 j * (n-j) ，用F[n-j] 表示 那个数最大
         *        为什么 只拆后面， 因为类似乘法表一样 1* 9 最后也有会有 9 * 1
         *        至于除一半，因为 越到后面的数，拆成后面的得到的值越小。
         *        最后用F(n) 去比较，是因为是遍历 从1 到2到n，每一次都会计算到值，要得出最大的那个 给后面的人用
         * 4.初始化  第0，1，2位初始化。 0， 1无意义，因为无法拆开
         * 5.遍历顺序  从小到大
         * 5.计算矩阵
         */
        fun solveOne(n: Int): Int {
            val result = IntArray(n + 1)
            result[0] = 0
            result[1] = 1
            result[2] = 1
            for (index in 3..n) {
                for (j in 1..index / 2) {
                    result[index] =
                        Math.max(result[index], Math.max(j * (index - j), j * result[index - j]))
                }
            }
            return result[n]
        }
    }
}