package com.ming.algorithm.simple

/**
 * @Description  回文链表
 * @Author ming
 * @Date 2022/2/13 14:46
 */
class IsPalindromeListNode {

    companion object {
        /**
        给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：head = [1,2,2,1]
            输出：true
             */
            print("结果是${solveOne(ListNodePlus.ListNode(1))}\n")
        }

        /**
         * 1.取到中间
         * 2.反转后部分
         * 3.对比
         */
        private fun solveOne(head: ListNodePlus.ListNode?): Boolean {
            var slow = head
            var fast = head
            // 快慢指针得到中间位置
            while (fast?.next != null && fast.next?.next != null) {
                slow = slow?.next
                fast = fast.next?.next
            }
            // 反转后半部分
            var preNode: ListNodePlus.ListNode? = null
            var curNode = slow?.next
            while (curNode != null) {
                val node = curNode.next
                curNode.next = preNode
                preNode = curNode
                curNode = node
            }
            var before = head
            while (preNode != null && before != null) {
                if (preNode.`val` != before.`val`) return false
                preNode = preNode.next
                before = before.next
            }
            return true
        }

        /**
         * 用数组保存
         * 双指针比较
         */
        private fun solveTwo(head: ListNodePlus.ListNode?): Boolean {
            val data = mutableListOf<Int>()
            var node = head
            while (node != null) {
                data.add(node.`val`)
                node = node.next
            }
            var left = 0
            var right = data.size - 1
            while (left < right) {
                if (data[left++] != data[right--]) {
                    return false
                }
            }
            return true
        }

        /**
         * 回溯递归
         */
        private fun solveThree(head: ListNodePlus.ListNode?): Boolean {
            var headNode = head
            fun isEqual(curNode: ListNodePlus.ListNode?): Boolean {
                // 终止条件
                if (curNode == null) {
                    return true
                }
                // 继续便利，当得到为false ， 那么不满足就一直到上层，无需判断了
                if (!isEqual(curNode.next)) {
                    return false
                }
                // 不相等之间返回false
                if (headNode?.`val` != curNode.`val`) {
                    return false
                }
                // 相等的情况，回溯
                headNode = headNode?.next
                return true
            }
            return isEqual(headNode)
        }
    }
}