package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.collections.Map
import kotlin.math.max

/**
 * @Description 颠倒二进制位
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ReverseBits {

    companion object {
        /**
        颠倒给定的 32 位无符号整数的二进制位。
        提示：
        请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，
        输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
        在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 00000010100101000001111010011100
            输出：964176192 (00111001011110000010100101000000)
            解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
            因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
             */
            print("结果是${solveOne(1)}\n")
        }

        /**
         * 左右颠倒的意思
         */
        fun solveOne(n: Int): Int {
            var result = 0
            var n = n
            repeat(32) {
                result = (result shl 1) or (n and 1)
                n = n shr 1
            }
            return result
        }

        /**
         * 分冶而治
         * 每次都分一半
         */
        fun solveTwo(n: Int): Int {
            var reuslt = n
            reuslt = reuslt shr 16 or reuslt shl 16
            reuslt = ((reuslt and 0xff00ff00.toInt()) shr 8) or ((reuslt and 0xFF00FF) shl 8)
            reuslt = ((reuslt and 0xf0f0) shr 4) or ((reuslt and 0xf0f0) shl 4)
            reuslt = ((reuslt and 0xcccc) shr 2) or ((reuslt and 0x3333) shl 2)
            reuslt = ((reuslt and 0xaaaa) shr 1) or ((reuslt and 0x5555) shl 1)
            return reuslt
        }
    }
}