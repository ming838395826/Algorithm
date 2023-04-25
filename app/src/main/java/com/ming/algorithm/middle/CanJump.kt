package com.ming.algorithm.middle

import java.util.*


/**
 * @Description 跳跃游戏
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class CanJump {

    companion object {
        /**
        给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
        数组中的每个元素代表你在该位置可以跳跃的最大长度。
        判断你是否能够到达最后一个下标。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [2,3,1,1,4]
            输出：true
            解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
             */
            print("结果是${solveOne(intArrayOf(3, 2, 1, 0, 4))}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 每次取最大跳跃步数（取最大覆盖范围），整体最优解：最后得到整体最大覆盖范围，看是否能到终点。
         * 局部最优推出全局最优，找不出反例，试试贪心！
         * 因为只需要返回false，所以可以只判断覆盖范围是否到达
         */
        fun solveOne(nums: IntArray): Boolean {
            if (nums.size <= 1) return true
            var step = 0
            // 需要的是更新范围的遍历
            var current = 0
            while (current <= step) {
                // 遍历每一位，得到最大的范围
                step = Math.max(current + nums[current], step)
                if (step >= nums.size - 1) {
                    return true
                }
                current++
            }
            return false
        }
    }
}