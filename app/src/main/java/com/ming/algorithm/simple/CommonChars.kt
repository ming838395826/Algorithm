package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  查找共用字符
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class CommonChars {

    companion object {
        /**
        给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：words = ["bella","label","roller"]
            输出：["e","l","l"]
             */
            print("结果是${solveOne(arrayOf("bella","label","roller"))}\n")
        }

        /**
         * 用数组代替hasmap，记录最小值，不为0就是
         */
        fun solveOne(words: Array<String>): List<String> {
            // 默认最大值
            val record = IntArray(26) { Int.MAX_VALUE }
            words.forEach { item ->
                val dataRecord = IntArray(26)
                item.forEach {
                    dataRecord[it - 'a']++
                }
                // 获取最小值
                record.forEachIndexed { index, i ->
                    record[index] = Math.min(i, dataRecord[index])
                }
            }
            val result = mutableListOf<String>()
            record.forEachIndexed { index, i ->
                repeat(i) {
                    result.add((index + 'a'.toInt()).toChar().toString())
                }
            }
            return result
        }
    }
}