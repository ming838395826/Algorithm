package com.ming.algorithm.middle

import java.util.*


/**
 * @Description 用最少数量的箭引爆气球
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FindMinArrowShots {

    companion object {
        /**
        有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend]
        表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
        一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，
        若有一个气球的直径的开始和结束坐标为 xstart，xend，
        且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
        给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：points = [[10,16],[2,8],[1,6],[7,12]]
            输出：2
            解释：气球可以用2支箭来爆破:
            -在x = 6处射出箭，击破气球[2,8]和[1,6]。
            -在x = 11处发射箭，击破气球[10,16]和[7,12]。
             */
            print("结果是${solveOne(arrayOf(intArrayOf(-2147483646,-2147483645), intArrayOf(2147483646,2147483647)))}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 查看哪里重复的区间用一枝箭
         */
        fun solveOne(points: Array<IntArray>): Int {
            if (points.size <= 1) return points.size
            var result = 1 // 默认为1 因为第一个肯定是射需要一根的
            // 先排序
            points.sortWith(object : Comparator<IntArray>{
                override fun compare(o1: IntArray, o2: IntArray): Int {
                    // 使用内置函数，防止溢出
                    return Integer.compare(o1[0] , o2[0])
                }
            })
            //
            for (index in 1 until points.size) {
                if (points[index][0] > points[index - 1][1]) {
                    result++
                } else {
                    // 表明有重复的 取最右边的一个,因为有可能前面一个的右边还大于当前的右边
                    points[index][1] = Math.min(points[index - 1][1], points[index][1])
                }
            }
            return result
        }
    }
}