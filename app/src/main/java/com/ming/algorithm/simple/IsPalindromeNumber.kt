package com.ming.algorithm.simple

/**
 * @Description   验证回文串
 * @Author ming
 * @Date 2022/2/13 14:46
 */
class IsPalindromeNumber {

    companion object {
        /**
        如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
        字母和数字都属于字母数字字符。
        给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: s = "A man, a plan, a canal: Panama"
            输出：true
            解释："amanaplanacanalpanama" 是回文串。
             */
            print("结果是${solveOne("A man, a plan, a canal: Panama")}\n")
        }

        /**
         * 双指针
         * 重点：每次先遍历到是数字才开始比较
         */
        private fun solveOne(s: String): Boolean {
            var left = 0
            var right = s.length - 1
            while (left < right) {
                //去除左边的
                while (left < right && !s[left].isLetterOrDigit()) {
                    left++
                }
                //去除右边
                while (left < right && !s[right].isLetterOrDigit()) {
                    right--
                }
                if (left < right && !s[left].equals(s[right], ignoreCase = true)) {
                    return false
                }
                left++
                right--
            }
            return true
        }
    }
}