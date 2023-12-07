package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.math.max

/**
 * @Description Excel 表列序号
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class TitleToNumber {

    companion object {
        /**
        给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
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
            输入: columnTitle = "A"
            输出: 1
             */
            print("结果是${solveOne("FXSHRXW")}\n")
        }

        /**

         */
        fun solveOne(columnTitle: String): Int {
            var reuslt = 0
            for (index in 0 until  columnTitle.length) {
                reuslt = reuslt * 26 + (columnTitle[index] - 'A' + 1)
            }
            return reuslt
        }
    }
}