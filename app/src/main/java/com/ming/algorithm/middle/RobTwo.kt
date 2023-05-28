package com.ming.algorithm.middle

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  打家劫舍 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class RobTwo {

    companion object {
        /**
        你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
        这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
        如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
        给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [2,3,2]
            输出：3
            解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
             */
            print("结果是${solveOne(intArrayOf(1))}\n")
        }

        /**
         * 动态规划之背包问题
         * 定义： F[n][0] 为不偷的最大值 F[n][1] 为偷的最大值
         * 公式： F[n][0] = Math.max(F[n-1][0], F[n-1][1])
         *       F[n][0] = F[n-1][0] + cost[n]
         *       不偷情况下取最大值，即前面可不偷或偷
         *       偷的情况下，前面一定为不偷 ,所以为前面的最大值 加 cost[n]
         *       因为是循环，所以我们要确定起点有3种情况
         *       一： 不拿首尾的情况
         *       二： 拿头不拿尾
         *       三： 拿尾不拿头
         *       可以看出 二 三情况包含了 一。所以判断二三的情况即可
         * 初始化： 初始化0 为不偷的时候 肯定为0 当偷的时候 也为0
         * 顺序： 因为有前面得来，所以为 从小到大
         */
        fun solveOne(nums: IntArray): Int {
            if (nums.size == 1) return nums[0]
            val resultTwo = Array(nums.size) { IntArray(2) }
            val resultThree = Array(nums.size + 1) { IntArray(2) }
            // 包含头 不包含尾的情况
            for (i in 1 until  nums.size) {
                resultTwo[i][0] = Math.max(resultTwo[i-1][0], resultTwo[i-1][1])
                resultTwo[i][1] = resultTwo[i-1][0] + nums[i-1]
            }
            // 包含尾 不包含头的情况
            for (i in 2 ..  nums.size) {
                resultThree[i][0] = Math.max(resultThree[i-1][0], resultThree[i-1][1])
                resultThree[i][1] = resultThree[i-1][0] + nums[i-1]
            }
            return Math.max(Math.max(resultTwo[nums.size-1][0], resultTwo[nums.size-1][1]),
                Math.max(resultThree[nums.size][0], resultThree[nums.size][1]))
        }
    }
}