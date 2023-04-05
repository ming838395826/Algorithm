package com.ming.algorithm.middle

import android.R.integer
import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.math.max


/**
 * @Description  最大二叉树
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ConstructMaximumBinaryTree {

    companion object {
        /**
        给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
        创建一个根节点，其值为 nums 中的最大值。
        递归地在最大值 左边 的 子数组前缀上 构建左子树。
        递归地在最大值 右边 的 子数组后缀上 构建右子树。
        返回 nums 构建的 最大二叉树 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [3,2,1,6,0,5]
            输出：[6,3,5,null,2,0,null,null,1]
            解释：递归调用如下所示：
            - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
            - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
            - 空数组，无子节点。
            - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
            - 空数组，无子节点。
            - 只有一个元素，所以子节点是一个值为 1 的节点。
            - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
            - 只有一个元素，所以子节点是一个值为 0 的节点。
            - 空数组，无子节点。
             */
            val root = TreeNode(1)
            print("结果是${solveOne(root, 23)}\n")
        }

        /**
         * 递归法，前序遍历
         * （优化法不拷贝数组，直接用数组下标）
         */
        fun solveOne(nums: IntArray): TreeNode? {
            fun getTreeNode(nums: List<Int>): TreeNode? {
                if (nums.size == 1) {
                    return TreeNode(nums[0])
                }
                // 找到最大的值
                var maxIndex = 0
                var maxValue = 0
                nums.forEachIndexed { index, item ->
                    if (maxValue <= item) {
                        maxValue = item
                        maxIndex = index
                    }
                }
                val node = TreeNode(maxValue)
                // 左边有值
                if (maxIndex > 0) {
                    node.left = getTreeNode(nums.subList(0, maxIndex))
                }
                // 有区间有值
                if (maxIndex < nums.size - 1) {
                    node.right = getTreeNode(nums.subList(maxIndex + 1, nums.size))
                }
                return node
            }
            return getTreeNode(nums.toList())
        }
    }
}