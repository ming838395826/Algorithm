package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.collections.Map
import kotlin.math.max

/**
 * @Description 位1的个数
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class HammingWeight {

    companion object {
        /**
        编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
        提示：
        请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，
        输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
        在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 3 中，输入表示有符号整数 -3。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 00000000000000000000000000001011
            输出：3
            解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
             */
            print("结果是${solveOne(1)}\n")
        }

        /**
         * 左右颠倒的意思
         */
        fun solveOne(n: Int): Int {
            var result = 0
            repeat(32) {
                if (n and (1 shl it) != 0) {
                    result++
                }
            }
            return result
        }
    }
}