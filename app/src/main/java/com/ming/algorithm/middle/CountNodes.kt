package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  完全二叉树的节点个数
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class CountNodes {

    companion object {
        /**
        给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
        完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [1,2,3,4,5,6]
            输出：6
             */
            val root = TreeNode(1)
            print("结果是${solveOne(root)}\n")
        }

        /**
         * 普通遍历
         * 迭代法
         */
        fun solveOne(root: TreeNode?): Int {
            val queue = LinkedList<TreeNode>()
            queue.offer(root ?: return 0)
            var result = 0
            while (!queue.isEmpty()) {
                var size = queue.size
                while (size-- > 0) {
                    result++
                    val node = queue.poll()
                    if (node.left != null)
                        queue.offer(node.left)
                    if (node.right != null)
                        queue.offer(node.right)
                }
            }
            return result
        }

        /**
         * 递归法
         * 关键是利用完全二叉树的特性和节点的统计
         */
        fun solveTwo(root: TreeNode?): Int {
            fun getDeepth(node: TreeNode?): Int {
                if (node == null)
                    return 0
                var left = root?.left
                var right = root?.right
                var leftDeepth = 0
                var rightDeepth = 0
                while (left != null) {
                    leftDeepth++
                    left = left.left
                }
                while (right != null) {
                    rightDeepth++
                    right = right.right
                }
                // 判断是否相等
                if (leftDeepth == rightDeepth)
                    return (2 shl leftDeepth) - 1
                // 不相等继续遍历左右树
                var leftCount = getDeepth(node.left)
                var rightCount = getDeepth(node.right)
                return leftCount + rightCount + 1
            }
            return getDeepth(root)
        }
    }
}