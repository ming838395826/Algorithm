package com.ming.algorithm.simple


/**
 * @Description  区域和检索 - 数组不可变
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class SumRange {

    companion object {
        /**
        给定一个整数数组  nums，处理以下类型的多个查询:

        计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
        实现 NumArray 类：

        NumArray(int[] nums) 使用数组 nums 初始化对象
        int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，
        包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：
            ["NumArray", "sumRange", "sumRange", "sumRange"]
            [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
            输出：
            [null, 1, -1, -3]
             */
            print("结果是${solveOne(4,6)}\n")
        }

        /**
         * 博弈论
         */
        fun solveOne(left: Int, right: Int): Int {
            val nums: IntArray = intArrayOf()
            var left = left
            var right = right
            var sum = 0
            while (left <= right) {
                sum += nums[left]
                if (left != right) {
                    sum += nums[right]
                }
            }
            return sum
        }
    }
}