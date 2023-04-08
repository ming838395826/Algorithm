package com.ming.algorithm.simple

import android.R.integer
import com.ming.algorithm.bean.TreeNode
import java.util.*


/**
 * @Description  路径总和
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class HasPathSum {

    companion object {
        /**
        给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
        叶子节点 是指没有子节点的节点。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
            输出：true
            解释：等于目标和的根节点到叶节点路径如上图所示。
             */
            val root = TreeNode(1)
            print("结果是${solveOne(root,2)}\n")
        }

        /**
         * 层次遍历
         * 迭代法
         */
        fun solveOne(root: TreeNode?, targetSum: Int): Boolean {
            if (root == null) return false
            val stack1 = Stack<TreeNode>()
            val stack2 = Stack<Int>()
            stack1.push(root)
            stack2.push(targetSum)
            while (!stack1.isEmpty()) {
                val node = stack1.pop()
                val data = stack2.pop()
                if (node.left == null && node.right == null) {
                    if (data == node.`val`) {
                        return true
                    }
                }
                if (node.left != null) {
                    stack1.push(node.left)
                    stack2.push(data - node.`val`)
                }
                if (node.right != null) {
                    stack1.push(node.right)
                    stack2.push(data - node.`val`)
                }
            }
            return false
        }

        /**
         * 递归法
         */
        fun solveTwo(root: TreeNode?, targetSum: Int): Boolean {
            fun getTargetPath(node: TreeNode?, targetSum: Int): Boolean {
                if (node == null)
                    return false
                val data = targetSum - node.`val`
                if (node.left == null && node.right == null) {
                    return data == 0
                }
                if (getTargetPath(node.left, data)) {
                    return true
                }
                if (getTargetPath(node.right, data)) {
                    return true
                }
                return false
            }
            return getTargetPath(root, targetSum)
        }
    }
}