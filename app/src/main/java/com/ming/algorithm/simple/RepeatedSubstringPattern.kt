package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description 重复的子字符串
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class RepeatedSubstringPattern {

    companion object {
        /**
        给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: s = "abab"
            输出: true
            解释: 可由子串 "ab" 重复两次构成。
             */
            print("结果是${solveOne("")}\n")
        }

        /**
         *  将s字符串首尾连起来，去除头和尾 要是中间有能组成s ，则有重复的字符串
         *  不去除头尾那肯定有
         *  用contain，即kpm算法，判断是否包含一个字符串s
         */
        fun solveOne(s: String): Boolean {

            /**
             * 获取前缀表
             */
            fun getNext(data: String): IntArray {
                val record = IntArray(data.length)
                var i = 1
                var j = 0 // 代表前缀的结尾
                while (i < data.length) {
                    while (j > 0 && data[j] != data[i]) {
                        j = record[j - 1]
                    }
                    if (data[j] == data[i]) {
                        j++
                    }
                    record[i] = j
                    i++
                }
                return record
            }

            fun contain(source: String, match: String): Boolean {
                if (match.isEmpty()) return false
                val record = getNext(match)
                var j = 0
                source.forEachIndexed { i, item ->
                    while (j > 0 && match[j] != item) {
                        j = record[j - 1]
                    }
                    if (match[j] == item) {
                        j++
                    }
                    if (j == match.length)
                        return true
                }
                return false
            }

            val result = s + s
            return contain(result.substring(1, result.length - 1), s)
        }

        fun solveTwo(s: String): Boolean {
            val result = s + s
            return result.substring(1, result.length - 1).contains(s)
        }
    }
}