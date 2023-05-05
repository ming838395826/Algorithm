package com.ming.algorithm.hard

import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.Comparator


/**
 * @Description 监控二叉树
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MinCameraCover {

    companion object {
        /**
        给定一个二叉树，我们在树的节点上安装摄像头。
        节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
        计算监控树的所有节点所需的最小摄像头数量。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: n = 10
            输出: 9
             */
            print("结果是${solveOne(TreeNode(0))}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 需要定义3种情况的数字
         * 0：无覆盖
         * 1：摄像头
         * 2：有覆盖
         * 然后从底到根节点遍历（因为叶节点比根节点多，按叶节点划算）
         * 分4种情况
         * a: 左右有无覆盖 -> 需要加摄像头
         * b: 左右有摄像头 -> 无需处理，返回有覆盖情况
         * c: 左右有覆盖 -> 无需处理，返回无覆盖
         * d: 根节点需要特殊判断 是否无覆盖，有就要加摄像头
         */
        fun solveOne(root: TreeNode?): Int {
            var result = 0
            fun traversal(root: TreeNode?): Int {
                // 终止条件
                if (root == null) {
                    return 2
                }
                val left = traversal(root.left)
                val right = traversal(root.right)
                return when {
                    //左右有无覆盖
                    left == 0 || right == 0 -> {
                        result++
                        1
                    }
                    left == 1 || right == 1 -> {
                        2
                    }
                    left == 2 || right == 2 -> {
                        0
                    }
                    else -> -1 // 前面所有情况都已经遍历了，实际不会走这里
                }

            }
            // 如果根节点是没有覆盖到的，因为没父节点了所以要加1
            if (traversal(root) == 0) {
                result++
            }
            return result
        }
    }
}