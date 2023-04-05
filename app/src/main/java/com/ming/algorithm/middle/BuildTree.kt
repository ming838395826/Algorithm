package com.ming.algorithm.middle

import android.R.integer
import com.ming.algorithm.bean.TreeNode
import java.util.*


/**
 * @Description  从中序与后序遍历序列构造二叉树
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class BuildTree {

    companion object {
        /**
        给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
            输出：[[5,4,11,2],[5,8,4,5]]
             */
            val root = TreeNode(1)
            print("结果是${solveOne(root, 23)}\n")
        }

        /**
         * 层次遍历
         * 迭代法
         */
        fun solveOne(root: TreeNode?, targetSum: Int): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            if (root == null) return result

            val stack1 = Stack<TreeNode>()
            val stack2 = Stack<Int>()
            val stack3 = Stack<MutableList<Int>>()
            stack1.push(root)
            stack2.push(targetSum)
            stack3.push(mutableListOf())
            while (!stack1.isEmpty()) {
                val node = stack1.pop()
                val data = stack2.pop()
                val list = stack3.pop()
                list.add(node.`val`)
                if (node.left == null && node.right == null && data == node.`val`) {
                    result.add(list.toList())
                }
                if (node.left != null) {
                    stack1.push(node.left)
                    stack2.push(data - node.`val`)
                    stack3.push(list.toMutableList())
                }
                if (node.right != null) {
                    stack1.push(node.right)
                    stack2.push(data - node.`val`)
                    stack3.push(list.toMutableList())
                }
            }
            return result
        }

        /**
         * 递归法
         */
        fun solveTwo(inorder: IntArray, postorder: IntArray): TreeNode? {
            fun getTreeNode(inorder: IntArray, postorder: IntArray): TreeNode? {
                if (postorder.isEmpty() || inorder.isEmpty())
                    return null
                // 后序得到根节点
                val node = TreeNode(postorder[postorder.size - 1])
                // 得到中序的位置
                val middleIndex = inorder.indexOf(postorder[postorder.size - 1])

                val inorderLeft = inorder.toList().subList(0, middleIndex)
                val inorderRight = inorder.toList().subList(middleIndex + 1, inorder.size)

                // 得到中序的左右数组
                // 得到中序的左右数组, 如果没有左的话，全部都是右边,也有可能没右,

                var postorderLeft = emptyList<Int>()
                var postorderRight = emptyList<Int>()
                if (inorderLeft.isEmpty()) {
                    postorderRight = postorder.toList().subList(0, postorder.size - 1)
                } else if (inorderRight.isEmpty()) {
                    postorderLeft = postorder.toList().subList(0, postorder.size - 1)
                } else {
                    val leftIndex = postorder.indexOf(inorderLeft[inorderLeft.size - 1])
                    postorderLeft = postorder.toList().subList(0, leftIndex + 1)
                    postorderRight = postorder.toList().subList(leftIndex + 1, postorder.size - 1)
                }

                node.left = getTreeNode(inorderLeft.toIntArray(), postorderLeft.toIntArray())
                node.right = getTreeNode(inorderRight.toIntArray(), postorderRight.toIntArray())
                return node
            }
            return getTreeNode(inorder, postorder)
        }
    }
}