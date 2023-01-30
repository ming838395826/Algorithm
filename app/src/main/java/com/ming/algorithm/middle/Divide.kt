package com.ming.algorithm.middle

/**
 * @Description 两数相除
 * @Author ming
 * @Date 2022/4/15 23:43
 */
class Divide {

    companion object {
        /**
        给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
        返回被除数 dividend 除以除数 divisor 得到的商。
        整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: dividend = 10, divisor = 3
            输出: 3
            解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
             */
            print("结果是${solveOne(10, 3)}\n")
        }

        /**
         * 暴力破解法,将用加法
         */
        fun solveOne(dividend: Int, divisor: Int): Int {
            if (dividend === 0) {
                return 0
            }
            if (dividend === Int.MIN_VALUE && divisor === -1) {
                return Int.MAX_VALUE
            }
            val negative = dividend xor divisor < 0 //用异或来计算是否符号相异

            var t = Math.abs(dividend.toLong())
            val d = Math.abs(divisor.toLong())
            var result = 0
            for (i in 31 downTo 0) {
                if (t shr i >= d) { //找出足够大的数2^n*divisor
                    result += 1 shl i //将结果加上2^n
                    t -= d shl i //将被除数减去2^n*divisor
                }
            }
            return if (negative) -result else result //符号相异取反

        }
    }
}