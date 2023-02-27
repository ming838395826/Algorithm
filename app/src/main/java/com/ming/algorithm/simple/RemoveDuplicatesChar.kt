package com.ming.algorithm.simple

import java.util.*

/**
 * @Description 删除字符串中的所有相邻重复项
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class RemoveDuplicatesChar {

    companion object {
        /**
        给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
        在 S 上反复执行重复项删除操作，直到无法继续删除。
        在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入："abbaca"
            输出："ca"
            解释：
            例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
            之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
             */
            print("结果是${solveTwo("abbaca")}\n")
        }

        /**
         * 堆栈法
         */
        fun solveOne(s: String): String {
            var stack = Stack<Char>()
            s.forEach {
                if (!stack.isEmpty() && stack.peek() == it) {
                    stack.pop()
                } else {
                    stack.push(it)
                }
            }
            var result = ""
            while (!stack.isEmpty()) {
                result = stack.pop() + result
            }
            return result
        }

        /**
         * 双指针
         */
        fun solveTwo(s: String): String {
            var slow = 0
            var fast = 0
            val ch = s.toCharArray()
            while (fast < ch.size) {
                // 直接用fast指针覆盖slow指针的值
                ch[slow] = ch[fast]
                // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
                if(slow > 0 && ch[slow] == ch[slow - 1]){
                    slow--
                }else{
                    slow++
                }
                fast++
            }
            return String(ch, 0, slow)
        }
    }
}