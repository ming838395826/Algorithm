package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  反转字符串中的元音字母
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ReverseVowels {

    companion object {
        /**
        给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
        元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "hello"
            输出："holle"
             */
            print("结果是${solveOne("")}\n")
        }

        /**
         * 双指针
         */
        fun solveOne(s: String): String {
            val record = arrayListOf('a', 'e', 'i', 'o', 'u')
            var left = 0
            var right = s.length - 1
            val result = s.toCharArray()
            while (left < right) {
                while (left < right && !record.contains(result[left].toLowerCase())) {
                    left++
                }
                while (left < right && !record.contains(result[right].toLowerCase())) {
                    right--
                }
                if (left >= right) {
                    break
                }
                val temp = result[left]
                result[left] = result[right]
                result[right] = temp
                left++
                right--
            }
            return result.concatToString()
        }
    }
}