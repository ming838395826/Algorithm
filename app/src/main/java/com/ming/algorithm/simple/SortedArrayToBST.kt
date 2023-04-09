package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.util.Stack


/**
 * @Description  将有序数组转换为二叉搜索树
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class SortedArrayToBST {

    companion object {
        /**
        给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
        高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [-10,-3,0,5,9]
            输出：[0,-3,9,-10,null,5]
            解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
             */
            val root = TreeNode(-1)
            val left1 = TreeNode(0)
            val right1 = TreeNode(3)
            root.left = left1
            root.right = right1
            val left2 = TreeNode(-2)
            val right2 = TreeNode(4)
            left1.left = left2
            left1.right = right2
            val left3 = TreeNode(8)
            left2.left = left3
            print("结果是${solveTwo(intArrayOf(-10, -3, 0, 5, 9))}\n")
        }

        /**
         * 递归法
         */
        fun solveOne(nums: IntArray): TreeNode? {
            fun sortNode(nums: IntArray): TreeNode? {
                // 当为空，返回说明到叶节点 可以插入
                if (nums.isEmpty()) {
                    return null
                }
                if (nums.size == 1) {
                    return TreeNode(nums[0])
                }
                // 将数组平方
                val index = nums.size / 2
                val node = TreeNode(nums[index])
                // 左闭又开
                if (index > 0) {
                    node.left = sortNode(nums.toList().subList(0, index).toIntArray())
                }
                if (index < nums.size - 1) {
                    node.right = sortNode(nums.toList().subList(index + 1, nums.size).toIntArray())
                }
                // 返回节点
                return node
            }
            return sortNode(nums)
        }

        /**
         * 迭代法
         */
        fun solveTwo(nums: IntArray): TreeNode? {
            if (nums.isEmpty()) {
                return null
            }
            val stack = Stack<TreeNode>()
            val leftStack = Stack<Int>()
            val rightStack = Stack<Int>()
            val root = TreeNode(-1)
            stack.push(root)
            leftStack.push(0)
            rightStack.push(nums.size - 1)
            while (!stack.isEmpty()) {
                val node = stack.pop()
                val left = leftStack.pop()
                val right = rightStack.pop()
                val index = (left + right) / 2
                node.`val` = nums[index]
                if (left < index) {
                    val leftNode = TreeNode(-1)
                    leftStack.push(left)
                    rightStack.push(index - 1)
                    node.left = leftNode
                    stack.push(leftNode)
                }
                if (index < right) {
                    val rightNode = TreeNode(-1)
                    leftStack.push(index + 1)
                    rightStack.push(right)
                    node.right = rightNode
                    stack.push(rightNode)
                }
            }
            return root
        }
    }
}