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
            print("结果是${solveOne("acjkkkj")}\n")
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
                    if (judePalindrome(data.substring(i, j+1)) && j - i + 1 > maxLength) {
                        maxLength = j - i + 1
                        begin = i
                    }
                }
            }
            return data.substring(begin, begin+maxLength)
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