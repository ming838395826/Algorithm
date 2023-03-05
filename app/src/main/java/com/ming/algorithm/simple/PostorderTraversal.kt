package com.ming.algorithm.simple

import android.os.Build
import androidx.annotation.RequiresApi
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description   二叉树的后序遍历
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class PostorderTraversal {

    companion object {
        /**
        给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [1,null,2,3]
            输出：[3,2,1]
             */
            print("结果是${solveOne(TreeNode(1))}\n")
        }

        /**
         * 递归
         */
        fun solveOne(root: TreeNode?): List<Int> {
            // 左右中
            fun traversal(treeNode: TreeNode?, list: MutableList<Int>) {
                if (treeNode == null) {
                    return
                }
                traversal(treeNode.left, list)
                traversal(treeNode.right, list)
                list.add(treeNode.`val`)
            }

            val result = mutableListOf<Int>()
            traversal(root, result)
            return result
        }
    }
}