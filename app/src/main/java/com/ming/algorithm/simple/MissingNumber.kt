package com.ming.algorithm.simple

/**
 * @Description  丢失的数字
 * @Author ming
 * @Date 2022/2/13 14:46
 */
class MissingNumber {

    companion object {
        /**
        给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [3,0,1]
            输出：2
            解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
             */
            print("结果是${solveThree(intArrayOf(0, 1))}\n")
        }

        /**
         * 用set保留
         * 然后在取直
         */
        private fun solveOne(nums: IntArray): Int {
            val record = mutableSetOf<Int>()
            nums.forEach {
                record.add(it)
            }
            for (i in 0..nums.size) {
                if (!record.contains(i))
                    return i
            }
            return -1
        }

        /**
         * 先排序
         */
        private fun solveTwo(nums: IntArray): Int {
            nums.sort()
            nums.forEachIndexed { index, i ->
                if (index != i) {
                    return index
                }
            }
            return nums.size
        }

        /**
         * 总和
         */
        private fun solveThree(nums: IntArray): Int {
            val total =
                (0 + nums.size) * ((nums.size + 1) / 2) + if ((nums.size + 1) % 2 == 0) 0 else (nums.size + 1) / 2
            var real = 0
            nums.forEachIndexed { index, i ->
                real += i
            }
            return total - real
        }

        /**
         * 抑或
         */
        private fun solveFour(nums: IntArray): Int {
            var result = 0
            nums.forEach {
                result = result xor it
            }
            repeat(nums.size + 1) {
                result = result xor it
            }
            return result
        }
    }
}