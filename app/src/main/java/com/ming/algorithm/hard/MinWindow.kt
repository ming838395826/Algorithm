package com.ming.algorithm.hard

import com.ming.algorithm.simple.ListNodePlus
import java.util.*


/**
 * @Description 最小覆盖子串
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MinWindow {

    companion object {
        /**
        给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
        如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
        注意：
        对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
        如果 s 中存在这样的子串，我们保证它是唯一的答案。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：fruits = [1,2,1]
            输出：3
            解释：可以采摘全部 3 棵树。
             */
            print("结果是${solveOne("ADOBECODEBANC", "ABC")}\n")
        }

        /**
         * 滑窗法
         * 可以保证如果有是唯一答案，就不用记录最小的了
         * 技巧用 char 做数组
         */
        fun solveOne(s: String, t: String): String {
            var left = 0
            var right = -1
            // 还需要多少满足
            val record = IntArray(128)
            var start = 0
            var size = Int.MAX_VALUE
            var count = t.length //需要的数量
            // 初始化
            t.forEach {
                record[it.toInt()]++
            }
            s.forEachIndexed { index, c ->
                right++
                // 直接减去
                if (record[c.toInt()] > 0) {
                    count--
                }
                record[c.toInt()]--
                // 全部都满足了，要移动左边left
                if (count == 0) {
                    // 如果是小于0 表示无关的元素，继续移动
                    while (left < right && record[s[left].toInt()] < 0) {
                        record[s[left].toInt()]++
                        left++
                    }
                    // 最小的一个
                    if (right - left + 1 < size) {
                        size = right - left + 1
                        start = left
                    }
                    // 这里是 等于或者大于0 即包含的元素，因为Left要右移动,大于0表示又要需要添加元素
                    record[s[left].toInt()]++
                    left++
                    // 需要的总数也要加回去
                    count++
                }
            }
            return if (size == Int.MAX_VALUE) "" else s.substring(start, start + size)
        }
    }
}