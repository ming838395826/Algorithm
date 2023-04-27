package com.ming.algorithm.hard

import java.util.*
import kotlin.math.max
import kotlin.math.sign


/**
 * @Description 分发糖果
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Candy {

    companion object {
        /**
        n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
        你需要按照以下要求，给这些孩子分发糖果：
        每个孩子至少分配到 1 个糖果。
        相邻两个孩子评分更高的孩子会获得更多的糖果。
        请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：ratings = [1,0,2]
            输出：5
            解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
             */
            print("结果是${solveOne(intArrayOf(1, 3, 4, 5, 2))}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 要分2次遍历，从左边 在遍历到右边
         */
        fun solveOne(ratings: IntArray): Int {
            if (ratings.size == 1) return 1
            val result = IntArray(ratings.size) { 1 }
            // 左边
            for (index in 1 until ratings.size) {
                if (ratings[index] > ratings[index - 1]) {
                    result[index] = result[index - 1] + 1
                }
            }
            // 右边
            for (index in ratings.size - 2 downTo 0) {
                if (ratings[index] < ratings[index + 1]) {
                    result[index] = Math.max(result[index + 1] +1, result[index])
                }
            }
            return result.sum()
        }
    }
}