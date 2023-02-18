package com.ming.algorithm.middle

import kotlin.text.StringBuilder

/**
 * @Description 找出字符串中第一个匹配项的下标
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class StrStr {

    companion object {
        /**
        给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle
        字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：haystack = "sadbutsad", needle = "sad"
            输出：0
            解释："sad" 在下标 0 和 6 处匹配。
            第一个匹配项的下标是 0 ，所以返回 0 。
             */
            print("结果是${solveOne("leetcode", "sad")}\n")
        }

        /**
         * KPM算法
         * 1. 求出next数组
         * 2. 求出匹配
         */
        fun solveOne(haystack: String, needle: String): Int {
            fun getNext(nextArray: IntArray, chars: CharArray) {
                var i = 1
                var j = 0
                while (i < chars.size) {
                    // 不相等情况, 一直相遇到相等的字符，或者到头
                    while (j > 0 && chars[i] != chars[j]) {
                        j = nextArray[j - 1]
                    }
                    // 相等情况
                    if (chars[i] == chars[j])
                        j++
                    nextArray[i++] = j

                }
            }
            if (needle.isEmpty()) return 0
            // 求next数组
            val next = IntArray(needle.length)
            getNext(next, needle.toCharArray())
            // 遍历
            var i = 0
            var j = 0
            while (i < haystack.length) {
                while (j > 0 && haystack[i] != needle[j]) {
                    j = next[j - 1]
                }
                if (needle[j] == haystack[i])
                    j++
                if (j == needle.length)
                    return i - needle.length + 1
                i++
            }
            return -1
        }
    }
}