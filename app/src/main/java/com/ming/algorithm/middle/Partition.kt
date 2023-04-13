package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.Stack


/**
 * @Description 组合总和
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Partition {

    companion object {
        /**
        给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
        回文串 是正着读和反着读都一样的字符串。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "aab"
            输出：[["a","a","b"],["aa","b"]]
             */
            print("结果是${solveOne("efe")}\n")
        }

        /**
         * 递归法
         * 树枝去重
         * 1. 用的是上一层启始的位置。如果一直用全部，会导致有重复存在
         * 2. 通过排序后的数组，大于的话，后面已经可以不遍历了
         */
        fun solveOne(s: String): List<List<String>> {
            val result = mutableListOf<List<String>>()
            // 判断是否回文字符串
            fun judge(data: CharSequence): Boolean {
                var start = 0
                var end = data.length - 1
                while (start < end) {
                    if (data[start] != data[end]) {
                        return false
                    }
                    start++
                    end--
                }
                return true
            }

            fun partition(s: String, startIndex: Int, path: MutableList<String>) {
                // 当数值相等的时候
                if (startIndex == s.length) {
                    result.add(path.toList())
                    return
                }

                for (index in startIndex until s.length) {
                    val item = s.subSequence(startIndex, index + 1)
                    // 不是会问字符串
                    if (!judge(item)) {
                        continue
                    }
                    path.add(item.toString())
                    partition(s, index + 1, path)
                    path.removeAt(path.size - 1)
                }
            }
            partition(s, 0, mutableListOf())
            return result
        }
    }
}