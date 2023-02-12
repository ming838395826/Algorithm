package com.ming.algorithm.simple

import java.lang.StringBuilder

/**
 * @Description 赎金信
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class CanConstruct {

    companion object {
        /**
        给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
        如果可以，返回 true ；否则返回 false 。
        magazine 中的每个字符只能在 ransomNote 中使用一次。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：ransomNote = "a", magazine = "b"
            输出：false
             */
            print(
                "结果是${solveOne("aa", "aab")}\n"
            )
        }

        /**
         *  还是用数组记录每个字母的出现次数，去想减，唯一不同的是 因为一个字母只能用一次
         */
        fun solveOne(ransomNote: String, magazine: String): Boolean {
            val record = IntArray(26)
            // 记录原来字母的次数
            magazine.forEach {
                record[it - 'a'] = record[it - 'a'] + 1
            }
            ransomNote.forEach {
                // 不存在的时候，等于0 - 1
                record[it - 'a'] = record[it - 'a'] - 1
                if (record[it - 'a'] < 0) {
                    return false
                }
            }
            return true
        }
    }
}