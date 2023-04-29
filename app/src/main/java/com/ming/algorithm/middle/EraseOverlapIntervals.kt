package com.ming.algorithm.middle

import java.util.*


/**
 * @Description 无重叠区间
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class EraseOverlapIntervals {

    companion object {
        /**
        给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
        返回 需要移除区间的最小数量，使剩余区间互不重叠 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
            输出: 1
            解释: 移除 [1,3] 后，剩下的区间没有重叠。
             */
            print("结果是${solveOne(arrayOf(intArrayOf(-2147483646,-2147483645), intArrayOf(2147483646,2147483647)))}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 计算出不重复的区间
         */
        fun solveOne(intervals: Array<IntArray>): Int {
            if (intervals.size <= 1) return 0
            var result = 1 // 默认为1 因为第一个肯定是射需要一根的
            // 先排序
            intervals.sortWith(object : Comparator<IntArray>{
                override fun compare(o1: IntArray, o2: IntArray): Int {
                    // 使用内置函数，防止溢出
                    return Integer.compare(o1[0] , o2[0])
                }
            })
            //
            for (index in 1 until intervals.size) {
                // 判断是否重复
                if (intervals[index][0] < intervals[index - 1][1]) {
                    intervals[index][1] = Math.min(intervals[index][1], intervals[index - 1][1])
                } else {
                    // 不重合的区域加1
                    result++
                }
            }
            return intervals.size - result
        }
    }
}