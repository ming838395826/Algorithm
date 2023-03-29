package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.time.OffsetDateTime
import java.util.*

/**
 * @Description  左叶子之和
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class SumOfLeftLeaves {

    companion object {
        /**
        给定二叉树的根节点 root ，返回所有左叶子之和。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: root = [3,9,20,null,null,15,7]
            输出: 24
            解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
             */
            val root = TreeNode(1)
            print("结果是${solveOne(root)}\n")
        }

        /**
         * 普通遍历
         * 迭代法
         */
        fun solveOne(root: TreeNode?): Int {
            val stack = Stack<TreeNode>()
            var sum = 0
            stack.add(root ?: return sum)
            while (!stack.isEmpty()) {
                val node = stack.pop()
                if (node.left != null && node.left?.left == null && node.left?.right == null) {
                    sum += node.left!!.`val`
                }
                if (node.left !=null)
                    stack.add(node.left)
                if (node.right !=null)
                    stack.add(node.right)
            }
            return sum
        }

        /**
         * 递归法
         */
        fun solveTwo(root: TreeNode?): Int {
            fun getLeftCount(node: TreeNode?): Int {
                if (node == null)
                    return 0
                // 确认是左叶点
                val left = getLeftCount(node.left)
                val right = getLeftCount(node.right)
                var minde = 0
                if (node.left != null && node.left?.left == null && node.left?.right == null) {
                    minde = node.left!!.`val`
                }
                return left + right + minde

            }
            return getLeftCount(root)
        }
    }
}