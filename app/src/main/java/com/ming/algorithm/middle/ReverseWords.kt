package com.ming.algorithm.middle

import kotlin.text.StringBuilder

/**
 * @Description 反转字符串中的单词
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ReverseWords {

    companion object {
        /**
        给你一个字符串 s ，请你反转字符串中 单词 的顺序。
        单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
        返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
        注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "the sky is blue"
            输出："blue is sky the"
             */
            print("结果是${solveOne("We are happy.")}\n")
        }

        /**
         * 双指针法 ，快慢指针
         * 1. 先反转
         * 2. 在单独反转每个单词
         * 3. 删掉多余的空格
         */
        fun solveOne(s: String): String {
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
            if (chars.isEmpty()) return ""
            // 反转整个数组
            reverse(chars, 0, chars.size - 1)
            // 将每个单词都反转
            var slow = 0 // 将要移动位置放置的指针
            var fast = 0 // 遍历的位置
            //先过滤前面为空格的
            while (fast < chars.size) {
                // 因为开头空格一定不需要
                if (chars[fast] == ' ') {
                    fast++
                    continue
                }
                // 记录开始的位置
                val start = fast
                while (fast < chars.size && chars[fast] != ' ') {
                    fast++
                }
                // 得到一个单词，进行反转
                reverse(chars, start, fast - 1)
                // 将单词进行移位
                repeat(fast - start) {
                    chars[slow++] = chars[start + it]
                }
                if (slow < chars.size) {
                    chars[slow++] = ' '
                }

            }
            return String(
                chars, 0, if (slow == chars.size && chars[slow - 1] != ' ') slow else slow - 1
            )
        }
    }
}