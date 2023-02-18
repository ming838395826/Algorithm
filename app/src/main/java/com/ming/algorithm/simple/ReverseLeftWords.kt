package com.ming.algorithm.simple

import kotlin.text.StringBuilder

/**
 * @Description 剑指 Offer 58 - II. 左旋转字符串
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ReverseLeftWords {

    companion object {
        /**
        字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: s = "abcdefg", k = 2
            输出: "cdefgab"
             */
            print("结果是${solveOne("abcdefg", 2)}\n")
        }

        /**
         * 双指针法 ，快慢指针
         * 1. 先反转
         * 2. 在反转每个区间
         */
        fun solveOne(s: String, n: Int): String {
            fun reverse(chars: CharArray, begin: Int, end: Int) {
                var begin = begin
                var end = end
                while (begin < end) {
                    val temp = chars[end]
                    chars[end--] = chars[begin]
                    chars[begin++] = temp
                }
            }

            val chars = s.toCharArray()
            reverse(chars, 0, chars.size - 1)
            reverse(chars, 0, chars.size - n - 1)
            reverse(chars, chars.size - n, chars.size - 1)
            return String(chars)
        }
    }
}