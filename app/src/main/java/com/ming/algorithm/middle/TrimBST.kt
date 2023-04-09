package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.*


/**
 * @Description  修剪二叉搜索树
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class TrimBST {

    companion object {
        /**
        给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，
        使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
        所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [1,0,2], low = 1, high = 2
            输出：[1,null,2]
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
            print("结果是${solveOne(root, 8, 1)}\n")
        }

        /**
         * 递归法
         */
        fun solveOne(root: TreeNode?, low: Int, high: Int): TreeNode? {
            fun trimNode(node: TreeNode?): TreeNode? {
                // 当为空，返回说明到叶节点 可以插入
                if (node == null) {
                    return null
                }
                // 如果当前节点不符合的时候
                if (node.`val` < low) {
                    return trimNode(node.right)
                }
                if (node.`val` > high) {
                    return trimNode(node.left)
                }
                // 如果大于当前值 就在左子树
                node.left = trimNode(node.left)
                node.right = trimNode(node.right)
                // 返回节点
                return node
            }
            return trimNode(root)
        }
    }
}