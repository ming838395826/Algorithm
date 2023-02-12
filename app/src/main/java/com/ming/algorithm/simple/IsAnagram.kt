package com.ming.algorithm.simple

import java.lang.StringBuilder

/**
 * @Description 有效的字母异位词
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class IsAnagram {

    companion object {
        /**
        给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
        注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: s = "anagram", t = "nagaram"
            输出: true
             */
            print("结果是${solveOne("anagram", "nagaram")}\n")
        }

        /**
         * 取模
         */
        fun solveOne(s: String, t: String): Boolean {
            val record = IntArray(26)
            s.forEach {
                record[it - 'a']++
            }
            t.forEach {
                record[it - 'a']--
            }
            record.forEach {
                if (it != 0) return false
            }
            return true
        }
    }
}