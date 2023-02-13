package com.ming.algorithm.simple

import java.lang.StringBuilder

/**
 * @Description 反转字符串
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ReverseString {

    companion object {
        /**
        编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
        不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = ["h","e","l","l","o"]
            输出：["o","l","l","e","h"]
             */
            print("结果是${solveOne(charArrayOf('h', 'e', 'l', 'l', 'o'))}\n")
        }

        /**
         * 双指针法
         */
        fun solveOne(s: CharArray) {
            // 递归
            var left = 0
            var right = s.size - 1
            while (right > left) {
                val temp = s[left]
                s[left++] = s[right]
                s[right--] = temp
            }
        }
    }
}