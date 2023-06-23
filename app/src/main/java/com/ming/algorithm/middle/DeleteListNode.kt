package com.ming.algorithm.middle

import com.ming.algorithm.simple.ListNodePlus
import java.util.*


/**
 * @Description 删除链表中的节点
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class DeleteListNode {

    companion object {
        /**
        有一个单链表的 head，我们想删除它其中的一个节点 node。
        给你一个需要删除的节点 node 。你将 无法访问 第一个节点  head。
        链表的所有值都是 唯一的，并且保证给定的节点 node 不是链表中的最后一个节点。
        删除给定的节点。注意，删除节点并不是指从内存中删除它。这里的意思是：
        给定节点的值不应该存在于链表中。
        链表中的节点数应该减少 1。
        node 前面的所有值顺序相同。
        node 后面的所有值顺序相同。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：head = [4,5,1,9], node = 5
            输出：[4,1,9]
            解释：指定链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
             */
            print("结果是${solveOne(ListNodePlus.ListNode(60))}\n")
        }

        /**
         * 双指针法
         * 题目给的node就是要删除的节点，就是要把自己给删除了,没给head
         */
        fun solveOne(node: ListNodePlus.ListNode?) {
            // 因为无法访问 ，且确保不是最后一个，所以无需判断
            // 将下一个节点的值赋值给他
            node?.`val` = node?.next?.`val` ?: 0
            // 在将下一个节点替换到Next,这样下个节点就不存在链表
            node?.next = node?.next?.next
        }
    }
}