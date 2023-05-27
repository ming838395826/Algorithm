package com.ming.algorithm.middle

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.util.*

/**
 * @Description  单词拆分
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class WordBreak {

    companion object {
        /**
        给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
        注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: s = "leetcode", wordDict = ["leet", "code"]
            输出: true
            解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
             */
            print("结果是${solveOne("leetcode", listOf("leet","code"))}\n")
        }

        /**
         * 动态规划之背包问题
         * 定义： F[n]  为 是否满足匹配的字符串
         * 公式： F[n] = F[n-word[i].lenght] && word[i] == s.subribe[j-i,j]
         *       判断少于的字符串是否符合规则，再判断前面位置是否已经符合 符合就为true
         * 初始化： 目标为0 为 true 没意义，但是如果为false 那公式就没办法递推
         * 顺序： 有顺序拼接字符串，为排列，先遍历物品，完全背包 从小到大遍历
         */
        fun solveOne(s: String, wordDict: List<String>): Boolean {
            val result = BooleanArray(s.length + 1) { false }
            result[0] = true // 为了后面的推断
            for (j in 1..s.length) {
                wordDict.forEachIndexed { i, item ->
                    if (j >= item.length) {
                        result[j] =
                            result[j] || result[j - item.length] && (item == s.substring(j - item.length, j))
                    }
                }
            }
            return result[s.length]
        }
    }
}