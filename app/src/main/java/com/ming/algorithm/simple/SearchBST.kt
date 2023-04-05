package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.util.*


/**
 * @Description  二叉搜索树中的搜索
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class SearchBST {

    companion object {
        /**
        给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
        你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [4,2,7,1,3], val = 2
            输出：[2,1,3]
             */
            val root = TreeNode(1)
            print("结果是${solveOne(root, 1)}\n")
        }

        /**
         * 递归法，中遍历
         */
        fun solveOne(root: TreeNode?, `val`: Int): TreeNode? {
            fun getTreeNode(root: TreeNode?, `val`: Int): TreeNode? {
                // 确定终止, 2个都为空，叶子节点
                if (root == null) {
                    return null
                }
                if (root.`val` == `val`) {
                    return root
                }
                val node = if (root.`val` > `val`) {
                    root.left
                } else {
                    root.right
                }
                return getTreeNode(node, `val`)
            }
            return getTreeNode(root, `val`)
        }

        /**
         * 迭代法
         * 栈迭代
         */
        fun solveTwo(root: TreeNode?, `val`: Int): TreeNode? {
            val stack = Stack<TreeNode>()
            stack.push(root ?: return root)
            while (!stack.isEmpty()) {
                val node = stack.pop()
                if (node.`val` == `val`) {
                    return node
                }
                if (node.`val` > `val` && node.left != null) {
                    stack.push(node.left)
                } else if (node.`val` < `val` && node.right != null) {
                    stack.push(node.right)
                } else {
                    return null
                }
            }
            return null
        }

        /**
         * 迭代法
         * 利用二叉搜索树特点，优化，可以不需要栈
         */
        fun solveThree(root: TreeNode?, `val`: Int): TreeNode? {
            var root = root
            while (root != null)
                root = if (`val` < root.`val`) root.left
                else if (`val` > root.`val`) root.right
                else return root
            return null
        }
    }
}