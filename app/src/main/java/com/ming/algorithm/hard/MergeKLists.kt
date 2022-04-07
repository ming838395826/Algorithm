package com.ming.algorithm.hard

import com.ming.algorithm.simple.ListNodePlus
import com.ming.algorithm.simple.ListNodePlus.ListNode
import java.util.*

/**
 * Date: 2022/4/7 10:20
 * @Author: ming
 * @Description: 合并K个升序链表
 */
class MergeKLists {

    companion object {
        /**
         * 给你一个链表数组，每个链表都已经按升序排列。
         * 请你将所有链表合并到一个升序链表中，返回合并后的链表
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
             * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
             * 输出：[1,1,2,3,4,4,5,6]
             * 解释：链表数组如下：
             * [
             * 1->4->5,
             * 1->3->4,
             * 2->6
             * ]
            将它们合并到一个有序链表中得到。
            1->1->2->3->4->4->5->6
             */
            val one = ListNodePlus.initListNode(listOf(1, 4, 5))
            val two = ListNodePlus.initListNode(listOf(1, 3, 4))
            val three = ListNodePlus.initListNode(listOf(1, 3, 4))
            print("结果是${solveThree(arrayOf(one, two, three)).toString()}\n")
        }

        /**
         * 先将每2个进行合并，遍历全部进行合并
         */
        fun solveOne(lists: Array<ListNode?>): ListNode? {
            if (lists.isNullOrEmpty())
                return null
            var result: ListNode? = lists[0]
            fun mergeTwoLists(node1: ListNode?, node2: ListNode?): ListNode? {
                val mergeNode = ListNode(0)
                var node1 = node1
                var node2 = node2
                var preNode: ListNode? = mergeNode
                while (node1 != null && node2 != null) {
                    if (node1.`val` < node2.`val`) {
                        //前一个节点下一个点
                        preNode?.next = node1
                        //替换小的下一个节点
                        node1 = node1.next
                    } else {
                        preNode?.next = node2
                        node2 = node2.next
                    }
                    //将当前下一个节点，替换当前节点
                    preNode = preNode?.next
                }
                preNode?.next = node1 ?: node2
                return mergeNode.next
            }
            repeat(lists.size - 1) { index ->
                result = mergeTwoLists(result, lists[index + 1])
            }
            return result
        }

        /**
         * 分治的方法， 思路和第一个一样，只是不在单独遍历，而是 数组两两合并，然后进行分别进行合并 在继续合并
         */
        fun solveTwo(lists: Array<ListNode?>): ListNode? {
            fun mergeTwoLists(node1: ListNode?, node2: ListNode?): ListNode? {
                val mergeNode = ListNode(0)
                var node1 = node1
                var node2 = node2
                var preNode: ListNode? = mergeNode
                while (node1 != null && node2 != null) {
                    if (node1.`val` < node2.`val`) {
                        //前一个节点下一个点
                        preNode?.next = node1
                        //替换小的下一个节点
                        node1 = node1.next
                    } else {
                        preNode?.next = node2
                        node2 = node2.next
                    }
                    //将当前下一个节点，替换当前节点
                    preNode = preNode?.next
                }
                preNode?.next = node1 ?: node2
                return mergeNode.next
            }

            /**
             * 将根据左右 一步步递归 获取最后一个数组
             */
            fun merge(lists: Array<ListNode?>, left: Int, right: Int): ListNode? {
                //相等时候
                if (left == right) {
                    return lists[left]
                }
                if (left > right) {
                    return null
                }
                //获取中间节点
                val middle = (left + right) / 2
                val node1 = merge(lists, left, middle)
                val node2 = merge(lists, middle + 1, right)
                return mergeTwoLists(node1, node2)
            }

            if (lists.isEmpty())
                return null
            //for循环也可以，不雅观，最好用递归
            return merge(lists, 0, lists.size - 1)
        }

        /**
         * 先将每个的值放入一个数组，然后排序(也可以用优先排序数组)，排序后进行拼接成一个新的ListNode，
         */
        fun solveThree(lists: Array<ListNode?>): ListNode? {
            val queue = PriorityQueue<Int>()
            for (item in lists) {
                var item = item
                while (item != null) {
                    queue.offer(item.`val`)
                    item = item.next
                }
            }
            val result = ListNode(0)
            var preNode: ListNode? = result
            while (!queue.isEmpty()) {
                preNode?.next = ListNode(queue.poll())
                preNode = preNode?.next
            }
            return result.next
        }
    }
}