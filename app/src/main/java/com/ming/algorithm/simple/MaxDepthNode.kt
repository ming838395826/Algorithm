package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description N 叉树的最大深度
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MaxDepthNode {

    companion object {
        /**
        给定一个 N 叉树，找到其最大深度。
        最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
        N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [1,null,3,2,4,null,5,6]
            输出：3
             */
            val root = Node(1)
            val one = Node(3)
            val two = Node(2)
            val three = Node(4)
            val oneone = Node(5)
            val onetwo = Node(5)
            print("结果是${solveTwo(root)}\n")
        }

        /**
         * 迭代法
         */
        fun solveOne(root: TreeNode?): Int {
            var result = 0
            val queue = LinkedList<TreeNode>()
            if (root == null) return 0 else queue.offer(root)
            while (!queue.isEmpty()) {
                var size = queue.size
                while (size > 0) {
                    val node = queue.poll()
                    if (node.left != null)
                        queue.offer(node.left)
                    if (node.right != null)
                        queue.offer(node.right)
                    size--
                }
                result++
            }
            return result
        }

        /**
         * 递归法
         */
        fun solveTwo(root: Node?): Int {
            fun getMaxDepth(root: Node?, deep: Int): Int {
                if (root == null || root.children.isNullOrEmpty()) {
                    return deep
                }
                var max = 0
                root.children.forEach {
                    val len = getMaxDepth(it, deep + 1)
                    max = Math.max(max, len)
                }
                return max + 1
            }
            return getMaxDepth(root, 0)
        }
    }
}