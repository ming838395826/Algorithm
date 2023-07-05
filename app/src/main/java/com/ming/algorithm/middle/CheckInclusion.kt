package com.ming.algorithm.middle

import com.ming.algorithm.simple.ListNodePlus
import java.util.*


/**
 * @Description 字符串的排列
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class CheckInclusion {

    companion object {
        /**
        给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
        换句话说，s1 的排列之一是 s2 的 子串 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s1 = "ab" s2 = "eidbaooo"
            输出：true
            解释：s2 包含 s1 的排列之一 ("ba").
             */
            print("结果是${solveOne("ab", "eidbaooo")}\n")
        }

        /**
         * 滑窗法
         * 可以保证如果有是唯一答案，就不用记录最小的了
         * 技巧用 char 做数组
         */
        fun solveOne(s1: String, s2: String): Boolean {
            if (s1.length > s2.length) return false
            val record = IntArray(26)
            var count = s1.length
            var left = 0
            // 初始化
            s1.forEach {
                record[it - 'a']++
            }
            s2.forEachIndexed { right, c ->
                if (record[c - 'a'] > 0) {
                    count--
                }
                record[c - 'a']--
                if (count == 0) {
                    // 去除前面不符合的字符
                    while (left < right && record[s2[left] - 'a'] < 0) {
                        record[s2[left] - 'a']++
                        left++
                    }
                    // 长度相等 则等于
                    if (right- left +1 == s1.length){
                        return true
                    }
                    // 去除前面符合的,到达不符合的,后面继续滑动右指针
                    while (left < right && record[s2[left] - 'a'] >= 0) {
                        record[s2[left] - 'a']++
                        left++
                        count++
                    }
                }
            }
            return false
        }
    }
}