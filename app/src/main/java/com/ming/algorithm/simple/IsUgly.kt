package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  丑数
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class IsUgly {

    companion object {
        /**
        丑数 就是只包含质因数 2、3 和 5 的正整数。
        给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 6
            输出：true
            解释：6 = 2 × 3
             */
            print("结果是${solveOne(38)}\n")
        }

        /**
         * 最重要的是公式
         * n=2a×3b×5c (指数)
         * 当 a,b,ca,b,ca,b,c 都是 000 时，n=1。
         */
        fun solveOne(n: Int): Boolean {
            // 负数一定不是
            if (n <= 0) return false
            val record = intArrayOf(2, 3, 5)
            var date = n
            record.forEach {
                while (date % it == 0) {
                    date /= it
                }
            }
            // 如果剩余为1 那么则是丑数
            return date == 1
        }
    }
}