package com.ming.algorithm.middle

import java.util.*
import kotlin.Comparator


/**
 * @Description 合并区间
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Merge {

    companion object {
        /**
        以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
        请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
            输出：[[1,6],[8,10],[15,18]]
            解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
             */
            print("结果是${arrayOf(intArrayOf(1))}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 排序后，在用新的数组记录
         */
        fun solveOne(intervals: Array<IntArray>): Array<IntArray> {
            val result = mutableListOf<IntArray>()
            if (intervals.isEmpty()) return result.toTypedArray()
            intervals.sortWith(object : Comparator<IntArray> {
                override fun compare(o1: IntArray, o2: IntArray): Int {
                    return o1[0] - o2[0]
                }
            })
            result.add(intervals[0])
            for (index in 1 until intervals.size) {
                // 判断大小, 比他小证明重合了，需要合并
                val item = result[result.size - 1]
                if (intervals[index][0] <= item[1]) {
                    // 首位不许要，因为已经 排序排了
                    item[1] = Math.max(item[1], intervals[index][1])
                } else {
                    result.add(intervals[index])
                }
            }
            return result.toTypedArray()
        }
    }
}