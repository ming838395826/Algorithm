package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.util.*


/**
 * @Description  二叉搜索树中的众数
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FindMode {

    companion object {
        /**
        给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
        如果树中有不止一个众数，可以按 任意顺序 返回。
        假定 BST 满足如下定义：
        结点左子树中所含节点的值 小于等于 当前节点的值
        结点右子树中所含节点的值 大于等于 当前节点的值
        左子树和右子树都是二叉搜索树
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [1,null,2,2]
            输出：[2]
             */
            val root = TreeNode(1)
            print("结果是${solveOne(root)}\n")
        }

        /**
         * 递归法，中遍历
         */
        fun solveOne(root: TreeNode?): IntArray {
            var preNode: TreeNode? = null
            var result = mutableListOf<Int>()
            var maxCount = 0
            var count = 0
            fun getMode(root: TreeNode?) {
                if (root == null) {
                    return
                }
                // 左边
                getMode(root.left)
                if (preNode == null) {
                    count = 1
                    maxCount = 1
                } else if (preNode!!.`val` == root.`val`) {
                    // 如果相等就要加1
                    count++
                } else {
                    count = 1
                }
                if (maxCount == count) { //相等
                    result.add(root.`val`)
                } else if (maxCount < count) { //大于要清空
                    maxCount = count
                    result.clear()
                    result.add(root.`val`)
                }
                preNode = root
                // 右边
                getMode(root.right)
            }
            getMode(root)
            return result.toIntArray()
        }

        /**
         * 迭代法
         * 栈迭代, 每次遍历之前需要先将所有元素放进去stack
         */
        fun solveTwo(root: TreeNode?): IntArray {
            val stack = Stack<TreeNode>()
            var root = root
            var result = mutableListOf<Int>()
            var maxCount = 0
            var count = 0
            var preNode: TreeNode? = null
            while (root != null || !stack.isEmpty()) {
                // 把元素放进去数组
                while (root != null) {
                    stack.push(root)
                    root = root.left
                }
                val node = stack.pop()
                if (preNode == null) {
                    count = 1
                    maxCount = 1
                } else if (preNode!!.`val` == node.`val`) {
                    count++
                } else {
                    count = 1
                }
                if (maxCount == count) { //相等
                    result.add(node.`val`)
                } else if (maxCount < count) { //大于要清空
                    maxCount = count
                    result.clear()
                    result.add(node.`val`)
                }
                preNode = node
                root = node.right
            }
            return result.toIntArray()
        }
    }
}