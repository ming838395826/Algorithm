package com.ming.algorithm.simple

import android.support.v4.app.INotificationSideChannel
import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description   两数之和 IV - 输入二叉搜索树
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FindTarget {

    companion object {
        /**
        给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: root = [5,3,6,2,4,null,7], k = 9
            输出: true
             */
            print("结果是${solveOne(TreeNode(0),9)}\n")
        }

        /**
         * 二查搜索树
         * 后序遍历
         * 递归
         */
        fun solveOne(root: TreeNode?, k: Int): Boolean {
            val record = mutableSetOf<Int>()
            fun findNum(root: TreeNode?): Boolean {
                if (root == null) {
                    return false
                }
                val left = findNum(root.left)
                val right = findNum(root.right)
                if (left || right) {
                    return true
                }
                val target = k - root.`val`
                if (record.contains(target)) {
                    return true
                }
                record.add(root.`val`)
                return false
            }

            return findNum(root)
        }
    }
}