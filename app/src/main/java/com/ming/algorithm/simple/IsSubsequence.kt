package com.ming.algorithm.simple

import java.util.*


/**
 * @Description  判断子序列
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class IsSubsequence {

    companion object {
        /**
        给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
        字符串的一个子序列是原始字符串删除一些（也可以不删除）
        字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
        进阶：
        如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "abc", t = "ahbgdc"
            输出：true
             */
            print("结果是${solveOne("abc", "ahbgdc")}\n")
        }

        /**
         * 双指针做法
         */
        fun solveOne(s: String, t: String): Boolean {
            if (s.length > t.length) return false
            var right = -1
            s.forEach {
                while (right < t.length - 1) {
                    right++
                    if (it == t[right]) {
                        return@forEach
                    }

                }
                return false
            }
            return true
        }

        /**
         * 动态规范
         * 删除元素
         * 定义： dp[i][j] 为 i-1 ,j-1结尾最长公共序列长度
         * 公式： 当2个相等时候，则为 dp[i][j] = d[i-1][j-1] +1
         *       当不相等时候，删掉t的元素，则 dp[i][j] = d[i][j-1]
         * 初始化： 因为 i-1， 所以从0开始
         * 方向：从前到后，从上到虾
         */
        fun solveTwo(s: String, t: String): Boolean {
            val result = Array(s.length + 1) { IntArray(t.length + 1) }
            for (i in 1 .. s.length) {
                for (j in 1 .. t.length) {
                    if (s[i - 1] == t[j - 1]) {
                        result[i][j] = result[i - 1][j - 1] + 1
                    } else {
                        result[i][j] = result[i][j - 1]
                    }
                }
            }
            return result[s.length][t.length] == s.length
        }
    }
}