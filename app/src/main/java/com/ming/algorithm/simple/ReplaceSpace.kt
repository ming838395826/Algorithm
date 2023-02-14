package com.ming.algorithm.simple

import kotlin.text.StringBuilder

/**
 * @Description 替换空格
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ReplaceSpace {

    companion object {
        /**
        请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "We are happy."
            输出："We%20are%20happy."
             */
            print("结果是${solveOne("We are happy.")}\n")
        }

        /**
         * 双指针法
         */
        fun solveOne(s: String): String {
            if (s.isEmpty()) {
                return s
            }
            val stringBuilder = StringBuilder()
            var s = s
            s.forEach {
                if (it == ' ') {
                    stringBuilder.append("  ")
                }
            }
            var left = s.length - 1
            s += stringBuilder.toString()
            var right = s.length - 1
            var chars = s.toCharArray()
            while (left > 0 && left != right) {
                if (chars[left] != ' ') {
                    chars[right] = chars[left]
                } else {
                    chars[right--] = '0'
                    chars[right--] = '2'
                    chars[right] = '%'
                }
                left--
                right--
            }
            return chars.concatToString()
        }
    }
}