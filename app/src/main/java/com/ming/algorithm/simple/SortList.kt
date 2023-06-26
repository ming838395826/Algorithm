package com.ming.algorithm.simple

import com.ming.algorithm.simple.ListNodePlus
import java.util.*


/**
 * @Description  排序链表
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class SortList {

    companion object {
        /**
        给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：head = [4,2,1,3]
            输出：[1,2,3,4]
             */
            print("结果是${solveOne(ListNodePlus.ListNode(0))}\n")
        }

        /**
         * 归并排序法：在动手之前一直觉得空间复杂度为常量不太可能，因为原来使用归并时，都是 O(N)的，
         * 需要复制出相等的空间来进行赋值归并。对于链表，实际上是可以实现常数空间占用的（链表的归并
         * 排序不需要额外的空间）。利用归并的思想，递归地将当前链表分为两段，然后merge，分两段的方
         * 法是使用 fast-slow 法，用两个指针，一个每次走两步，一个走一步，知道快的走到了末尾，然后
         * 慢的所在位置就是中间位置，这样就分成了两段。merge时，把两段头部节点值比较，用一个 p 指向
         * 较小的，且记录第一个节点，然后 两段的头一步一步向后走，p也一直向后走，总是指向较小节点，
         * 直至其中一个头为NULL，处理剩下的元素。最后返回记录的头即可。
         *
         * 主要考察3个知识点，
         * 知识点1：归并排序的整体思想
         * 知识点2：找到一个链表的中间节点的方法
         * 知识点3：合并两个已排好序的链表为一个新的有序链表
         */
        fun solveOne(head: ListNodePlus.ListNode?): ListNodePlus.ListNode? {
            fun merge(
                left: ListNodePlus.ListNode?,
                right: ListNodePlus.ListNode?
            ): ListNodePlus.ListNode? {
                val node = ListNodePlus.ListNode(0)
                var left = left
                var right = right
                var cur: ListNodePlus.ListNode? = node
                while (left != null && right != null) {
                    if (left.`val` <= right.`val`) {
                        cur?.next = left
                        cur = cur?.next
                        left = left.next
                    } else {
                        cur?.next = right
                        cur = cur?.next
                        right = right.next
                    }
                }
                if (left != null) {
                    cur?.next = left
                }
                if (right != null) {
                    cur?.next = right
                }
                return node.next
            }

            fun sortNode(head: ListNodePlus.ListNode?): ListNodePlus.ListNode? {
                if (head?.next == null) {
                    return head
                }
                var fast = head
                var slow = head
                var pre: ListNodePlus.ListNode? = null
                while (fast?.next != null) {
                    pre = slow
                    fast = fast.next?.next
                    slow = slow?.next
                }
                // 截断
                pre?.next = null
                val left = sortNode(head)
                val right = sortNode(slow)
                return merge(left, right)
            }
            return sortNode(head)
        }
    }
}