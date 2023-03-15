package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  翻转二叉树
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class InvertTree {

    companion object {
        /**
        给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [4,2,7,1,3,6,9]
            输出：[4,7,2,9,6,3,1]
             */
            print("结果是${solveOne(TreeNode(1))}\n")
        }

        /**
         * 递归法s
         */
        fun solveOne(root: TreeNode?): TreeNode? {
            fun invert(root: TreeNode?) {
                if (root == null) return
                val temp = root.left
                root.left = root.right
                root.right = temp
                invert(root.left)
                invert(root.right)
            }
            invert(root)
            return root
        }

        /**
         * 迭代法
         */
        fun solveTwo(root: TreeNode?): TreeNode? {
            val stack = Stack<TreeNode>()
            stack.push(root ?: return root)
            while (!stack.isEmpty()) {
                val node = stack.pop()
                val temp = node.left
                node.left = node.right
                node.right = temp
                if (node.left != null) {
                    stack.push(node.left)
                }
                if (node.right != null) {
                    stack.push(node.right)
                }
            }
            return root
        }

        /**
         * 层次遍历
         */
        fun solveThree(root: TreeNode?): TreeNode? {
            val stack = LinkedList<TreeNode>()
            stack.offer(root ?: return root)
            while (!stack.isEmpty()) {
                var size = stack.size
                while (size > 0) {
                    val node = stack.poll()
                    val temp = node.left
                    node.left = node.right
                    node.right = temp
                    if (node.left != null) {
                        stack.offer(node.left)
                    }
                    if (node.right != null) {
                        stack.offer(node.right)
                    }
                    size--
                }
            }
            return root
        }
    }
}