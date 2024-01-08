package com.ming.algorithm.simple

import android.support.v4.app.INotificationSideChannel


/**
 * @Description 字符串中的第一个唯一字符
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FirstUniqChar {

    companion object {
        /**
        给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: s = "leetcode"
            输出: 0
             */
            print("结果是${solveOne("leetcode")}\n")
        }

        fun solveOne(s: String): Int {
            val record = mutableMapOf<Char, MutableList<Int>>()
            s.forEachIndexed { index, c ->
                val list = record.get(c) ?: mutableListOf()
                list.add(index)
                record[c] = list
            }
            record.forEach { aciton ->
                if (aciton.value.size == 1) {
                    return aciton.value.get(0)
                }
            }
            return -1
        }
    }
}