package com.ming.algorithm.simple

import java.lang.StringBuilder

/**
 * @Description 最长公共前缀
 * @Author ming
 * @Date 2021/9/25 16:34
 */
class LongestCommonPrefix {

    companion object {
        /**
        编写一个函数来查找字符串数组中的最长公共前缀。
        如果不存在公共前缀，返回空字符串 ""。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：strs = ["flower","flow","flight"]
            输出："fl"
             */
            print("结果是${solveOne(arrayOf("ab","a"))}\n")
        }

        fun solveOne(strs: Array<String>): String {
            var maxIndex = 0
            var result = StringBuilder()
            repeat(strs.size - 1) {
                if (strs[it].length > strs[maxIndex].length) {
                    maxIndex = it
                }
            }
            for (index in 0 until strs[maxIndex].length) {
                val maxItem = strs[maxIndex]
                for (item in strs) {
                    if (item.length <= index || item[index] != maxItem[index]) {
                        return result.toString()
                    }
                }
                result.append(maxItem[index])
            }
            return result.toString()
        }
    }
}