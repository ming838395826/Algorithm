package com.ming.algorithm.simple

import java.lang.StringBuilder
import java.util.*

/**
 * Date: 2022/4/1 9:59
 * @Author: ming
 * @Description: 有效的括号
 */
class IsValid {

    companion object {
        /**
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
        有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "()" 输出：true
             */
            print("结果是${solveTwo("([)]")}\n")
        }

        /**
         * 通过key进行,因为必须是对称 偶数才能ture,通过反转成右边(失败的)
         */
        private fun solveOne(s: String): Boolean {
            var changeMap = hashMapOf("(" to ")", "{" to "}", "[" to "]")
            if (s.isNullOrEmpty() || s.length % 2 != 0) {
                return false
            }
            var reverseLeft = StringBuilder()
            for (index in s.length / 2 - 1 downTo 0) {
                val item = changeMap[s[index].toString()] ?: return false
                reverseLeft.append(item)
            }
            return reverseLeft.toString() == s.substring(s.length / 2, s.length)
        }

        /**
         * 通过堆栈方法
         */
        private fun solveTwo(s: String): Boolean {
            //非偶数的 就不要进去
            if (s.isNullOrEmpty() || s.length % 2 != 0) {
                return false
            }
            val stack = LinkedList<String>()
            var pairMap = hashMapOf(")" to "(", "}" to "{", "]" to "[")
            for (item in s) {
                val itmeS = item.toString()
                //没包含 证明都是左边，放进去堆栈,是右边 进行判断
                if (pairMap.containsKey(itmeS)){
                    if (stack.peek() != pairMap[itmeS])
                        return false
                    stack.pop()
                }else{
                    stack.push(itmeS)
                }
            }
            return stack.isEmpty()
        }
    }
}