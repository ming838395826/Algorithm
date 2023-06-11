package com.ming.algorithm.hard

import java.util.*


/**
 * @Description  不同的子序列
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class NumDistinct {

    companion object {
        /**
        给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。
        题目数据保证答案符合 32 位带符号整数范围。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "rabbbit", t = "rabbit"
            输出：3
            解释：
            如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
            rabbbit
            rabbbit
            rabbbit
             */
            print("结果是${solveOne("abc", "ahbgdc")}\n")
        }

        /**
         * 动态规范
         * 删除元素
         * 定义： dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
         * 公式： s[i - 1] 与 t[j - 1]相等
         *       一部分是用s[i - 1]来匹配，那么个数为dp[i - 1][j - 1]。
         *       即不需要考虑当前s子串和t子串的最后一位字母，所以只需要 dp[i-1][j-1]。
         *       一部分是不用s[i - 1]来匹配，个数为dp[i - 1][j]。
         *       当s[i - 1] 与 t[j - 1]不相等时，dp[i][j]只有一部分组成，
         *       不用s[i - 1]来匹配（就是模拟在s中删除这个元素），即：dp[i - 1][j]
         * 初始化： dp[i][0] 表示：以i-1为结尾的s可以随便删除元素，出现空字符串的个数
         *        那么dp[i][0]一定都是1，因为也就是把以i-1为结尾的s，删除所有元素，出现空字符串的个数就是1
         *        dp[0][j]：空字符串s可以随便删除元素，出现以j-1为结尾的字符串t的个数。
         *        那么dp[0][j]一定都是0，s如论如何也变成不了t
         * 方向：从前到后，从上到虾
         */
        fun solveOne(s: String, t: String): Int {
            val result = Array(s.length + 1) { IntArray(t.length + 1) }
            //初始化
            repeat(result.size) {
                result[it][0] = 1
            }
            for (i in 1..s.length) {
                for (j in 1..t.length) {
                    if (s[i - 1] == t[j - 1]) {
                        result[i][j] = result[i - 1][j - 1] + result[i - 1][j]
                    } else {
                        result[i][j] = result[i - 1][j]
                    }
                }
            }
            return result[s.length][t.length]
        }
    }
}