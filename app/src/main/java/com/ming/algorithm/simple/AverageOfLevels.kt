package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description    二叉树的层平均值
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class AverageOfLevels {

    companion object {
        /**
        给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [3,9,20,null,null,15,7]
            输出：[3.00000,14.50000,11.00000]
            解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
            因此返回 [3, 14.5, 11] 。
             */
            print("结果是${solveOne(TreeNode(1))}\n")
        }

        /**
         * 迭代法
         */
        fun solveOne(root: TreeNode?): DoubleArray {
            val result = mutableListOf<Double>()
            val queue = LinkedList<TreeNode>()
            if (root == null) return result.toDoubleArray() else queue.offer(root)
            while (!queue.isEmpty()) {
                var divide = queue.size
                var size = queue.size
                var sum = 0.0
                while (size > 0) {
                    size--
                    val node = queue.poll()
                    if (node.left != null)
                        queue.offer(node.left)
                    if (node.right != null)
                        queue.offer(node.right)
                    sum += node.`val`
                }
                result.add(sum / divide)
            }
            return result.toDoubleArray()
        }
    }
}