package com.ming.algorithm.middle

import java.util.*
import kotlin.math.max


/**
 * @Description 跳跃游戏 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Jump {

    companion object {
        /**
        给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
        每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
        0 <= j <= nums[i]
        i + j < n
        返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: nums = [2,3,1,1,4]
            输出: 2
            解释: 跳到最后一个位置的最小跳跃数是 2。
            从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
             */
            print("结果是${solveOne(intArrayOf(3, 2, 1, 0, 4))}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 当前可移动距离尽可能多走，如果还没到终点，步数再加一。整体最优：一步尽可能多走，从而达到最小步数。
         * 2,1,2,1,2,1,1,1
         */
        fun solveOne(nums: IntArray): Int {
            if (nums.size <= 1) return 0
            var result = 0
            var maxDistance = 0 // 最大的覆盖区域
            var currentDistance = 0 // 当前的覆盖最大区域
            nums.forEachIndexed { index, step ->
                // 得到该范围最大的覆盖范围
                maxDistance = Math.max(maxDistance, index + step)
                // 如果当前最大的覆盖范围已经到达数组结尾，证明遍历到了结束
                if (maxDistance >= nums.size - 1) {
                    result++
                    return result
                }
                //走到当前覆盖的最大区域时，更新下一步可达的最大区域
                if (currentDistance == index) {
                    currentDistance = maxDistance
                    result++
                }
            }
            return result
        }
    }
}