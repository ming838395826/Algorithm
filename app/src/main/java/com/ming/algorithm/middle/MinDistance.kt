package com.ming.algorithm.middle

import java.util.*


/**
 * @Description   两个字符串的删除操作
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MinDistance {

    companion object {
        /**
        给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
        每步 可以删除任意一个字符串中的一个字符。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: word1 = "sea", word2 = "eat"
            输出: 2
            解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
             */
            print("结果是${solveOne("abc", "ahbgdc")}\n")
        }

        /**
         * 动态规范
         * 删除元素，最长序列
         * 定义： dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的最长序列个数为dp[i][j]。
         * 公式： s[i - 1] 与 t[j - 1]相等
         *       一部分是用s[i - 1]来匹配，那么个数为dp[i - 1][j - 1] +1。
         *       即不需要考虑当前s子串和t子串的最后一位字母，所以只需要 dp[i-1][j-1]。
         *       一部分是不用s[i - 1]来匹配，个数为dp[i - 1][j]。
         *       不相等取最大那个
         * 初始化： 因为是i-1 j-1 表示
         * 方向：从前到后，从上到虾
         */
        fun solveOne(word1: String, word2: String): Int {
            val result = Array(word1.length + 1) { IntArray(word2.length + 1) }
            for (i in 1..word1.length) {
                for (j in 1..word2.length) {
                    if (word1[i - 1] == word2[j - 1]) {
                        result[i][j] = result[i - 1][j - 1] + 1
                    } else {
                        result[i][j] = Math.max(result[i - 1][j], result[i][j - 1])
                    }
                }
            }
            return word1.length + word2.length - result[word1.length][word2.length] * 2
        }

        /**
         * 定义： dp[i][j]：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数。
         * 公式： 当相等的时候，即不用删除，所以dp[i][j] = d[i-1][j-1]
         *       如果不相等的时候，取最小的值
         *       dp[i][j] = Math.min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i][j] + 2)
         * 初始化：dp[i][0]：word2为空字符串，以i-1为结尾的字符串word1要删除多少个元素，才能和word2相同呢，很明显dp[i][0] = i
         * 方向： 从左到右，从上到下
         */
        fun solveTwo(word1: String, word2: String): Int {
            val result = Array(word1.length + 1) { IntArray(word2.length + 1) }
            repeat(word2.length) {
                result[0][it + 1] = it + 1
            }
            repeat(word1.length) {
                result[it+1][0] = it + 1
            }
            for (i in 1..word1.length) {
                for (j in 1..word2.length) {
                    if (word1[i - 1] == word2[j - 1]) {
                        result[i][j] = result[i - 1][j - 1]
                    } else {
                        result[i][j] = Math.min(
                            Math.min(result[i - 1][j] + 1, result[i][j - 1] + 1),
                            result[i - 1][j - 1] + 2
                        )
                    }
                }
            }
            return result[word1.length][word2.length]
        }
    }
}