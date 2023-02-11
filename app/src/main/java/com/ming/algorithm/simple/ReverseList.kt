package com.ming.algorithm.simple

import java.lang.StringBuilder

/**
 * @Description 反转链表
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ReverseList {

    companion object {
        /**
        给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：head = [1,2,3,4,5]
            输出：[5,4,3,2,1]
             * **/
            print("结果是${solveTwo(ListNodePlus.ListNode.initListNode(listOf(1, 2, 3, 4, 5)))}\n")
        }

        /**
         * 双指针写法
         */
        fun solveOne(head: ListNodePlus.ListNode?): ListNodePlus.ListNode? {
            var preNode: ListNodePlus.ListNode? = null
            var currentNode: ListNodePlus.ListNode? = head
            while (currentNode != null) {
                var node = currentNode.next
                currentNode.next = preNode
                preNode = currentNode
                currentNode = node
            }
            return preNode
        }

        /**
         * 递归写法
         */
        fun solveTwo(head: ListNodePlus.ListNode?): ListNodePlus.ListNode? {

            fun reverse(
                currentNode: ListNodePlus.ListNode?,
                preNode: ListNodePlus.ListNode?
            ): ListNodePlus.ListNode? {
                currentNode ?: return preNode
                val node = currentNode.next
                currentNode.next = preNode
                return reverse(node, currentNode)
            }
            return reverse(head, null)
        }
    }
}