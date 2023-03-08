package com.ming.algorithm.simple

import android.os.Build
import androidx.annotation.RequiresApi
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description   二叉树的中序遍历
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class InorderTraversal {

    companion object {
        /**
        给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [1,null,2,3]
            输出：[1,3,2]
             */
            print("结果是${solveOne(TreeNode(1))}\n")
        }

        /**
         * 递归
         */
        fun solveOne(root: TreeNode?): List<Int> {
            // 左中右
            fun traversal(treeNode: TreeNode?, list: MutableList<Int>) {
                if (treeNode == null) {
                    return
                }
                traversal(treeNode.left, list)
                list.add(treeNode.`val`)
                traversal(treeNode.right, list)
            }

            val result = mutableListOf<Int>()
            traversal(root, result)
            return result
        }

        /**
         * 迭代法
         */
        fun solveTwo(root: TreeNode?): List<Int> {
            if (root == null) {
                return emptyList()
            }
            val stack = Stack<TreeNode>()
            val result = mutableListOf<Int>()
            var currentNode = root
            // 如果是空
            while (currentNode != null || !stack.isEmpty()) {
                // 如果不为空 就一直查找左边（右边也会放进堆栈）
                if (currentNode != null) {
                    stack.push(currentNode)
                    currentNode = currentNode.left
                } else {
                    // 拿中
                    val middleNode = stack.pop()
                    result.add(middleNode.`val`)
                    currentNode = middleNode.right
                }
            }
            return result
        }
    }
}