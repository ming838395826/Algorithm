package com.ming.algorithm.middle

import java.util.*


/**
 * @Description  最长回文子序列
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class LongestPalindromeSubseq {

    companion object {
        /**
        给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
        子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "bbbab"
            输出：4
            解释：一个可能的最长回文子序列为 "bbbb"
             */
            print("结果是${solveOne("abc")}\n")
        }

        /**
         * 动态规范
         * 删除元素，最长序列
         * 定义： dp[i][j]：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]。
         * 公式： 整体上是两种，就是s[i]与s[j]相等，s[i]与s[j]不相等这两种。
         *       如果s[i]与s[j]相同，那么dp[i][j] = dp[i + 1][j - 1] + 2;
         *       s[i]与s[j]不相同，说明s[i]和s[j]的同时加入 并不能增加[i,j]区间回文子序列的长度，那么分别加入s[i]、s[j]看看哪一个可以组成最长的回文子序列。
        加入s[j]的回文子序列长度为dp[i + 1][j]。
        加入s[i]的回文子序列长度为dp[i][j - 1]。
        那么dp[i][j]一定是取最大的，即：dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
         * 初始化： i与j相同，那么dp[i][j]一定是等于1的，即：一个字符的回文子序列长度就是1。
         * 方向：从前到后，从下到上
         */
        fun solveOne(s: String): Int {
            val result = Array(s.length) { IntArray(s.length) }
            repeat(s.length) {
                result[it][it] = 1
            }
            for (i in s.length - 1 downTo 0) {
                for (j in i + 1 until s.length) {
                    // 不相等的话，肯定不是无需判断，默认为fasle
                    if (s[i] == s[j]) {
                        result[i][j] = result[i + 1][j - 1] + 2
                    } else {
                        result[i][j] = Math.max(result[i + 1][j], result[i][j - 1])
                    }
                }
            }
            return result[0][result.size-1]
        }
    }
}