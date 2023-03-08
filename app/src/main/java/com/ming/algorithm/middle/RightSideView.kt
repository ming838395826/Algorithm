package com.ming.algorithm.middle

import android.os.Build
import androidx.annotation.RequiresApi
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description   二叉树的右视图
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class RightSideView {

    companion object {
        /**
        给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: [1,2,3,null,5,null,4]
            输出: [1,3,4]
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
                while (size > 0) {
                    size--
                    val node = queue.poll()
                    if (node.left != null)
                        queue.offer(node.left)
                    if (node.right != null)
                        queue.offer(node.right)
                    if (size == 0)
                        result.add(node.`val`)
                }

            }
            return result
        }
    }
}