package com.ming.algorithm.simple

/**
 * @Description  只出现一次的数字
 * @Author ming
 * @Date 2022/2/13 14:46
 */
class SingleNumber {

    companion object {
        /**
        给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
        你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [2,2,1]
            输出：1
             */
            print("结果是${solveOne(intArrayOf(0, 1))}\n")
        }

        /**
         * 抑或
         * 利用自身和自身会变0
         * 2个数值，那么都会变0，剩余的就是单个
         */
        private fun solveOne(nums: IntArray): Int {
            var result = 0
            nums.forEach {
                result = result xor it
            }
            return result
        }
    }
}