package com.ming.algorithm.bean

import java.util.LinkedList

/**
 * @Description 用队列实现栈
 * @Author ming
 * @Date 2023/2/23 22:46
 */
class MyStack {

    private val queue = LinkedList<Int>()

    fun push(x: Int) {
        queue.push(x)
    }

    fun pop(): Int {
        repeat(queue.size - 1) {
            queue.push(queue.pop())
        }
        return queue.pop()
    }

    fun top(): Int {
        repeat(queue.size - 1) {
            queue.push(queue.pop())
        }
        val data = queue.pop()
        queue.push(data)
        return data
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }

}