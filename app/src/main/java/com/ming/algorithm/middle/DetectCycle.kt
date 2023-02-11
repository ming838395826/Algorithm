package com.ming.algorithm.middle

import com.ming.algorithm.simple.ListNodePlus
import java.lang.StringBuilder

/**
 * @Description 环形链表 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class DetectCycle {

    companion object {
        /**
        给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
        如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
        不允许修改 链表。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            val initListNode = ListNodePlus.ListNode.initListNode(listOf(3, 2, 0, -4))
            initListNode.next?.next?.next?.next = initListNode.next
            print("结果是${solveOne(initListNode)}\n")
        }

        /**
         * 最重要的是 找到相遇点 和 入口 是否循环
         */
        fun solveOne(head: ListNodePlus.ListNode?): ListNodePlus.ListNode? {
            // 定义快指针 走2步 慢指针 走1步 （这样快相对于慢就1步，就肯定相遇 并且在循环里面 肯定慢只走一圈就可以相遇）
            var fastNode = head
            var slowNode = head
            // 不为空，为空 证明不是环
            while (fastNode != null) {
                fastNode = fastNode.next?.next
                slowNode = slowNode?.next
                if (fastNode == slowNode) { //相遇了
                    // 放回开头，根据公司推算出 n为转圈 y代表过圈行多少 z是距离入口的位置
                    // (x + y) * 2 = x + y + n (y + z)
                    // x + y = n (y + z)  //可以回退 但是链表向下遍历更容易，所以取z
                    // x = (n - 1) (y + z) + z
                    slowNode = head
                    while (slowNode != fastNode) {
                        slowNode = slowNode?.next
                        fastNode = fastNode?.next
                    }
                    return  slowNode
                }
            }
            return null
        }
    }
}