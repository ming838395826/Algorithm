package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import com.ming.algorithm.simple.ListNodePlus
import java.util.Stack


/**
 * @Description 同构字符串
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class IsIsomorphic {

    companion object {
        /**
        给定两个字符串 s 和 t ，判断它们是否是同构的。
        如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
        每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "egg", t = "add"
            输出：true
             */
            print("结果是${solveOne("", "")}\n")
        }

        /**
         * 双射
         * 只要包含但是不匹配，就证明这个位置和前面的不一致
         */
        fun solveOne(s: String, t: String): Boolean {
            if (s.length != t.length) return false
            val recordS = mutableMapOf<Char, Char>()
            val recordT = mutableMapOf<Char, Char>()
            for (i in 0 until s.length) {
                val itemS = s[i]
                val itemT = t[i]
                if ((recordS.contains(itemS) && recordS[itemS] != itemT)
                    || (recordT.contains(itemT) && recordT[itemT] != itemS)
                ) {
                    return false
                }
                recordS[itemS] = itemT
                recordT[itemT] = itemS
            }
            return true
        }
    }
}