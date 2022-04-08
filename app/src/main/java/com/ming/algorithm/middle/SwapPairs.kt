package com.ming.algorithm.middle

import com.ming.algorithm.simple.ListNodePlus
import com.ming.algorithm.simple.ListNodePlus.ListNode

/**
 * Date: 2022/4/8 9:52
 * @Author: ming
 * @Description: 两两交换链表中的节点
 */
class SwapPairs {

    companion object {
        /**
         * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
         * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
             * 输入：head = [1,2,3,4]
             * 输出：[2,1,4,3]
             */
            val one = ListNodePlus.initListNode(listOf(1, 2, 3, 4, 5))
            print("结果是${solveThree(one).toString()}\n")
        }

        /**
         * 采用递归的方式，进行
         */
        fun solveOne(head: ListNode?): ListNode? {
            fun swap(currentNode: ListNode?): ListNode? {
                //为空返回
                var node2 = currentNode?.next ?: return currentNode
                currentNode.next = swap(node2.next)  //递归替换后面的节点
                node2.next = currentNode
                return node2
            }
            return swap(head)
        }

        /**
         * 将数据放到数组，在重新链接成节点
         */
        fun solveTwo(head: ListNode?): ListNode? {
            val result = ListNode(0)
            val list = mutableListOf<Int>()
            fun swap(currentStep: Int) {
                if (currentStep + 2 > list.size) return
                list[currentStep] = list.set(currentStep + 1, list[currentStep])
                swap(currentStep + 2)
            }

            var node = head
            while (node != null) {
                list.add(node.`val`)
                node = node.next
            }
            swap(0)
            node = result
            repeat(list.size) {
                node?.next = ListNode(list[it])
                node = node?.next
            }
            return result.next
        }

        /**
         * 迭代法
         */
        fun solveThree(head: ListNode?): ListNode? {
            val result = ListNode(0)
            result.next = head
            var currentNode: ListNode?= result
            while (currentNode?.next?.next != null) {
                val node1 = currentNode.next
                val node2 = currentNode.next?.next
                //给第一个节点后面
                node1?.next = node2?.next
                node2?.next = node1
                //要将当前数组 赋值给上一个节点，不然会缺失数据
                currentNode.next = node2
                currentNode = node2?.next
            }
            return result.next
        }
    }
}