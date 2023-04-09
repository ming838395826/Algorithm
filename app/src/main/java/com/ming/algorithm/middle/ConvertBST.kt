package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.Stack


/**
 * @Description  把二叉搜索树转换为累加树
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ConvertBST {

    companion object {
        /**
        给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
        使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
        提醒一下，二叉搜索树满足下列约束条件：
        节点的左子树仅包含键 小于 节点键的节点。
        节点的右子树仅包含键 大于 节点键的节点。
        左右子树也必须是二叉搜索树。
        注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
            输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
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
            print("结果是${solveOne(root)}\n")
        }

        /**
         * 递归法
         */
        fun solveOne(root: TreeNode?): TreeNode? {
            var preVal = 0
            fun convertNode(node: TreeNode?) {
                // 当为空，返回说明到叶节点 可以插入
                if (node == null) {
                    return
                }
                convertNode(node.right)
                node.`val` += preVal
                preVal = node.`val`
                convertNode(node.left)
            }
            convertNode(root)
            return root
        }

        /**
         * 迭代法
         */
        fun solveTwo(root: TreeNode?): TreeNode? {
            val stack = Stack<TreeNode>()
            var preVal = 0
            var currentNode = root
            while (currentNode != null || !stack.isEmpty()) {
                // 将右边的节点遍历
                while (currentNode != null) {
                    stack.push(currentNode)
                    currentNode = currentNode.right
                }
                val node = stack.pop()
                node.`val` += preVal
                preVal = node.`val`
                currentNode = node.left
            }
            return root
        }
    }
}