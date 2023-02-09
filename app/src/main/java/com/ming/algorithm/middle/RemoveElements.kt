package com.ming.algorithm.middle

import com.ming.algorithm.simple.ListNodePlus
import kotlin.math.min

/**
 * @Description 移除链表元素
 * @Author ming
 * @Date 2022/4/15 23:43
 */
class RemoveElements {

    companion object {
        /**
        给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：head = [1,2,6,3,4,5,6], val = 6
            输出：[1,2,3,4,5]
             */
            print("结果是${solveOne(ListNodePlus.ListNode.initListNode(arrayListOf(6,6,6,6,6)), 6)}\n")
        }

        /**
         * 滑动窗口法
         */
        fun solveOne(head: ListNodePlus.ListNode?, `val`: Int): ListNodePlus.ListNode? {
            val dumpNode = ListNodePlus.ListNode(0)
            dumpNode.next = head
            var currentNode: ListNodePlus.ListNode? = dumpNode
            while (currentNode?.next != null) {
                if (currentNode.next?.`val` == `val`) {
                    currentNode.next = currentNode.next?.next
                } else {
                    currentNode = currentNode.next
                }
            }
            return dumpNode.next
        }
    }
}