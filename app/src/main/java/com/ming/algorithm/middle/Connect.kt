package com.ming.algorithm.middle

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description   填充每个节点的下一个右侧节点指针
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Connect {

    companion object {
        /**
        给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
        初始状态下，所有 next 指针都被设置为 NULL。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [1,2,3,4,5,6,7]
            输出：[1,#,2,3,#,4,5,6,7,#]
            解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
             */
            val root = Node(1)
            root.left = Node(2)
            root.right = Node(3)
            print("结果是${solveOne(root)}\n")
        }

        /**
         * 迭代法
         */
        fun solveOne(root: Node?): Node? {
            val queue = LinkedList<Node>()
            if (root == null) return root else queue.offer(root)
            while (!queue.isEmpty()) {
                var size = queue.size
                var currentNode: Node? = null
                while (size > 0) {
                    val node = queue.poll()
                    if (currentNode == null) {
                        currentNode = node
                    } else {
                        currentNode?.next = node
                        currentNode = node
                    }
                    if (node.left != null)
                        queue.offer(node.left)
                    if (node.right != null)
                        queue.offer(node.right)
                    size--

                }
            }
            return root
        }
    }
}