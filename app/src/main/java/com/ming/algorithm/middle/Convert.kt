package com.ming.algorithm.middle

import java.lang.StringBuilder

/**
 * @Description Z形变换
 * @Author ming
 * @Date 2021/12/11 23:02
 */
class Convert {

    companion object {
        /**
         * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
        P   A   H   N
        A P L S I I G
        Y   I   R
        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            print("结果是${solveOne("PAYPALISHIRING", 3)}\n")
        }

        /**
         * 暴力解法
         */
        fun solveOne(data: String, numRows: Int): String {
            val result = StringBuilder()
            if(numRows == 1){
                return data
            }
            for (row in 1..numRows) {
                var index = row
                while (index<=data.length){
                    result.append(data[index-1])
                    index += (numRows - row) + (numRows - 2 - row) +1
                }
            }
            return result.toString()
        }
    }
}