package com.ming.algorithm.hard

import com.ming.algorithm.simple.ListNodePlus
import com.ming.algorithm.simple.ListNodePlus.ListNode
import java.util.*

/**
 * @Description  K 个一组翻转链表
 * @Author ming
 * @Date 2022/4/10 20:35
 */
class ReverseKGroup {

    companion object {
        /**
         * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
         * k 是一个正整数，它的值小于或等于链表的长度。
         * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

         * 进阶：
         * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
         * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
             * 输入：head = [1,2,3,4,5], k = 3
             * 输出：[3,2,1,4,5]
             */
            val one = ListNodePlus.initListNode(listOf(1, 2, 3, 4, 5))
            print("结果是${solveThree(one, 3).toString()}\n")
        }

        /***
         * 溯源法，订立2个值，一直向后遍历 得到中间要反转的，然后在调用反转方法进行反转
         */
        fun solveOne(head: ListNode?, k: Int): ListNode? {
            if (k <= 1)
                return head
            /**
             * 对一段区间内进行反转
             * @param tail 下一轮的节点
             */
            fun revertNode(head: ListNode?, tail: ListNode?): ListNode? {
                var preNode: ListNode? = null
                var currentNode = head
                //遍历当前的选择
                while (currentNode != tail) {
                    //先保存当前节点(2)下面的值(3,4,5)
                    val nextNode = currentNode?.next
                    //取出当前的节点，将上一轮保存的值，保存到当前节点的后面(2,1)
                    currentNode?.next = preNode
                    //将当前节点的值 当到上个节点(2,1)
                    preNode = currentNode
                    //改变当前节点(3, 4, 5)
                    currentNode = nextNode
                }
                return preNode
            }

            //新增节点，为了方便遍历
            val dumpNode = ListNode(0)
            dumpNode.next = head
            //初始化2个节点
            var preNode: ListNode? = dumpNode
            var endNode: ListNode? = dumpNode
            while (endNode?.next != null) {
                //遍历k个顺序 如果为空 则位数不够
                repeat(k) {
                    endNode = endNode?.next
                }
                endNode ?: break
                val tail = endNode?.next
                val head = preNode?.next
                //将组内的节点 进行反转
                preNode?.next = revertNode(head, tail)
                //将下一组的尾巴和当前接上,因为第一个已经变为在后面了
                head?.next = tail
                //对排序起始节点重新变成一同起跑线
                endNode = head
                preNode = head
            }
            return dumpNode.next
        }

        /**
         * 递归法,反转方法和上面一样，主要是遍历直接用了递归法
         */
        fun solveTwo(head: ListNode?, k: Int): ListNode? {
            fun revertNode(head: ListNode?, tail: ListNode?): ListNode? {
                var preNode: ListNode? = null
                var currentNode = head
                while (currentNode != tail) {
                    val nextNode = currentNode?.next
                    currentNode?.next = preNode
                    preNode = currentNode
                    currentNode = nextNode
                }
                return preNode
            }

            fun reverseKGroup(node: ListNode?): ListNode? {
                //看看数组长度是否够,够的话返回当前组最后一个节点
                var endNode = node
                repeat(k - 1) {
                    endNode = endNode?.next ?: return node
                }
                //先保存下一组的头部，用户递归
                val nextHead = endNode?.next
                val revertNode = revertNode(node, nextHead)
                node?.next = reverseKGroup(nextHead)
                return revertNode
            }
            return reverseKGroup(head)
        }

        /**
         * 通过堆栈，压栈和退栈，进行反转
         */
        fun solveThree(head: ListNode?, k: Int): ListNode? {
            //新增节点，为了方便遍历
            val dumpNode: ListNode? = ListNode(0)
            var nextNode = dumpNode
            var currenNode = head
            val stack = ArrayDeque<ListNode?>()
            while (true) {
                //遍历k个顺序 如果为空 则位数不够
                repeat(k-1) {
                    //按顺序将东西压入站内
                    currenNode?:return@repeat //为空直接退出，进入下面判断
                    stack.add(currenNode)
                    currenNode = currenNode?.next
                }
                //如果长度不够直接退出
                stack.add(currenNode ?: break)

                val nextHeadNode = currenNode?.next

                while (!stack.isEmpty()){
                    nextNode?.next = stack.pollLast()
                    nextNode = nextNode?.next
                }
                nextNode?.next = nextHeadNode
                currenNode = nextNode?.next
            }
            return dumpNode?.next
        }
    }
}