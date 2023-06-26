package com.ming.algorithm.middle

import com.ming.algorithm.simple.ListNodePlus
import java.util.*


/**
 * @Description 颜色分类
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class SortColors {

    companion object {
        /**
        给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，
        原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
        我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
        必须在不使用库内置的 sort 函数的情况下解决这个问题。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [2,0,2,1,1,0]
            输出：[0,0,1,1,2,2]
             */
            print("结果是${solveOne(intArrayOf())}\n")
        }

        /**
         * 单指针
         */
        fun solveOne(nums: IntArray): Unit {
            var current = 0
            for (i in 0..1) {
                for (j in current until nums.size) {
                    // 相等，则替换
                    if (nums[j] == i) {
                        val temp = nums[current]
                        nums[current] = nums[j]
                        nums[j] = temp
                        current++
                    }
                }
            }
        }

        /**
         * 双指针
         * 一趟遍历
         */
        fun solveTwo(nums: IntArray): Unit {
            var lastZero = 0
            var lastOne = 0
            nums.forEachIndexed { index, item ->
                when (item) {
                    0 -> {
                        val temp = nums[lastZero]
                        nums[lastZero] = item
                        nums[index] = temp
                        // 证明1已经有排好的了, 这样会把1换到2后面，所以需要操作多一次把1换到1的最后
                        if (lastZero < lastOne) {
                            val temp = nums[lastOne]
                            nums[lastOne] = nums[index]
                            nums[index] = temp
                        }
                        lastZero++
                        lastOne++
                    }
                    1 -> {
                        // 如果等于1，则放到one的后面
                        val temp = nums[lastOne]
                        nums[lastOne] = item
                        nums[index] = temp
                        lastOne++
                    }
                }
            }
        }
    }
}