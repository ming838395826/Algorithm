package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description   二叉树的最大深度
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MaxDepth {

    companion object {
        /**
        给定一个二叉树，找出其最大深度。
        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
        说明: 叶子节点是指没有子节点的节点。
        示例：
        给定二叉树 [3,9,20,null,null,15,7]，
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: root = [1,3,2,5,3,null,9]
            输出: [1,3,9]
             */
            print("结果是${solveOne(TreeNode(1))}\n")
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
    }
}