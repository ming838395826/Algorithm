package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import com.ming.algorithm.simple.ListNodePlus
import java.util.Stack


/**
 * @Description 重排链表
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ReorderList {

    companion object {
        /**
        给定一个单链表 L 的头节点 head ，单链表 L 表示为：
        L0 → L1 → … → Ln - 1 → Ln
        请将其重新排列后变为：
        L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
        不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：head = [1,2,3,4]
            输出：[1,4,2,3]
             */
            val one = ListNodePlus.ListNode(1)
            val two = ListNodePlus.ListNode(2)
            val three = ListNodePlus.ListNode(3)
            val four = ListNodePlus.ListNode(4)
            one.next = two
            two.next = three
            three.next = four
            print("结果是${solveOne(one)}\n")
        }

        /**
         * 1. 分2个列表
         * 2. 第二个列表反转
         * 3. 合并
         */
        fun solveOne(head: ListNodePlus.ListNode?): Unit {
            if (head == null) return
            var first = head
            var second = head
            // 快慢指针
            while (second?.next?.next != null) {
                first = first?.next
                second = second.next?.next
            }
            // 反转
            second = first?.next
            //// 关键 得到第一个数组
            first?.next = null
            var tail = second
            var newHead = second?.next
            tail?.next = null
            while (newHead != null) {
                val temp = newHead.next
                newHead.next = tail
                tail = newHead
                newHead = temp
            }
            second = tail

            // 插入
            //链表节点依次连接
            var result = head
            while (second != null) {
                // 拿出第二组下一个
                val temp = second.next
                // 下一组的next 插入头部第二个
                second.next = result?.next
                // 把下组插入头部中间
                result?.next = second
                result = second.next
                second = temp
            }
        }
    }
}