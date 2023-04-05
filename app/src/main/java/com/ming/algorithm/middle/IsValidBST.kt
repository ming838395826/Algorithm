package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.*


/**
 * @Description  验证二叉搜索树
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class IsValidBST {

    companion object {
        /**
        给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
        有效 二叉搜索树定义如下：
        节点的左子树只包含 小于 当前节点的数。
        节点的右子树只包含 大于 当前节点的数。
        所有左子树和右子树自身必须也是二叉搜索树。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [2,1,3]
            输出：true
             */
            val root = TreeNode(1)
            print("结果是${solveOne(root)}\n")
        }

        /**
         * 递归法，中遍历
         */
        fun solveOne(root: TreeNode?): Boolean {
            var preNode: TreeNode? = null
            fun IsBST(root: TreeNode?): Boolean {
                // 确定终止, 2个都为空，叶子节点
                if (root == null) {
                    return true
                }
                // 中
                val left = IsBST(root.left)
                if (!left) {
                    return false
                }
                if (preNode != null && preNode!!.`val` >= root.`val`) {
                    return false
                } else {
                    preNode = root
                }
                val right = IsBST(root.right)
                return right
            }
            return IsBST(root)
        }

        /**
         * 迭代法
         * 栈迭代, 每次遍历之前需要先将所有元素放进去stack
         */
        fun solveTwo(root: TreeNode?): Boolean {
            val stack = Stack<TreeNode>()
            var root = root
            var preNode: TreeNode? = null
            while (root != null || !stack.isEmpty()) {
                // 把元素放进去数组
                while (root != null) {
                    stack.push(root)
                    root = root.left
                }
                val node = stack.pop()
                // 大于的话就去除
                if (preNode != null && preNode!!.`val` >= node.`val`) {
                    return false
                }
                preNode = node
                root = node.right
            }
            return true
        }
    }
}