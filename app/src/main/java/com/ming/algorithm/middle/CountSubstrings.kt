package com.ming.algorithm.middle

import java.util.*


/**
 * @Description  回文子串
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class CountSubstrings {

    companion object {
        /**
        给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
        回文字符串 是正着读和倒过来读一样的字符串。
        子字符串 是字符串中的由连续字符组成的一个序列。
        具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "abc"
            输出：3
            解释：三个回文子串: "a", "b", "c"
             */
            print("结果是${solveOne("abc")}\n")
        }

        /**
         * 动态规范
         * 删除元素，最长序列
         * 定义： 布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false
         * 公式： 整体上是两种，就是s[i]与s[j]相等，s[i]与s[j]不相等这两种。
         *       当s[i]与s[j]不相等，那没啥好说的了，dp[i][j]一定是false。
         *       当s[i]与s[j]相等时，这就复杂一些了，有如下三种情况
         *      情况一：下标i 与 j相同，同一个字符例如a，当然是回文子串
         *      情况二：下标i 与 j相差为1，例如aa，也是回文子串
         *      情况三：下标：i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，
         *      我们看i到j区间是不是回文子串就看aba是不是回文就可以了，
         *      那么aba的区间就是 i+1 与 j-1区间，这个区间是不是回文就看dp[i + 1][j - 1]是否为true。
         *      if (s[i] == s[j]) {
        if (j - i <= 1) { // 情况一 和 情况二
        result++;
        dp[i][j] = true;
        } else if (dp[i + 1][j - 1]) { // 情况三
        result++;
        dp[i][j] = true;
        }
        }
         * 初始化： dp[i][j]可以初始化为true么
         * 方向：从前到后，从下到上
         */
        fun solveOne(s: String): Int {
            var max = 0
            val result = Array(s.length) { BooleanArray(s.length) }
            for (i in s.length - 1 downTo 0) {
                for (j in i until s.length) {
                    // 不相等的话，肯定不是无需判断，默认为fasle
                    if (s[i] == s[j]) {
                        // 同个元素 肯定是回文
                        if (i == j) {
                            result[i][j] = true
                        } else if (j - i == 1) {
                            // 2个字母也是
                            result[i][j] = true
                        } else { // 看中间的是否是
                            result[i][j] = result[i+1][j-1]
                        }
                    }
                    if (result[i][j])
                        max++
                }
            }
            return max
        }
    }
}