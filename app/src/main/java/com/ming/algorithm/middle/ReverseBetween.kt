package com.ming.algorithm.middle

import com.ming.algorithm.simple.ListNodePlus

/**
 * @Description  反转链表 II
 * @Author ming
 * @Date 2022/2/13 14:46
 */
class ReverseBetween {

    companion object {
        /**
        给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：head = [1,2,3,4,5], left = 2, right = 4
            输出：[1,4,3,2,5]
             */
            print("结果是${solveOne(ListNodePlus.ListNode(1), 4, 4)}\n")
        }

        /**
         * 1.取到中间
         * 2.反转后部分
         * 3.对比
         */
        private fun solveOne(head: ListNodePlus.ListNode?, left: Int, right: Int): ListNodePlus.ListNode? {
            val dumpNode = ListNodePlus.ListNode(0)
            dumpNode.next = head
            var index = 1
            var curNode: ListNodePlus.ListNode? = head //开始反转的节点
            var headNOde = dumpNode.next //头节点

            // 便利到开始的节点
            while (index < left) {
                headNOde = curNode
                curNode = curNode?.next
                index++
            }
            var preNode: ListNodePlus.ListNode? = null
            val tailNode = curNode //需要反转的尾节点
            // 开始遍历节点
            while (index <= right) {
                val nextNode = curNode?.next
                curNode?.next = preNode
                preNode = curNode
                curNode = nextNode
                index++
            }
            // 反转完成
            headNOde?.next = preNode
            tailNode?.next =curNode
            return dumpNode.next
        }
    }
}