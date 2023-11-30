package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  相同的树
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class IsSameTree {

    companion object {
        /**
        给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
        如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：p = [1,2,3], q = [1,2,3]
            输出：true
             */
            print("结果是${solveOne(TreeNode(0), TreeNode(0))}\n")
        }

        /**
         * 中序遍历
         */
        fun solveOne(p: TreeNode?, q: TreeNode?): Boolean {
            fun compare(p: TreeNode?, q: TreeNode?): Boolean {
                // 宗旨条件
                if (p == null && q == null) {
                    return true
                }
                if (p?.`val` != q?.`val`) return false
                // 判断左右知否相等
                return compare(p?.left, q?.left) && compare(p?.right, q?.right)
            }
            return compare(p, q)
        }
    }
}