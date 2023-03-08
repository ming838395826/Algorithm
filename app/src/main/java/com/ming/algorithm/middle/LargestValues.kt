package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description   在每个树行中找最大值
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class LargestValues {

    companion object {
        /**
        给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
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
        fun solveOne(root: TreeNode?): List<Int> {
            val result = mutableListOf<Int>()
            val queue = LinkedList<TreeNode>()
            if (root == null) return result else queue.offer(root)
            while (!queue.isEmpty()) {
                var size = queue.size
                var max = Int.MIN_VALUE
                while (size > 0) {
                    val node = queue.poll()
                    max = Math.max(max, node.`val`)
                    if (node.left != null)
                        queue.offer(node.left)
                    if (node.right != null)
                        queue.offer(node.right)
                    size--
                }
                result.add(max)
            }
            return result
        }
    }
}