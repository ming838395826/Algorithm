package com.ming.algorithm.bean

import java.util.Stack

/**
 * @Description 自定义队列
 * @Author ming
 * @Date 2023/2/23 22:07
 */
class MyQueue {

    var stackIn = Stack<Int>()
    var stackOut = Stack<Int>()

    fun push(x: Int) {
        stackIn.push(x)
    }

    fun pop(): Int {
        dumpStackIn()
        return stackOut.pop()
    }

    fun peek(): Int {
        dumpStackIn()
        return stackOut.peek()
    }

    fun empty(): Boolean {
        return stackOut.isEmpty() && stackIn.isEmpty()
    }

    fun dumpStackIn() {
        // 需要先判断出去的退栈是否为空，为空不推进去
        if (!stackOut.isEmpty()) return

        while (!stackIn.isEmpty()) {
            val element = stackIn.pop()
            stackOut.push(element)
        }
    }
}