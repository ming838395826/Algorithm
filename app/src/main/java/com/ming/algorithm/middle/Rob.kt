package com.ming.algorithm.middle

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  打家劫舍
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Rob {

    companion object {
        /**
        你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
        影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
        给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：[1,2,3,1]
            输出：4
            解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
            偷窃到的最高金额 = 1 + 3 = 4 。
             */
            print("结果是${solveOne(intArrayOf())}\n")
        }

        /**
         * 动态规划之背包问题
         * 定义： F[n][0] 为不偷的最大值 F[n][1] 为偷的最大值
         * 公式： F[n][0] = Math.max(F[n-1][0], F[n-1][1])
         *       F[n][0] = F[n-1][0] + cost[n]
         *       不偷情况下取最大值，即前面可不偷或偷
         *       偷的情况下，前面一定为不偷 ,所以为前面的最大值 加 cost[n]
         * 初始化： 初始化0 为不偷的时候 肯定为0 当偷的时候 也为0
         * 顺序： 因为有前面得来，所以为 从小到大
         */
        fun solveOne(nums: IntArray): Int {
            val result = Array(nums.size + 1) { IntArray(2) }
            for (i in 1.. nums.size) {
                result[i][0] = Math.max(result[i-1][0], result[i-1][1])
                result[i][1] = result[i-1][0] + nums[i-1]
            }
            return Math.max(result[nums.size][0], result[nums.size][1])
        }
    }
}