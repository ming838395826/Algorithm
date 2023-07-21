package com.ming.algorithm.simple

/**
 * @Description  找不同
 * @Author ming
 * @Date 2022/2/13 14:46
 */
class FindTheDifference {

    companion object {
        /**
        给定两个字符串 s 和 t ，它们只包含小写字母。
        字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
        请找出在 t 中被添加的字母。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "abcd", t = "abcde"
            输出："e"
            解释：'e' 是那个被添加的字母。
             */
            print("结果是${solveOne("", "")}\n")
        }

        /**
         * map
         */
        private fun solveOne(s: String, t: String): Char {
            val record = mutableMapOf<Char, Int>()
            s.forEach {
                record[it] = (record[it] ?: 0) + 1
            }
            t.forEach {
                if ((record[it] ?: 0) == 0) {
                    return it
                }
                record[it] = record[it]!! - 1
            }
            return ' '
        }

        /**
         * 抑或
         * 利用自身和自身会变0
         * 2个数值，那么都会变0，剩余的就是单个
         */
        private fun solveTwo(s: String, t: String): Char {
            var result = 0
            s.forEach {
                result = result xor it.toInt()
            }
            t.forEach {
                result = result xor it.toInt()
            }
            return result.toChar()
        }
    }
}