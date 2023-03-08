package com.ming.algorithm.middle

import android.os.Build
import androidx.annotation.RequiresApi
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description   二叉树的层序遍历
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class LevelOrder {

    companion object {
        /**
        给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
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
         * 迭代法
         */
        fun solveOne(root: TreeNode?): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            val queue = LinkedList<TreeNode>()
            if (root == null) return result else queue.offer(root)
            while (!queue.isEmpty()) {
                var size = queue.size
                val item = mutableListOf<Int>()
                while (size > 0) {
                    val node = queue.poll()
                    item.add(node.`val`)
                    if (node.left != null)
                        queue.push(node.left)
                    if (node.right != null)
                        queue.push(node.right)
                    size--
                }
                result.add(item)
            }
            return result
        }
    }
}