package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.*


/**
 * @Description  二叉搜索树的最近公共祖先
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class LowestCommonAncestorBySearch {

    companion object {
        /**
        给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
        例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
            输出: 6
            解释: 节点 2 和节点 8 的最近公共祖先是 6。
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
         * 递归法
         */
        fun solveOne(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            fun findAncestor(node: TreeNode?): TreeNode? {
                // 当为空，返回说明到叶节点 还没相同的元素
                if (node == null) {
                    return null
                }
                val data = node.`val`
                // 如果大于当前值 就在左子树
                if (data > p!!.`val` && data > q!!.`val`) {
                    return findAncestor(node.left)
                }
                if (data < p!!.`val` && data < q!!.`val`) {
                    return findAncestor(node.right)
                }
                // 在中间 肯定是节点，因为二叉搜索树
                return node
            }
            return findAncestor(root)
        }

        /**
         * 迭代法
         */
        fun solveTwo(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            val stack = Stack<TreeNode>()
            stack.push(root ?: return null)
            while (!stack.isEmpty()) {
                val node = stack.pop()
                if (node.`val` > p!!.`val` && node.`val` > q!!.`val`) {
                    if (node.left != null) {
                        stack.push(node.left)
                    }
                } else if (node.`val` < p!!.`val` && node.`val` < q!!.`val`) {
                    if (node.right != null) {
                        stack.push(node.right)
                    }
                } else {
                    return node
                }
            }
            return null
        }
    }
}