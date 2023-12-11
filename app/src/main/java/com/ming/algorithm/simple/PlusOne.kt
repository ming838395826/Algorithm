package com.ming.algorithm.simple

/**
 * @Description  加一
 * @Author ming
 * @Date 2022/2/13 14:46
 */
class PlusOne {

    companion object {
        /**
        给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
        你可以假设除了整数 0 之外，这个整数不会以零开头。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：digits = [1,2,3]
            输出：[1,2,4]
            解释：输入数组表示数字 123。
             */
            print("结果是${solveOne(intArrayOf(0, 1))}\n")
        }

        /**
         * 抑或
         * 利用自身和自身会变0
         * 2个数值，那么都会变0，剩余的就是单个
         */
        private fun solveOne(digits: IntArray): IntArray {
            for (i in digits.size - 1 downTo 0) {
                digits[i]++
                digits[i] = digits[i] % 10
                // 不为0 则表示不需要进位 直接返回
                if (digits[i] != 0) return digits
            }
            // 推出for循环表示需要进位
            val newDigits = IntArray(digits.size + 1)
            newDigits[0] = 1
            newDigits.plus(digits)
            return newDigits
        }
    }
}