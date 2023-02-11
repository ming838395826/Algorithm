package com.ming.algorithm.simple

import java.lang.StringBuilder

/**
 * @Description 链表相交
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class GetIntersectionNode {

    companion object {
        /**
        给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
        图示两个链表在节点 c1 开始相交：
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
            输出：Intersected at '8'
            解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
            从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
            在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
             * **/
            print(
                "结果是${
                    solveOne(
                        ListNodePlus.ListNode.initListNode(listOf(2,6,4)),
                        ListNodePlus.ListNode.initListNode(listOf(1,5))
                    )
                }\n"
            )
        }

        /**
         * 双指针写法
         */
        fun solveOne(
            headA: ListNodePlus.ListNode,
            headB: ListNodePlus.ListNode
        ): ListNodePlus.ListNode? {
            // 先得出长度
            // 按尾部对齐
            // 因为有结点后后面就一致了 所以要按尾部
            var headA = headA
            var headB = headB

            var lenA = 0
            var currentA: ListNodePlus.ListNode? = headA
            var lenB = 0
            var currentB: ListNodePlus.ListNode? = headB

            while (currentA != null) {
                currentA = currentA.next
                lenA++
            }
            while (currentB != null) {
                currentB = currentB.next
                lenB++
            }
            // 为了一致避免判断 按A为长为准
            if (lenB > lenA) {
                val tempLength = lenA
                lenA = lenB
                lenB = tempLength
                val tempNode = headA
                headA = headB
                headB = tempNode
            }
            val diffLen = lenA - lenB
            currentA = headA
            currentB = headB
            repeat(diffLen) {
                currentA = currentA?.next
            }
            repeat(lenB) {
                if (currentA?.`val` == currentB?.`val`) {
                    return currentA
                }
                currentA = currentA?.next
                currentB = currentB?.next
            }
            return null
        }
    }
}