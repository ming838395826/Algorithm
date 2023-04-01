package com.ming.algorithm.middle

import android.R.integer
import com.ming.algorithm.bean.TreeNode
import java.util.*


/**
 * @Description  路径总和 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class PathSum {

    companion object {
        /**
        给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
        叶子节点 是指没有子节点的节点。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
            输出：[[5,4,11,2],[5,8,4,5]]
             */
            val root = TreeNode(1)
            print("结果是${solveOne(root,23)}\n")
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
        fun solveTwo(root: TreeNode?, targetSum: Int): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            fun getTargetPath(node: TreeNode?, targetSum: Int, path: MutableList<Int>) {
                if (node == null)
                    return
                path.add(node.`val`)
                if (node.left == null && node.right == null && targetSum == node.`val`) {
                    val list = mutableListOf<Int>()
                    path.forEach {
                        list.add(it)
                    }
                    result.add(list)
                    return
                }
                if (node.left != null) {
                    getTargetPath(node.left, targetSum - node.`val`, path)
                    path.removeAt(path.size - 1)
                }
                if (node.right != null) {
                    getTargetPath(node.right, targetSum - node.`val`, path)
                    path.removeAt(path.size - 1)
                }
            }
            getTargetPath(root, targetSum, mutableListOf())
            return result
        }
    }
}