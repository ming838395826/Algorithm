package com.ming.algorithm.middle

import kotlin.math.max

/**
 * @Description 最长回文子串
 * @Author ming
 * @Date 2021/10/2 18:05
 */
class longestPalindrome {
    companion object {
        /**
         * 给你一个字符串 s，找到 s 中最长的回文子串。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "babad"
            输出："bab"
            解释："aba" 同样是符合题意的答案。
             */
            print("结果是${solveThree("ojhgghjko")}\n")
        }

        /**
         * 暴力破解法
         */
        private fun solveOne(data: String): String {
            if (data.length < 2) {
                return data
            }
            var maxLength = 1
            var begin = 0
            for (i in data.indices) {
                for (j in i + 1 until data.length) {
                    //如果是回文 并且长度大于maxLength 记录下来
                    if (judePalindrome(data.substring(i, j + 1)) && j - i + 1 > maxLength) {
                        maxLength = j - i + 1
                        begin = i
                    }
                }
            }
            return data.substring(begin, begin + maxLength)
        }

        /**
         * 中心扩散法
         */
        private fun solveTwo(data: String): String {
            if (data.length < 2) {
                return data
            }
            var maxLength = 1
            var begin = 0
            for (i in data.indices) {
                var left = i
                var right = i
                //先判断2边的数 都相等为止 在扩散
                while (left - 1 > -1 && data[left - 1] == data[i]) {
                    left--
                }
                while (right + 1 < data.length && data[right + 1] == data[i]) {
                    right++
                }
                while (left - 1 > -1 && right + 1 < data.length && data[left - 1] == data[right + 1]) {
                    left--
                    right++
                }
                if (right - left + 1 > maxLength) {
                    begin = left
                    maxLength = right - left + 1
                }
            }
            return data.substring(begin, begin + maxLength)
        }

        /**
         * 动态规划法 结合扩散法
         */
        private fun solveThree(data: String): String {
            if (data.length < 2) {
                return data
            }
            var table = Array(size = data.length, init = { BooleanArray(data.length) })
            var maxLength = 1
            var begin = 0
            //对线都是相等的
            for (i in data.indices) {
                table[i][i] = true
            }
            //取上半区域
            for (j in 1 until data.length) {
                for (i in 0 until j) {
                    if (data[j] != data[i]) {
                        table[i][j] = false
                    } else {
                        //如果相等 判断中间距离是不是超过2个字符 没有的话 因为相等 所以是对称
                        if (j - i < 3) {
                            table[i][j] = true
                        } else { //如果很大距离 那就判断 在他上一个是不是 对称的结果 是的话 就是 反之不是
                            table[i][j] = table[i + 1][j - 1]
                        }
                    }
                    //判断长度
                    if (table[i][j] && j - i + 1 > maxLength) {
                        begin = i
                        maxLength = j - i + 1
                    }
                }
            }
            return data.substring(begin, begin + maxLength)
        }

        /**
         * 判断是否符合回文字符串
         */
        private fun judePalindrome(data: String): Boolean {
            for (index in 0 until data.length / 2) {
                if (data[index] != data[data.length - index - 1]) {
                    return false
                }
            }
            return true
        }

    }
}