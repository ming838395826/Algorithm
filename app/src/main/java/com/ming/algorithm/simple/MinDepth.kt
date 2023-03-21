package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.math.max

/**
 * @Description    二叉树的最小深度
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MinDepth {

    companion object {
        /**
        给定一个二叉树，找出其最小深度。
        最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
        说明：叶子节点是指没有子节点的节点。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [3,9,20,null,null,15,7]
            输出：2
             */
            print("结果是${solveTwo(null)}\n")
        }

        /**
         * 迭代法
         */
        fun solveOne(root: TreeNode?): Int {
            var result = 1
            val queue = LinkedList<TreeNode>()
            if (root == null) return 0 else queue.offer(root)
            while (!queue.isEmpty()) {
                var size = queue.size
                while (size > 0) {
                    val node = queue.poll()
                    if (node.left == null && node.right == null) {
                        return result
                    }
                    if (node.left != null)
                        queue.offer(node.left)
                    if (node.right != null)
                        queue.offer(node.right)
                    size--
                }
                result++
            }
            return result
        }

        fun solveTwo(root: TreeNode?): Int {
            fun minDepth(root: TreeNode?): Int {
                if (root == null) {
                    return 0
                }
                if (root.left == null && root.right != null) {
                    return minDepth(root.right) + 1
                }
                if (root.left != null && root.right == null) {
                    return minDepth(root.left)  + 1
                }
                var left = minDepth(root.left)
                var right = minDepth(root.right)
                return Math.min(left, right) + 1
            }
            return minDepth(root)
        }
    }
}