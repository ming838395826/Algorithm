package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.*


/**
 * @Description  二叉搜索树的最小绝对差
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class GetMinimumDifference {

    companion object {
        /**
        给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
        差值是一个正数，其数值等于两值之差的绝对值。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [4,2,6,1,3]
            输出：1
             */
            val root = TreeNode(1)
            print("结果是${solveOne(root)}\n")
        }

        /**
         * 递归法，中遍历
         */
        fun solveOne(root: TreeNode?): Int {
            var preNode: TreeNode? = null
            var result = Int.MAX_VALUE
            fun getMinDiff(root: TreeNode?) {
                if (root == null) {
                    return
                }
                getMinDiff(root.left)
                if (preNode != null) {
                    result = Math.min(result, root.`val` - preNode!!.`val`)
                }
                preNode = root
                getMinDiff(root.right)
            }
            getMinDiff(root)
            return result
        }

        /**
         * 迭代法
         * 栈迭代, 每次遍历之前需要先将所有元素放进去stack
         */
        fun solveTwo(root: TreeNode?): Int {
            val stack = Stack<TreeNode>()
            var root = root
            var result = Int.MAX_VALUE
            var preNode: TreeNode? = null
            while (root != null || !stack.isEmpty()) {
                // 把元素放进去数组
                while (root != null) {
                    stack.push(root)
                    root = root.left
                }
                val node = stack.pop()
                // 大于的话就去除
                if (preNode != null) {
                    result = Math.min(result, node.`val` - preNode!!.`val`)
                }
                preNode = node
                root = node.right
            }
            return result
        }
    }
}