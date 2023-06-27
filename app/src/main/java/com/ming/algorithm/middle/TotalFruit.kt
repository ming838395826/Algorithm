package com.ming.algorithm.middle

import com.ming.algorithm.simple.ListNodePlus
import java.util.*


/**
 * @Description 水果成篮
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class TotalFruit {

    companion object {
        /**
        你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，
        其中 fruits[i] 是第 i 棵树上的水果 种类 。
        你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
        你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
        你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
        一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
        给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：fruits = [1,2,1]
            输出：3
            解释：可以采摘全部 3 棵树。
             */
            print("结果是${solveOne(intArrayOf(0, 1, 6, 6, 4, 4, 6))}\n")
        }

        /**
         * 滑窗法
         */
        fun solveOne(fruits: IntArray): Int {
            var resut = 0
            // 代表2个类型
            var one = -1
            var two = -1
            var start = 0
            for (i in 0 until fruits.size) {
                val item = fruits[i]
                // 相等的情况
                if (one == -1 || item == one) {
                    one = item
                } else if (two == -1 || item == two) {
                    two = item
                } else {
                    // 如果2个都不相等，那么就是新的树，则要更新start的位置
                    start = i - 1
                    // 得到前一个的值
                    val preItem = fruits[start]
                    // 往前面遍历，如果是相同的就一直往前推
                    while (preItem == fruits[start - 1]) {
                        start--
                    }
                    // 更新位置
                    if (one != preItem) {
                        one = item
                    } else {
                        two = item
                    }
                }
                resut = Math.max(resut, i - start + 1)
            }
            return resut
        }
    }
}