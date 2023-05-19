package com.ming.algorithm.middle

import java.util.*

/**
 * @Description 组合总和 Ⅳ
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class CombinationSum4 {

    companion object {
        /**
        给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
        题目数据保证答案符合 32 位整数范围。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [1,2,3], target = 4
            输出：7
            解释：
            所有可能的组合为：
            (1, 1, 1, 1)
            (1, 1, 2)
            (1, 2, 1)
            (1, 3)
            (2, 1, 1)
            (2, 2)
            (3, 1)
            请注意，顺序不同的序列被视作不同的组合。
             */
            print("结果是${solveOne(intArrayOf(),3)}\n")
        }

        /**
         * 动态规划
         * 1.矩阵意义：F[n] 表示 到达容量为4 容量为你的背包最多有多少种方法
         * 2.定义：IntArray[]
         * 3.公式：F[n] += F[n - i]
         *        求的是最多有多少种，减去对应要加的数 就是那个数有多少种方法
         *        因为一个硬币可以多次使用，那么就是要从小遍历到大，记录是排列
         * 4.初始化  初始化0 ，当容量为0 时候， 也是1种方式
         * 5.遍历顺序  从大到小，如果从小到大，会重复。因为是二维数组是压缩为一维，
         *        前面数值会移动到后面
         * 5.计算矩阵
         */
        fun solveOne(nums: IntArray, target: Int): Int {
            val result = IntArray(target + 1)
            result[0] = 1
            // 排列 先遍历容量 再遍历物品
            for (j in 1..target) {
                for (i in 0 until nums.size) {
                    if (nums[i] <= j) {
                        result[j] += result[j - nums[i]]
                    }
                }
            }
            return result[target]
        }
    }
}