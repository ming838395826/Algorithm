package com.ming.algorithm.simple

import android.os.Build
import androidx.annotation.RequiresApi
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  二叉树的前序遍历
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class PreorderTraversal {

    companion object {
        /**
        给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [1,null,2,3]
            输出：[1,2,3]
             */
            print("结果是${solveOne(intArrayOf(1, 1, 1, 2, 2, 3), 2)}\n")
        }

        /**
         * 递归
         */
        fun solveOne(root: TreeNode?): List<Int> {
            // 中左右
            fun traversal(treeNode: TreeNode?, list: MutableList<Int>) {
                if (treeNode == null) {
                    return
                }
                list.add(treeNode.`val`)
                traversal(treeNode.left, list)
                traversal(treeNode.right, list)
            }

            val result = mutableListOf<Int>()
            traversal(root, result)
            return result
        }
    }
}