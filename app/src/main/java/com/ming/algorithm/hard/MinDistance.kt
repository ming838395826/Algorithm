package com.ming.algorithm.hard

import java.util.*


/**
 * @Description  编辑距离
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MinDistance {

    companion object {
        /**
        给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
        你可以对一个单词进行如下三种操作：
        插入一个字符
        删除一个字符
        替换一个字符
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：word1 = "horse", word2 = "ros"
            输出：3
            解释：
            horse -> rorse (将 'h' 替换为 'r')
            rorse -> rose (删除 'r')
            rose -> ros (删除 'e')
             */
            print("结果是${solveOne("abc", "ahbgdc")}\n")
        }

        /**
         * 动态规范
         * 删除元素，最长序列
         * 定义： dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]。
         * 公式： s[i - 1] 与 t[j - 1]相等,无需改变
         *       一部分是用s[i - 1]来匹配，那么个数为dp[i - 1][j - 1]。
         *       即不需要考虑当前s子串和t子串的最后一位字母，所以只需要 dp[i-1][j-1]。
         *       不相等时候有3种情况
         *       1. 删除
         *      操作一：word1删除一个元素，那么就是以下标i - 2为结尾的word1 与 j-1为结尾的word2的最近编辑距离 再加上一个操作。
         *      即 dp[i][j] = dp[i - 1][j] + 1;
         *      操作二：word2删除一个元素，那么就是以下标i - 1为结尾的word1 与 j-2为结尾的word2的最近编辑距离 再加上一个操作。
         *      即 dp[i][j] = dp[i][j - 1] + 1;
         *      2.增加和删除一样，
         *      3.替换
         *      只需要一次替换的操作，就可以让 word1[i - 1] 和 word2[j - 1] 相同。
         *       所以 dp[i][j] = dp[i - 1][j - 1] + 1;
         *
         *       一部分是不用s[i - 1]来匹配，个数为dp[i - 1][j]。
         *       不相等取最大那个
         * 初始化： 因为是i-1 j-1 表示最小删除，所以当dp[i][0] = i 删除i个元素，dp[0][j] = j 添加j个元素
         * 方向：从前到后，从上到虾
         */
        fun solveOne(word1: String, word2: String): Int {
            val result = Array(word1.length + 1) { IntArray(word2.length + 1) }
            repeat(word1.length) {
                result[it+1][0] = it+1
            }
            repeat(word2.length) {
                result[0][it+1] = it+1
            }
            for (i in 1..word1.length) {
                for (j in 1..word2.length) {
                    if (word1[i - 1] == word2[j - 1]) {
                        result[i][j] = result[i - 1][j - 1]
                    } else {
                        result[i][j] = Math.min(
                            Math.min(result[i - 1][j] + 1, result[i][j - 1] + 1),
                            result[i - 1][j - 1] + 1
                        )
                    }
                }
            }
            return result[word1.length][word2.length]
        }
    }
}