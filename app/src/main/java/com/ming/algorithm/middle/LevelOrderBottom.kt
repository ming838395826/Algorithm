package com.ming.algorithm.middle

import android.os.Build
import androidx.annotation.RequiresApi
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description   二叉树的层序遍历 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class LevelOrderBottom {

    companion object {
        /**
        给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [3,9,20,null,null,15,7]
            输出：[[15,7],[9,20],[3]]
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
                        queue.offer(node.left)
                    if (node.right != null)
                        queue.offer(node.right)
                    size--
                }
                result.add(0,item)
            }
            return result
        }
    }
}