package com.ming.algorithm.simple

import com.ming.algorithm.simple.ListNodePlus.ListNode

/**
 * Date: 2022/4/2 10:00
 * @Author: ming
 * @Description: 合并两个有序链表
 */
class MergeTwoLists {

    companion object {
        /**
         * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
             * 输入：l1 = [1,2,4], l2 = [1,3,4]
             * 输出：[1,1,2,3,4,4]
             */
            val one = ListNodePlus.initListNode(listOf(1, 2, 4))
            val two = ListNodePlus.initListNode(listOf(1, 3, 4))
            print("结果是${solveThree(one, two).toString()}\n")
        }

        /**
         * 判断新建一个数组，判断首位数哪个比较小 放进去 返回新node
         */
        fun solveOne(list1: ListNode?, list2: ListNode?): ListNode? {
            val result = ListNode(0)
            var list1Node = list1
            var list2Node = list2
            var preNode: ListNode? = result //前一个节点 用来遍历放数组
            while (list1Node != null || list2Node != null) {
                when {
                    list1Node == null -> {
                        preNode?.next = list2Node
                        break
                    }
                    list2Node == null -> {
                        preNode?.next = list1Node
                        break
                    }
                    list1Node.`val` < list2Node.`val` -> {
                        preNode?.next = list1Node
                        list1Node = list1Node.next
                        preNode = preNode?.next
                    }
                    list1Node.`val` >= list2Node.`val` -> {
                        preNode?.next = list2Node
                        list2Node = list2Node.next
                        preNode = preNode?.next
                    }
                }
            }
            return result.next
        }

        /**
         * 跟第一种一样 更优雅的写法
         */
        fun solveTwo(list1: ListNode?, list2: ListNode?): ListNode? {
            val result = ListNode(0)
            var list1Node = list1
            var list2Node = list2
            var preNode: ListNode? = result //前一个节点 用来遍历放数组
            while (list1Node != null && list2Node != null) {
                when {
                    list1Node.`val` < list2Node.`val` -> {
                        preNode?.next = list1Node
                        list1Node = list1Node.next
                    }
                    list1Node.`val` >= list2Node.`val` -> {
                        preNode?.next = list2Node
                        list2Node = list2Node.next
                    }
                }
                preNode = preNode?.next
            }
            preNode?.next = list1Node ?: list2Node
            return result.next
        }

        /**
         * 递归的方法，一直传递进去
         */
        fun solveThree(list1: ListNode?, list2: ListNode?): ListNode? {
            fun mergeLists(list1: ListNode?, list2: ListNode?): ListNode? {
                when {
                    list1 == null -> {
                        return list2
                    }
                    list2 == null -> {
                        return list1
                    }
                    list1.`val` < list2.`val` -> {
                        list1.next = mergeLists(list1.next,list2)
                        return list1
                    }
                    else -> {
                        list2.next = mergeLists(list1,list2.next)
                        return list2
                    }
                }
            }
            return mergeLists(list1,list2)
        }
    }
}