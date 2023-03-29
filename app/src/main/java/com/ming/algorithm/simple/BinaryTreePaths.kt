package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.time.OffsetDateTime
import java.util.*

/**
 * @Description   二叉树的所有路径
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class BinaryTreePaths {

    companion object {
        /**
        给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
        叶子节点 是指没有子节点的节点。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [1,2,3,null,5]
            输出：["1->2->5","1->3"]
             */
            val root = TreeNode(1)
            print("结果是${solveOne(root)}\n")
        }

        /**
         * 普通遍历
         * 迭代法
         */
        fun solveOne(root: TreeNode?): Boolean {
            val queue = LinkedList<TreeNode>()
            queue.offer(root ?: return true)
            var maxDepth = 0
            var minDepth = 0
            while (!queue.isEmpty()) {
                maxDepth++
                var size = queue.size
                while (size-- > 0) {
                    val node = queue.poll()
                    if (node.left != null)
                        queue.offer(node.left)
                    if (node.right != null)
                        queue.offer(node.right)
                    if (node.left == null && node.right == null && minDepth == 0) {
                        minDepth = maxDepth
                    }
                }
            }
            return maxDepth - minDepth <= 1
        }

        /**
         * 递归法
         */
        fun solveTwo(root: TreeNode?): List<String> {
            fun getPath(
                node: TreeNode?,
                result: MutableList<String>,
                recordNode: MutableList<TreeNode>
            ) {
                if (node == null)
                    return
                recordNode.add(node)
                //叶子节点
                if (node.left == null && node.right == null) {
                    val path = StringBuilder()
                    recordNode.forEachIndexed{index, item ->
                        path.append(item.`val`)
                        if (index != recordNode.size -1) {
                            path.append("->")
                        }
                    }
                    result.add(path.toString())// 收集一个路径
                    return
                }
                if (node.left != null) {
                    getPath(node.left,result,recordNode)
                    // 当递归返回证明遇到节点，所以要弹出
                    recordNode.removeAt(recordNode.size-1)
                }
                if (node.right != null) {
                    getPath(node.right,result,recordNode)
                    // 当递归返回证明遇到节点，所以要弹出
                    recordNode.removeAt(recordNode.size-1)
                }

            }

            val result = mutableListOf<String>()
            getPath(root, result, mutableListOf())
            return result
        }
    }
}