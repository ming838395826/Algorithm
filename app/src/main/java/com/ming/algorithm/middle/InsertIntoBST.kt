package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.*


/**
 * @Description  二叉搜索树中的插入操作
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class InsertIntoBST {

    companion object {
        /**
        给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
        注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [4,2,7,1,3], val = 5
            输出：[4,2,7,1,3,5]
            解释：另一个满足题目要求可以通过的树是：
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
            print("结果是${solveOne(root, 8)}\n")
        }

        /**
         * 递归法
         */
        fun solveOne(root: TreeNode?, `val`: Int): TreeNode? {
            fun insertNode(node: TreeNode?): TreeNode? {
                // 当为空，返回说明到叶节点 可以插入
                if (node == null) {
                    return TreeNode(`val`)
                }
                // 如果大于当前值 就在左子树
                if (node.`val` > `val`) {
                    node.left = insertNode(node.left)
                }
                if (node.`val` < `val`) {
                    node.right = insertNode(node.right)
                }
                // 返回节点
                return node
            }
            return insertNode(root)
        }

        /**
         * 迭代法
         */
        fun solveTwo(root: TreeNode?, `val`: Int): TreeNode? {
            val stack = Stack<TreeNode>()
            stack.push(root ?: return TreeNode(5))
            while (!stack.isEmpty()) {
                val node = stack.pop()
                if (node.`val` > `val`) {
                    if (node.left != null) {
                        stack.push(node.left)
                    } else {
                        node.left = TreeNode(`val`)
                        return root
                    }
                }
                if (node.`val` < `val`) {
                    if (node.right != null) {
                        stack.push(node.right)
                    } else {
                        node.right = TreeNode(`val`)
                        return root
                    }
                }
            }
            return root
        }
    }
}