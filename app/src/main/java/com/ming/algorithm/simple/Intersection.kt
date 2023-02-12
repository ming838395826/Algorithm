package com.ming.algorithm.simple

import java.lang.StringBuilder

/**
 * @Description 两个数组的交集
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Intersection {

    companion object {
        /**
        给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums1 = [1,2,2,1], nums2 = [2,2]
            输出：[2]
             */
            print("结果是${solveOne(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4))}\n")
        }

        /**
         * 关键用Set 保存相同的 避免一样 过滤
         */
        fun solveOne(nums1: IntArray, nums2: IntArray): IntArray {
            // 第一步先遍历其中一个到set ，第二 拿出num2一样的 判断是否存在 存在放里面
            // 暴力破解需要遍历n的平方
            val sourceSet = mutableSetOf<Int>()
            val resultSet = mutableSetOf<Int>()
            nums1.forEach {
                sourceSet.add(it)
            }
            nums2.forEach {
                if (sourceSet.contains(it)) {
                    resultSet.add(it)
                }
            }
            return resultSet.toIntArray()
        }
    }
}