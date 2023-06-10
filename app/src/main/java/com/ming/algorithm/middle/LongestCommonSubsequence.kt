package com.ming.algorithm.middle

import java.util.*


/**
 * @Description 最长公共子序列
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class LongestCommonSubsequence {

    companion object {
        /**
        给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
        一个字符串的 子序列 是指这样一个新的字符串：
        它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
        例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
        两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：text1 = "abcde", text2 = "ace"
            输出：3
            解释：最长公共子序列是 "ace" ，它的长度为 3 。
             */
            print("结果是${solveOne("", "")}\n")
        }

        /**
         * 动态规范
         * 定义； dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长序列数组长度为dp[i][j]
         * 公式： 根据dp[i][j]的定义，dp[i][j]的状态只能由dp[i - 1][j - 1]推导出来
         *       即当A[i - 1] 和B[j - 1]相等的时候，dp[i][j] = dp[i - 1][j - 1] + 1;
         *       如果不相等，则取前面最长的 i-2 或者 j-2 即等于 dp[i][j] = Math.max(dp[i-1][j] = dp[])
         * 初始化： 因为0 -1 等于-1 无意义，所以取0
         * 顺序： 还是从小到大
         */
        fun solveOne(text1: String, text2: String): Int {
            val result = Array(text1.length + 1) { IntArray(text2.length + 1) }
            for (i in 1..text1.length) {
                for (j in 1..text2.length) {
                    // 2个相等，则拿前面相等的2个,连续的所以是 i-1,j-1
                    if (text1[i - 1] == text2[j - 1]) {
                        result[i][j] = result[i - 1][j - 1] + 1
                    } else {
                        result[i][j] = Math.max(result[i - 1][j], result[i][j - 1])
                    }
                }
            }
            return result[text1.length][text2.length]
        }

        /**
         * 动态规范， dp[i][j] 表示以i结尾 j为结尾的大小, 因为0 表示 i的0 所以要初始化
         */
        fun solveTwo(text1: String, text2: String): Int {
            val result = Array(text1.length) { IntArray(text2.length) }
            text2.forEachIndexed { j, item ->
                if (text1[0] == item) {
                    result[0][j] = 1
                }
            }
            text1.forEachIndexed { i, item ->
                if (text2[0] == item) {
                    result[i][0] = 1
                }
            }
            // 要从0开始 因为要0开始对比num2后面的值
            for (i in 0 until text1.length) {
                for (j in 0 until text2.length) {
                    // 2个相等，则拿前面相等的2个,连续的所以是 i-1,j-1
                    if (text1[i] == text2[j] && i > 0 && j > 0) {
                        result[i][j] = result[i - 1][j - 1] + 1
                    } else{
                        result[i][j] = Math.max(result[Math.max(i - 1,0)][j], result[i][Math.max(j - 1,0)])
                    }
                    // 因为可能第一个等于1 即不会走
                }
            }
            return result[text1.length-1][text2.length-1]
        }
    }
}