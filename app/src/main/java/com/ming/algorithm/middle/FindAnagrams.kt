package com.ming.algorithm.middle

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * @Description   找到字符串中所有字母异位词
 * @Author ming
 * @Date 2022/2/13 14:46
 */
class FindAnagrams {

    companion object {
        /**
        给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
        异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: s = "cbaebabacd", p = "abc"
            输出: [0,6]
            解释:
            起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
            起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
             */
            print("结果是${solveOne("cbaebabacd", "abc")}\n")
        }

        /**
         * 滑窗法
         * 1.先移动右边
         * 2.判断是否条件符合
         * 3.移动左边到不符合
         * 4.继续移动右边直到结束
         */
        private fun solveOne(s: String, p: String): List<Int> {
            val result = mutableListOf<Int>()
            val pCount = IntArray(26)
            val sCount = IntArray(26)
            p.forEach {
                pCount[it - 'a']++
            }
            var left = 0
            var right = 0
            while (right < s.length) {
                val item = s[right]
                right++
                //符合的字符串
                sCount[item - 'a']++
                // 如果大于p长度就开始缩小
                while (right - left >= p.length) {
                    if (right - left == p.length && sCount.contentEquals(pCount)) {
                        result.add(left)
                    }
                    sCount[s[left] - 'a']--
                    left++
                }
            }
            return result
        }
    }
}