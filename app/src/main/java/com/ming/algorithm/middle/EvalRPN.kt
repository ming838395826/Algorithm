package com.ming.algorithm.middle

import java.util.*

/**
 * @Description 逆波兰表达式求值
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class EvalRPN {

    companion object {
        /**
        给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
        请你计算该表达式。返回一个表示表达式值的整数。
        注意：
        有效的算符为 '+'、'-'、'*' 和 '/' 。
        每个操作数（运算对象）都可以是一个整数或者另一个表达式。
        两个整数之间的除法总是 向零截断 。
        表达式中不含除零运算。
        输入是一个根据逆波兰表示法表示的算术表达式。
        答案及所有中间计算结果可以用 32 位 整数表示。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：tokens = ["4","13","5","/","+"]
            输出：9
            解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
             */
            print("结果是${solveOne(arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+"))}\n")
        }

        /**
         * 堆栈法
         */
        fun solveOne(tokens: Array<String>): Int {
            val stack = Stack<Int>()
            tokens.forEach {
                if (it == "+" || it == "-" || it == "/" || it == "*") {
                    var num1 = stack.pop()
                    var num2 = stack.pop()
                    val reuslt = when (it) {
                        "+" -> num2 + num1
                        "-" -> num2 - num1
                        "/" -> num2 / num1
                        "*" -> num2 * num1
                        else -> num2 + num1
                    }
                    stack.push(reuslt)
                } else {
                    stack.push(it.toInt())
                }
            }
            return stack.peek()
        }
    }
}