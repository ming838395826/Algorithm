package com.ming.algorithm.middle

import android.util.ArraySet

/**
 * @Description 括号生成
 * @Author ming
 * @Date 2022/4/6 21:50
 */
class GenerateParenthesis {

    companion object {
        /**
        数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 3
            输出：["((()))","(()())","(())()","()(())","()()()"]
             */
            print("结果是${solveTwo(3)}\n")
        }

        /**
         * 插入法 利用()的特性 对每个字符之间进行插入()一对括号 通过set去重
         */
        fun solveOne(n: Int): List<String> {
            var result = setOf("()")
            repeat(n - 1) { index ->
                var set = HashSet<String>()
                for (item in result) {
                    repeat(item.length) {
                        set.add(item.slice(0 until it) + "()" + item.slice(it until item.length))
                    }
                }
                result = set
            }
            return result.toList()
        }

        /**
         * 回溯算法，（递归）
         * 用 DFS 遍历这棵树，找出所有的解，这个过程叫回溯。
         * 利用约束做“剪枝” ,如果左括号大于右括号 就是非法。比如先加右括号的话 那right-1 就小于left,他们的取值区间在0 unit n之间
         */
        fun solveTwo(n: Int): List<String> {
            var result = mutableListOf<String>()
            fun generateParenthesis(left: Int, right: Int, item: String) {
                when {
                    left > right || left < 0 || right < 0 -> return
                    left == 0 && right == 0 -> {
                        result.add(item)
                        return
                    }
                    else -> {
                        generateParenthesis(left - 1, right, item.plus("("))
                        generateParenthesis(left, right - 1, item.plus(")"))
                    }
                }
            }
            generateParenthesis(n, n, "")
            return result
        }
    }
}