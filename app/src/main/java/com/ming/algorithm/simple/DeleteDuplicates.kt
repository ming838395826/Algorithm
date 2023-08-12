package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  删除排序链表中的重复元素
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class DeleteDuplicates {

    companion object {
        /**
        给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：head = [1,1,2]
            输出：[1,2]
             */
            print("结果是${solveOne(ListNodePlus.ListNode(0))}\n")
        }

        /**
         * 因为排序 并且范围为-100 到100
         * -100 <= Node.val <= 100
         */
        fun solveOne(head: ListNodePlus.ListNode?): ListNodePlus.ListNode? {
            val headNode = ListNodePlus.ListNode(-101)
            headNode.next = head
            var currentNode: ListNodePlus.ListNode? = headNode
            while (currentNode?.next != null) {
                val nextNode = currentNode.next
                // 不相等直接下一个
                if (nextNode?.`val` != currentNode.`val`) {
                    currentNode = nextNode
                } else {
                    currentNode.next = nextNode.next
                }
            }
            return headNode.next
        }
    }
}