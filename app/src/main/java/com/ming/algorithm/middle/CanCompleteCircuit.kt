package com.ming.algorithm.middle

import java.util.*
import kotlin.math.max
import kotlin.math.sign


/**
 * @Description 加油站
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class CanCompleteCircuit {

    companion object {
        /**
        在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
        你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
        给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
            输出: 3
            解释:
            从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
            开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
            开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
            开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
            开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
            开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
            因此，3 可为起始索引。
             */
            print("结果是${solveOne(intArrayOf(4, 2, 3), intArrayOf(4, 2, 3))}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 算出每一次差距多少，连续相加为负数，就停止，重新计算起点
         * 全部加起来 如果是负数 则表明无法到达
         */
        fun solveOne(gas: IntArray, cost: IntArray): Int {
            var totalSum = 0
            var currentSum = 0
            var startIndex = 0
            for (index in 0..gas.size - 1) {
                val diff = gas[index] - cost[index]
                totalSum += diff
                currentSum += diff
                if (currentSum < 0) {
                    currentSum = 0
                    // 无需判断是否超出范围，因为超出全部即为负数
                    startIndex = index + 1
                }
            }
            // 如果全部为负数，则表面无论如何都无法到达
            if (totalSum < 0) return -1
            return startIndex
        }
    }
}