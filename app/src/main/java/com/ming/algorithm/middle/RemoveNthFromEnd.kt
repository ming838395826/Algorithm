package com.ming.algorithm.middle

import com.ming.algorithm.simple.ListNodePlus.ListNode
import java.util.*

/**
 * @Description 删除链表的倒数第 N 个结点
 * @Author ming
 * @Date 2022/3/31 21:27
 */
class RemoveNthFromEnd {

    companion object {
        /**
        给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：head = [1,2,3,4,5], n = 2
            输出：[1,2,3,5]
             */
            print("结果是${solveThree(ListNode.initListNode(listOf(1, 2, 3, 4, 5)), 2)}\n")
        }

        /**
         * 遍历2次的方法
         */
        fun solveOne(head: ListNode?, n: Int): ListNode? {
//            //为了避免相同数组，可以一开始先默认加入空
            val result: ListNode? = ListNode(0)
            result?.next = head
            var length = 0
            var node = head
            while (node != null) {
                length++
                node = node.next
            }
            var selectNode = result
            var beforeNode: ListNode? = result
            repeat(length - n + 1) {
                beforeNode = selectNode
                selectNode = selectNode?.next
            }
            beforeNode?.next = selectNode?.next
            return result?.next
        }

        /**
         * 栈的方式
         */
        fun solveTwo(head: ListNode?, n: Int): ListNode? {
            val result: ListNode? = ListNode(0)
            result?.next = head
            val stack = LinkedList<ListNode>()
            var selectNode = result
            while (selectNode != null) {
                //放进去
                stack.push(selectNode)
                selectNode = selectNode?.next
            }
            //弹出的正好是前一个
            repeat(n){
                //弹出堆栈
                stack.pop()
            }
            val preNode = stack.peek()
            preNode.next = preNode.next?.next
            return result?.next
        }

        /**
         * 快慢指针
         */
        fun solveThree(head: ListNode?, n: Int): ListNode? {
            val result: ListNode? = ListNode(0)
            result?.next = head
            var fast = head
            var slow = result
            repeat(n){
                fast = fast?.next
            }
            while (fast != null){
                slow = slow?.next
                fast = fast?.next
            }
            //遍历结束 证明是到尾部,此时慢指针指向的是删除节点的前一个（必须是前一个，才能获取到下结点和下下节点）
            slow?.next = slow?.next?.next
            return result?.next
        }
    }
}