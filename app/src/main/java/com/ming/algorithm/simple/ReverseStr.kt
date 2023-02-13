package com.ming.algorithm.simple

import java.lang.StringBuilder

/**
 * @Description 反转字符串 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ReverseStr {

    companion object {
        /**
        给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
        如果剩余字符少于 k 个，则将剩余字符全部反转。
        如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "abcdefg", k = 2
            输出："bacdfeg"
             */
            print("结果是${solveOne("abcdefg", 2)}\n")
        }

        /**
         * 双指针法
         */
        fun solveOne(s: String, k: Int): String {
            val chars = s.toCharArray()

            // 双指针法
            fun reverse(left: Int, right: Int) {
                var left = left
                var right = right
                while (right > left) {
                    val temp = chars[left]
                    chars[left++] = chars[right]
                    chars[right--] = temp
                }
            }

            repeat(chars.size / (2 * k) + 1) { count ->
                val start = count * 2 * k
                if (start + k < chars.size) {
                    reverse(start, start + k - 1)
                } else {
                    reverse(start, chars.size - 1)
                }
            }
            return String(chars)
        }
    }
}