package com.ming.algorithm.middle

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * @Description  字母异位词分组
 * @Author ming
 * @Date 2022/2/13 14:46
 */
class GroupAnagrams {

    companion object {
        /**
        给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
        字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
            输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
             */
            print("结果是${solveOne(arrayOf("eat","tea","tan","ate","nat","bat"))}\n")
        }

        /**
         * map
         * 将字符串排序,作为key
         */
        @RequiresApi(Build.VERSION_CODES.N)
        private fun solveOne(strs: Array<String>): List<List<String>> {
            val result = mutableListOf<List<String>>()
            val record = mutableMapOf<String, MutableList<String>>()
            strs.forEachIndexed { index, s ->
                val key = s.toCharArray().sorted().toString()
                val list = record[key] ?: mutableListOf()
                list.add(s)
                record[key] = list
            }
            record.forEach { s, strings ->
                result.add(strings)
            }
            return result
        }
    }
}