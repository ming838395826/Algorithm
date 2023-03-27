package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.time.OffsetDateTime
import java.util.*

/**
 * @Description  平衡二叉树
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class IsBalanced {

    companion object {
        /**
        给定一个二叉树，判断它是否是高度平衡的二叉树。
        本题中，一棵高度平衡二叉树定义为：
        一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [3,9,20,null,null,15,7]
            输出：true
             */
            val root = TreeNode(1)
            print("结果是${solveOne(root)}\n")
        }

        /**
         * 普通遍历
         * 迭代法
         */
        fun solveOne(root: TreeNode?): Boolean {
            val queue = LinkedList<TreeNode>()
            queue.offer(root ?: return true)
            var maxDepth = 0
            var minDepth = 0
            while (!queue.isEmpty()) {
                maxDepth++
                var size = queue.size
                while (size-- > 0) {
                    val node = queue.poll()
                    if (node.left != null)
                        queue.offer(node.left)
                    if (node.right != null)
                        queue.offer(node.right)
                    if (node.left == null && node.right == null && minDepth == 0) {
                        minDepth = maxDepth
                    }
                }
            }
            return maxDepth - minDepth <= 1
        }

        /**
         * 递归法
         * 关键是利用完全二叉树的特性和节点的统计
         */
        fun solveTwo(root: TreeNode?): Boolean {
            fun getDeepth(node: TreeNode?): Int {
                if (node == null)
                    return 0
                val leftDeepth = getDeepth(node.left)
                val rightDeepth = getDeepth(node.right)
                if (leftDeepth == -1)
                    return -1
                if (rightDeepth == -1)
                    return -1
                // 高度超过1
                if (Math.abs(leftDeepth - rightDeepth) > 1)
                    return -1
                return Math.max(leftDeepth, rightDeepth) + 1

            }
            return getDeepth(root) != -1
        }
    }
}