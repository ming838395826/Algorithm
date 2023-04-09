package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.*


/**
 * @Description  删除二叉搜索树中的节点
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class DeleteNode {

    companion object {
        /**
        给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
        一般来说，删除节点可分为两个步骤：
        首先找到需要删除的节点；
        如果找到了，删除它。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [5,3,6,2,4,null,7], key = 3
            输出：[5,4,6,2,null,null,7]
            解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
            一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
            另一个正确答案是 [5,2,6,null,4,null,7]。
             */
            val root = TreeNode(-1)
            val left1 = TreeNode(0)
            val right1 = TreeNode(3)
            root.left = left1
            root.right = right1
            val left2 = TreeNode(-2)
            val right2 = TreeNode(4)
            left1.left = left2
            left1.right = right2
            val left3 = TreeNode(8)
            left2.left = left3
            print("结果是${solveOne(root, 8)}\n")
        }

        /**
         * 递归法
         */
        fun solveOne(root: TreeNode?, key: Int): TreeNode? {
            fun deleteNode(node: TreeNode?): TreeNode? {
                // 当为空，返回说明到叶节点 可以插入
                if (node == null) {
                    return null
                }
                if (node.`val` == key) {
                    return when {
                        node.left == null && node.right == null -> null
                        node.left != null && node.right == null -> node.left
                        node.left == null && node.right != null -> node.right
                        else -> {
                            val left = node.left
                            // 遍历左边子树
                            var preNode = node.right
                            while (preNode?.left != null) {
                                preNode = preNode.left
                            }
                            preNode?.left = left
                            node.right
                        }
                    }
                }
                // 如果大于当前值 就在左子树
                if (node.`val` > key) {
                    node.left = deleteNode(node.left)
                }
                if (node.`val` < key) {
                    node.right = deleteNode(node.right)
                }
                // 返回节点
                return node
            }
            return deleteNode(root)
        }

        /**
         * 迭代法
         */
        fun solveTwo(root: TreeNode?, key: Int): TreeNode? {
            fun setNode(node: TreeNode?, targetNode: TreeNode?): TreeNode? {
                if (node == null) {
                    return targetNode
                }
                val isLeft = node?.left?.`val` == key
                if (isLeft) {
                    node?.left = targetNode
                } else {
                    node?.right = targetNode
                }
                return root
            }

            val stack = Stack<TreeNode>()
            stack.push(root ?: return null)
            var preNode: TreeNode? = null
            while (!stack.isEmpty()) {
                val node = stack.pop()
                if (node.`val` > key && node.left != null) {
                    stack.push(node.left)
                } else if (node.`val` < key && node.right != null) {
                    stack.push(node.right)
                } else if (node.`val` == key) {
                    // 相等，等于找到了
                    when {
                        node.left == null && node.right == null -> return setNode(preNode, null)
                        node.left != null && node.right == null -> return setNode(
                            preNode,
                            node.left
                        )
                        node.left == null && node.right != null -> return setNode(
                            preNode,
                            node.right
                        )
                        else -> {
                            val left = node.left
                            // 遍历左边子树
                            var childNode = node.right
                            while (childNode?.left != null) {
                                childNode = childNode.left
                            }
                            childNode?.left = left
                            return setNode(preNode, node.right)
                        }
                    }
                }
                preNode = node
            }
            return root
        }
    }
}