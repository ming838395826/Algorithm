package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.*


/**
 * @Description  二叉树的最近公共祖先
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class LowestCommonAncestor {

    companion object {
        /**
        给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
        最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
            输出：3
            解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
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
            print("结果是${solveOne(root, left3, right2)?.`val`}\n")
        }

        /**
         * 递归法，后序遍历
         */
        fun solveOne(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            fun findAncestor(node: TreeNode?): TreeNode? {
                // 当为空，返回说明到叶节点 还没相同的元素
                if (node == null) {
                    return null
                }

                // 要是相等 就返回该节点
                if (node.`val` == p!!.`val` || node.`val` == q!!.`val`) {
                    return node
                }
                // 左边
                val left = findAncestor(node.left)
                val right = findAncestor(node.right)
                // 中序
                return if (left != null && right != null) { //2边都不为空，说明找到了
                    node
                } else if (left != null && right == null) { // 一边为空，证明另一边还没找到 返回
                    left
                } else if (left == null && right != null) {// 一边为空，证明另一边还没找到 返回
                    right
                } else { //继续返回
                    null
                }
            }
            return findAncestor(root)
        }
    }
}