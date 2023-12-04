package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.lang.StringBuilder
import java.util.*

/**
 * @Description  最后一个单词的长度
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class LengthOfLastWord {

    companion object {
        /**
        给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
        单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "Hello World"
            输出：5
            解释：最后一个单词是“World”，长度为5。
             */
            print("结果是${solveOne("Hello World")}\n")
        }

        /**
         * 中序遍历
         */
        fun solveOne(s: String): Int {
            val stack = LinkedList<Char>()
            for (index in s.length -1 downTo 0) {
                // 遇到空格往外弹
                if (s[index] == ' ') {
                    if (stack.size != 0) {
                        break
                    }
                } else {
                    stack.push(s[index])
                }
            }
            return stack.size
        }
    }
}