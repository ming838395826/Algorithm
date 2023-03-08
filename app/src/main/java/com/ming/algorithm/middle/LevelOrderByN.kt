package com.ming.algorithm.middle

import android.os.Build
import androidx.annotation.RequiresApi
import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description   N 叉树的层序遍历
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class LevelOrderByN {

    companion object {
        /**
        给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
        树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：root = [1,null,3,2,4,null,5,6]
            输出：[[1],[3,2,4],[5,6]]
             */
            print("结果是${solveOne(Node(1))}\n")
        }

        /**
         * 迭代法
         */
        fun solveOne(root: Node?): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            val queue = LinkedList<Node>()
            if (root == null) return result else queue.offer(root)
            while (!queue.isEmpty()) {
                var size = queue.size
                val item = mutableListOf<Int>()
                while (size > 0) {
                    val node = queue.poll()
                    item.add(node.`val`)
                    repeat(node.children.size ?: 0) {
                        queue.offer(node.children[it])
                    }
                    size--
                }
                result.add(item)
            }
            return result
        }
    }
}