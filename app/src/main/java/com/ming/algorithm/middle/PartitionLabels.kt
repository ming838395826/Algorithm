package com.ming.algorithm.middle

import java.util.*


/**
 * @Description 划分字母区间
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class PartitionLabels {

    companion object {
        /**
        给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
        注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
        返回一个表示每个字符串片段的长度的列表
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "ababcbacadefegdehijhklij"
            输出：[9,7,8]
            解释：
            划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
            每个字母最多出现在一个片段中。
            像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
             */
            print("结果是${solveOne("")}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 先算出所有的最远数组是多少
         */
        fun solveOne(s: String): List<Int> {
            val result = mutableListOf<Int>()
            var fastIndex = 0
            var preEndIndex = -1
            // 上一次的开始的位置
            val countList = IntArray(26) { 0 }
            // 保存出现的最远位置
            s.forEachIndexed { index, item ->
                countList[item - 'a'] = index
            }
            // 开始遍历，当前最远的距离等于当前位置，即为一组
            s.forEachIndexed { index, item ->
                fastIndex = Math.max(countList[item - 'a'], fastIndex)
                if (index == fastIndex) {
                    result.add(fastIndex - preEndIndex)
                    preEndIndex = fastIndex
                }
            }
            return result
        }
    }
}