package com.ming.algorithm.bean

import com.ming.algorithm.simple.ListNodePlus.ListNode


/**
 * @Description 设计链表
 * @Author ming
 * @Date 2023/2/10 22:26
 */
class MyLinkedList constructor(
    var size: Int = 0,
    var head: ListNode = ListNode(0)
) {

    fun get(index: Int): Int {
        // 判断是否非法数据
        if (index < 0 || index >= size) {
            return -1
        }
        // 因为已经判断了数值所以下面遍历不用判空
        var currentNode: ListNode? = head
        repeat(index) {
            currentNode = currentNode?.next
        }
        return currentNode?.next?.`val` ?: -1
    }

    fun addAtHead(`val`: Int) {
        addAtIndex(0, `val`)
    }

    fun addAtTail(`val`: Int) {
        addAtIndex(size, `val`)
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index < 0 || index > size) {
            return
        }
        var currentNode: ListNode? = head
        repeat(index) {
            currentNode = currentNode?.next
        }
        val indexNode: ListNode? = currentNode?.next
        val newNode = ListNode(`val`)
        newNode.next = indexNode
        currentNode?.next = newNode
        size++
    }

    fun deleteAtIndex(index: Int) {
        if (index < 0 || index >= size) {
            return
        }
        var currentNode: ListNode? = head
        repeat(index) {
            currentNode = currentNode?.next
        }
        val nextNode = currentNode?.next?.next
        currentNode?.next = nextNode
        size--
    }
}