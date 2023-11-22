package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.lang.StringBuilder
import java.util.*

/**
 * @Description  Excel表列名称
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ConvertToTitle {

    companion object {
        /**
        给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。

        例如：

        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28
        ...
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：columnNumber = 1
            输出："A"
             */
            print("结果是${solveOne(701)}\n")
        }

        /**
         * 26进制
         */
        fun solveOne(columnNumber: Int): String {
            val builder = StringBuilder()
            var last = columnNumber
            while (last != 0) {
                var record = last % 26
                last /= 26
                if (record == 0) {
                    last -= 1
                    record = 26
                }
                builder.insert(0, 'A' + (record - 1))
            }
            return builder.toString()
        }
    }
}