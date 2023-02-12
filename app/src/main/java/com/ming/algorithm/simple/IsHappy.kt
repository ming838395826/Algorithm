package com.ming.algorithm.simple

import java.lang.StringBuilder

/**
 * @Description 快乐数
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class IsHappy {

    companion object {
        /**
        编写一个算法来判断一个数 n 是不是快乐数。
        「快乐数」 定义为：
        对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
        然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
        如果这个过程 结果为 1，那么这个数就是快乐数。
        如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 19
            输出：true
            解释：
            12 + 92 = 82
            82 + 22 = 68
            62 + 82 = 100
            12 + 02 + 02 = 1
             */
            print("结果是${solveOne(19)}\n")
        }

        /**
         * 用set保存每一次的结果，要是有包含就死循环为不是快乐数(关键在于死循环)
         */
        fun solveOne(n: Int): Boolean {
            // 递归
            val nums = mutableSetOf<Int>()
            fun checkIsHappy(n: Int): Boolean {
                var num = 0
                // 10进制遍历
                var n = n
                while (n > 0) {
                    val divide = n % 10
                    num += divide * divide
                    n /= 10
                }
                // 如果不等于1 并且不包含
                if (num != 1 && !nums.contains(num)) {
                    nums.add(num)
                    return checkIsHappy(num)
                }
                return num == 1
            }
            return checkIsHappy(n)
        }
    }
}