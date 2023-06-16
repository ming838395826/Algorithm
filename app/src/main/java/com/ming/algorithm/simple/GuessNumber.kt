package com.ming.algorithm.simple

import java.util.*


/**
 * @Description 猜数字大小
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class GuessNumber {

    companion object {
        /**
        猜数字游戏的规则如下：

        每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
        如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
        你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
        -1：我选出的数字比你猜的数字小 pick < num
        1：我选出的数字比你猜的数字大 pick > num
        0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
        返回我选出的数字。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 10, pick = 6
            输出：6
             */
            print("结果是${solveOne(10)}\n")
        }

        fun guess(n: Int): Int = when {
            n > 6 -> 1
            n < 6 -> -1
            else -> 0
        }

        /**
         * 二分法
         * 左闭右闭
         * while(left <= right) ,当left==right，区间[left, right]依然有效
         */
        fun solveOne(n: Int): Int {
            var start = 1
            var end = n
            while (start <= end) {
                val middle = start + (end - start) / 2
                when (guess(middle) ) {
                    -1 -> end = middle -1
                    1 -> start = middle + 1
                    0 -> return middle
                }
            }
            return end + 1
        }

        fun solveTwo(n: Int): Int {
            var start = 1
            var end = n
            while (start < end) {
                val middle = start + (end - start) / 2
                when (guess(middle) ) {
                    -1 -> end = middle
                    1 -> start = middle + 1
                    0 -> return middle
                }
            }
            return end
        }
    }
}