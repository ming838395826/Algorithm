package com.ming.algorithm.simple

import java.util.*


/**
 * @Description 分发饼干
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FindContentChildren {

    companion object {
        /**
        假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
        对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，
        都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，
        这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: g = [1,2,3], s = [1,1]
            输出: 1
            解释:
            你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
            虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
            所以你应该输出1。
             */
            print("结果是${solveOne(intArrayOf(1, 2, 3), intArrayOf(1, 1))}\n")
        }

        /**
         * 贪心算法 结合双指针
         * 按最大的给
         */
        fun solveOne(g: IntArray, s: IntArray): Int {
            var result = 0
            g.sort()
            s.sort()
            var childIndex = g.size - 1
            var foodIndex = s.size - 1
            while (foodIndex >= 0 && childIndex >= 0) {
                // 大于的胃口 符合
                if (s[foodIndex] >= g[childIndex]) {
                    result++
                    childIndex--
                    foodIndex--
                } else {
                    childIndex--
                }

            }
            return result
        }
    }
}