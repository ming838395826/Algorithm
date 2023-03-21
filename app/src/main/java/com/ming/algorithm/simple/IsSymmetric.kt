package com.ming.algorithm.simple

import android.provider.DocumentsContract.Root
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  对称二叉树
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class IsSymmetric {

    companion object {
        /**
        给你一个二叉树的根节点 root ， 检查它是否轴对称。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [1,2,2,3,4,4,3]
            输出：true
             */
            val root = TreeNode(1)
            val left = TreeNode(2)
            val right = TreeNode(2)
            root.left = left
            root.right = right
            print("结果是${solveOne(root)}\n")
        }

        /**
         * 平层遍历发
         */
        fun solveOne(root: TreeNode?): Boolean {
            val quene = LinkedList<TreeNode>()
            if ((root?.left == null && root?.right != null) || (root?.left != null && root?.right == null)) {
                return false
            }
            quene.offer(root?.left)
            quene.offer(root?.right)
            while (!quene.isEmpty()) {
                var size = quene.size
                while (size > 0) {
                    val left = quene.poll()
                    val right = quene.poll()
                    if (left.`val` != right.`val`) {
                        return false
                    }
                    if ((left.left == null && right.right == null) || (left.left != null && right.right != null)) {
                        if (left.left != null) {
                            quene.offer(left.left)
                            quene.offer(right.right)
                        }
                    } else {
                        return false
                    }
                    if ((left.right == null && right.left == null) || (left.right != null && right.left != null)) {
                        if (left.right != null) {
                            quene.offer(left.right)
                            quene.offer(right.left)
                        }
                    } else {
                        return false
                    }
                    size -= 2
                }

            }
            return true
        }

        /**
         * 递归法
         */
        fun solveTwo(root: TreeNode?): Boolean {
            fun compare(left: TreeNode?, right: TreeNode?): Boolean {
                if (left == null && right == null) {
                    return true
                }
                if (left?.`val` != right?.`val`) {
                    return false
                }
                val wai = compare(left?.left, right?.right)
                val nei =  compare(left?.right, right?.left)
                return wai && nei
            }
            return compare(root?.left, root?.right)
        }

        /**
         * 层次遍历
         */
        fun solveThree(root: TreeNode?): TreeNode? {
            val stack = LinkedList<TreeNode>()
            stack.offer(root ?: return root)
            while (!stack.isEmpty()) {
                var size = stack.size
                while (size > 0) {
                    val node = stack.poll()
                    val temp = node.left
                    node.left = node.right
                    node.right = temp
                    if (node.left != null) {
                        stack.offer(node.left)
                    }
                    if (node.right != null) {
                        stack.offer(node.right)
                    }
                    size--
                }
            }
            return root
        }
    }
}