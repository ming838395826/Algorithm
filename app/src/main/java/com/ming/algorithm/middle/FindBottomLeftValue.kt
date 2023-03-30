package com.ming.algorithm.middle

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.time.OffsetDateTime
import java.util.*

/**
 * @Description  找树左下角的值
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FindBottomLeftValue {

    companion object {
        /**
        给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
        假设二叉树中至少有一个节点。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: root = [2,1,3]
            输出: 1
             */
            val root = TreeNode(1)
            print("结果是${solveOne(root)}\n")
        }

        /**
         * 层次遍历
         * 迭代法
         */
        fun solveOne(root: TreeNode?): Int {
            val stack = LinkedList<TreeNode>()
            stack.offer(root ?: return 0)
            var result: TreeNode? = null
            while (!stack.isEmpty()) {
                var size = stack.size
                result = stack.peek()
                while (size-- > 0) {
                    val node = stack.poll()
                    if (node.left != null)
                        stack.offer(node.left)
                    if (node.right != null)
                        stack.offer(node.right)
                }
            }
            return result!!.`val`
        }

        /**
         * 递归法
         */
        fun solveTwo(root: TreeNode?): Int {
            var maxDepth = 0
            var leftNode = root
            fun getLeftNode(node: TreeNode?, depth: Int) {
                if (node == null)
                    return
                // 确认是左叶点
                getLeftNode(node.left, depth + 1)
                getLeftNode(node.right, depth + 1)
                if (depth > maxDepth) {
                    maxDepth = depth
                    leftNode = node
                }
            }
            getLeftNode(root, 0)
            return leftNode?.`val` ?: 0
        }
    }
}