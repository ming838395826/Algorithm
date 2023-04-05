package com.ming.algorithm.simple

import android.R.integer
import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.math.max


/**
 * @Description  合并二叉树
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MergeTrees {

    companion object {
        /**
        给你两棵二叉树： root1 和 root2 。
        想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
        返回合并后的二叉树。
        注意: 合并过程必须从两个树的根节点开始。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
            输出：[3,4,5,5,4,null,7]
             */
            val root = TreeNode(1)
            print("结果是${solveOne(root, root)}\n")
        }

        /**
         * 递归法，前序遍历
         */
        fun solveOne(root1: TreeNode?, root2: TreeNode?): TreeNode? {
            fun getTreeNode(root1: TreeNode?, root2: TreeNode?): TreeNode? {
                // 确定终止, 2个都为空，叶子节点
                if (root1 == null && root2 == null) {
                    return null
                }
                val node = TreeNode((root1?.`val` ?: 0) + (root2?.`val` ?: 0))
                // 左边有值
                node.left = getTreeNode(root1?.left, root2?.left)
                // 有区间有值
                node.right = getTreeNode(root1?.right, root2?.right)
                return node
            }
            return getTreeNode(root1, root2)
        }

        /**
         * 递归法，前序遍历
         * 直接用其中一棵树，减少内存，当有节点不一样，也直接返回，减少递归层数
         */
        fun solveTwo(root1: TreeNode?, root2: TreeNode?): TreeNode? {
            fun getTreeNode(root1: TreeNode?, root2: TreeNode?): TreeNode? {
                if (root1 == null)
                    return root2
                if (root2 == null)
                    return root1
                root1.`val` += root2.`val`
                // 左边有值
                root1.left = getTreeNode(root1.left, root2.left)
                // 有区间有值
                root1.right = getTreeNode(root1.right, root2.right)
                return root1
            }
            return getTreeNode(root1, root2)
        }

        /**
         * 迭代法
         * 栈迭代
         */
        fun solveThree(root1: TreeNode?, root2: TreeNode?): TreeNode? {
            if (root1 == null)
                return root2
            if (root2 == null)
                return root1
            val stack = Stack<TreeNode>()
            stack.push(root1)
            stack.push(root2)
            while (!stack.isEmpty()) {
                val node2 = stack.pop()
                val node1 = stack.pop()
                node1.`val` += node2.`val`
                // 如果2边都不为空
                if (node1.left != null && node2.left != null) {
                    stack.push(node1.left)
                    stack.push(node2.left)
                } else {
                    if (node2.left != null) {
                        node1.left = node2.left
                    }
                }
                // 如果2边都不为空
                if (node1.right != null && node2.right != null) {
                    stack.push(node1.right)
                    stack.push(node2.right)
                } else {
                    if (node2.right != null) {
                        node1.right = node2.right
                    }
                }
            }
            return root1
        }
    }
}