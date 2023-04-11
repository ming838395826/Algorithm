package com.ming.algorithm.middle

class LetterCombinations {

    companion object {
        /**
        给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：digits = "23"
            输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
             */
            print("结果是${solveTwo("")}\n")
        }

        fun solveOne(digits: String): List<String> {
            if (digits.isNullOrEmpty()) {
                return emptyList<String>()
            }
            val map = hashMapOf(
                "2" to listOf("a", "b", "c"),
                "3" to listOf("d", "e", "f"),
                "4" to listOf("g", "h", "i"),
                "5" to listOf("j", "k", "l"),
                "6" to listOf("m", "n", "o"),
                "7" to listOf("p", "q", "r", "s"),
                "8" to listOf("t", "u", "v"),
                "9" to listOf("w", "x", "y", "z")
            )

            fun letterCombinations(digits: String, lastList: MutableList<String>): List<String> {

                if (digits.isNullOrEmpty() || digits.substring(0, 1)
                        .isNullOrEmpty() || map[digits.substring(0, 1)].isNullOrEmpty()
                )
                    return lastList.toList()
                val result = mutableListOf<String>()
                val key = digits.substring(0, 1)
                for (digits in lastList) {
                    for (item in map[key]!!) {
                        val dataItem = digits.plus(item).trim()
                        result.add(dataItem)
                    }
                }
                return letterCombinations(digits.substring(1, digits.length), result)
            }
            return letterCombinations(digits, mutableListOf(""))
        }

        fun solveTwo(digits: String): List<String> {
            val map = hashMapOf(
                '2' to listOf('a', 'b', 'c'),
                '3' to listOf('d', 'e', 'f'),
                '4' to listOf('g', 'h', 'i'),
                '5' to listOf('j', 'k', 'l'),
                '6' to listOf('m', 'n', 'o'),
                '7' to listOf('p', 'q', 'r', 's'),
                '8' to listOf('t', 'u', 'v'),
                '9' to listOf('w', 'x', 'y', 'z')
            )
            val result = mutableListOf<String>()

            fun letterCombinations(index: Int, path:MutableList<Char>) {
                // 长度相等，移除
                if (index == digits.length) {
                    result.add(path.joinToString(separator = ""))
                    return
                }
                val list = map[digits[index]]
                list?.let {
                    it.forEach { item ->
                        path.add(item)
                        letterCombinations(index + 1, path)
                        path.removeAt(path.size - 1)
                    }
                }
            }
            if (digits.isNullOrEmpty()) {
                return result
            }
            letterCombinations(0, mutableListOf())
            return result
        }
    }
}