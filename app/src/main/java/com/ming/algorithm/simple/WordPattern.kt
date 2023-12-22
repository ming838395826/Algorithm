package com.ming.algorithm.simple


/**
 * @Description 单词规律
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class WordPattern {

    companion object {
        /**
        给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
        这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: pattern = "abba", s = "dog cat cat dog"
            输出: true
             */
            print("结果是${solveOne("", "")}\n")
        }

        /**
         * 双射
         */
        fun solveOne(pattern: String, s: String): Boolean {
            val data = s.split(" ")
            if (data.size != pattern.length) return false
            val recordP = mutableMapOf<Char, Int>()
            val recordS = mutableMapOf<String, Int>()
            pattern.forEachIndexed { index, item ->
                if ((recordP[item] ?: -1) != (recordS[data[index]] ?: -1))
                    return false
                recordP[item] = index
                recordS[data[index]] = index
            }
            return true
        }
    }
}