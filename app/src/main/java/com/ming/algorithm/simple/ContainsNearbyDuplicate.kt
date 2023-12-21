package com.ming.algorithm.simple


/**
 * @Description 存在重复元素 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ContainsNearbyDuplicate {

    companion object {
        /**
        给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
        满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [1,2,3,1], k = 3
            输出：true
             */
            print("结果是${solveOne(intArrayOf(), 8)}\n")
        }

        /**
         *
         */
        fun solveOne(nums: IntArray, k: Int): Boolean {
            val record = mutableSetOf<Int>()
            nums.forEachIndexed { index, it ->
                if (record.contains(it)) {
                    return true
                }
                record.add(it)
                if (record.size > k) {
                    record.remove(nums[index-k])
                }
            }
            return false
        }
    }
}