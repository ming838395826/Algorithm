package com.ming.algorithm.simple

/**
 * @Description  回文数
 * @Author ming
 * @Date 2022/2/13 14:46
 */
class IsPalindrome {

    companion object {
        /**
        给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            print("结果是${solveOne(11)}\n")
        }

        private fun solveOne(x: Int): Boolean {
            val data = x.toString()
            var start = 0
            var end = data.length - 1
            while (start < end) {
                if (data[start] != data[end])
                    return false
                start++
                end--
            }
            return true
        }

//        /**
//         * 用整数型 一半的比较
//         */
//        private fun solveTwo(x: Int): Boolean {
//            if (x < 0)
//                return false
//            if (x < 10)
//                return true
//            var reverseNumber = 0
//            var data = x
//            while (data.toString().length > reverseNumber.toString().length) {
//                reverseNumber = reverseNumber * 10 + data % 10
//                data /= 10
//            }
//            return data == reverseNumber || data == reverseNumber / 10
//        }
    }
}