package com.ming.algorithm.simple

/**
 * @Description 实现 strStr()
 * @Author ming
 * @Date 2022/4/13 21:24
 */
class StrStr {

    companion object {
        /**
         * 实现 strStr() 函数。
         * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。

         * 说明：
         * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
         * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
             * 输入：haystack = "hello", needle = "ll"
             * 输出：2
             */
            print("结果是${solveTwo("hello", "lo")}\n")
        }

        /**
         * 暴力破解法
         */
        fun solveOne(haystack: String, needle: String): Int {
            if (needle.isNullOrEmpty())
                return 0
            for ((index, item) in haystack.withIndex()) {
                //是否等于开头
                if (item == needle[0]) {
                    var currentIndex = 0
                    while (currentIndex < needle.length && index + currentIndex < haystack.length) {
                        if (needle[currentIndex] != haystack[currentIndex + index]) { //如果不等于就退出
                            break
                        }
                        currentIndex++
                    }
                    if (currentIndex == needle.length) {
                        return index
                    }
                }
            }
            return -1
        }

        /**
         * KMP算法，重点在于next数组，有一篇讲解得很好,https://leetcode-cn.com/problems/implement-strstr/solution/dai-ma-sui-xiang-lu-kmpsuan-fa-xiang-jie-mfbs/
         */
        fun solveTwo(haystack: String, needle: String): Int {
            if (needle.isNullOrEmpty())
                return 0
            val next = arrayOfNulls<Int>(needle.length)
            //初始化为0,表示在当前字符串前一个的最长前缀,整体减少1
            var priSame: Int = -1
            next[0] = priSame
            //生成next数组
            for (index in 1 until needle.length) {
                //取值要大于0，如果不相等则进入循环，进行回溯，找到相等
                while (priSame > -1 && needle[index] != needle[priSame + 1]) {
                    priSame = next[priSame]!! //进行回溯,回溯到相等的时候(因为会匹配 总是递增的)
                }
                //如果2个相等 那么进行加1（因为前面还有条件same>-1）表达要是前面都没相同的了 就停止s
                if (needle[index] == needle[priSame + 1]) {
                    priSame++
                }
                next[index] = priSame
            }
            priSame = -1
            for ((index, item) in haystack.withIndex()) {
                //如果不相等，就进行回溯，到与当前相等的字符串,找到相等的时候，就是对齐的位置，后面index，可以继续匹配长度- j的
                while (priSame > -1 && item != needle[priSame + 1]) {
                    priSame = next[priSame]!!
                }
                //如果相等，指针加1，一起后移
                if (item == needle[priSame + 1]) {
                    priSame++
                }
                //如果指针数量和字符串一样，说明已经匹配到，获取的位置为index-当前指针-1 等于开头的位置
                if (priSame == needle.length - 1)
                    return index - priSame
            }
            return -1
        }


    }
}