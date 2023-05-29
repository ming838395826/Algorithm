package com.ming.algorithm.middle

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  打家劫舍 III
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class RobThree {

    companion object {
        /**
        小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
        除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
        聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
        给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: root = [3,2,3,null,3,null,1]
            输出: 7
            解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
             */
            print("结果是${solveOne(TreeNode(0))}\n")
        }

        /**
         * 动态规划之背包问题
         * 定义： F[n][0] 为不偷的最大值 F[n][1] 为偷的最大值
         * 公式： F[n][0] = Math.max(F[n-1][0], F[n-1][1])
         *       F[n][0] = F[n-1][0] + cost[n]
         *       不偷情况下取最大值，即前面可不偷或偷
         *       偷的情况下，前面一定为不偷 ,所以为前面的最大值 加 cost[n]
         *       因为是二叉树，要后续遍历，这样才能从底部开始
         *       根节点不偷，需要判断
         * 初始化： 初始化0 为不偷的时候 肯定为0 当偷的时候 也为0
         * 顺序： 因为有前面得来，所以为 从小到大
         */
        fun solveOne(root: TreeNode?): Int {
            /**
             * 后续遍历
             */
            fun travel(root: TreeNode?): IntArray {
                if (root == null) {
                    return IntArray(2)
                }
                val left = travel(root.left)
                val right = travel(root.right)
                // 判断情况
                // 偷当前节点，那么左右不能偷
                val one = left[0] + right[0] + root.`val`
                // 不偷当前节点
                val two = Math.max(left[0], left[1]) + Math.max(right[0], right[1])
                return intArrayOf(two, one)
            }

            val result = travel(root)
            return Math.max(result[0], result[1])
        }
    }
}