package com.ming.algorithm.simple

import kotlin.text.StringBuilder

/**
 * @Description 比较含退格的字符串
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class BackspaceCompare {

    companion object {
        /**
        给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
        注意：如果对空文本输入退格字符，文本继续为空。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "ab#c", t = "ad#c"
            输出：true
            解释：s 和 t 都会变成 "ac"。
             */
            print("结果是${solveOne("a#c", "c#d#")}\n")
        }

        /**
         * 双指针法
         * 关键要保持顺序
         */
        fun solveOne(s: String, t: String): Boolean {

            fun getResultStr(s: String): String {
                var slow = 0
                var fast = 0
                val charArray = s.toCharArray()
                while (fast < charArray.size) {
                    if (s[fast] == '#') {
                        if (slow > 0) slow--
                    } else {
                        charArray[slow++] = charArray[fast]
                    }
                    fast++
                }
                return String(charArray, 0, slow)
            }
            return getResultStr(s) == getResultStr(t)
        }
    }
}