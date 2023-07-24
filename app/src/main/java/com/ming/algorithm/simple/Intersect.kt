package com.ming.algorithm.simple

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * @Description 两个数组的交集 II
 * @Author ming
 * @Date 2022/2/13 14:46
 */
class Intersect {

    companion object {
        /**
        给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
        返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
         */
        @RequiresApi(Build.VERSION_CODES.N)
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums1 = [1,2,2,1], nums2 = [2,2]
            输出：[2,2]
             */
            print("结果是${solveOne(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))}\n")
        }

        /**
         * 取出相同的数字
         */
        @RequiresApi(Build.VERSION_CODES.N)
        private fun solveOne(nums1: IntArray, nums2: IntArray): IntArray {
            val num1Record = mutableMapOf<Int, Int>()
            val num2Record = mutableMapOf<Int, Int>()
            val result = mutableListOf<Int>()
            nums1.forEach {
                num1Record[it] = (num1Record[it] ?: 0) + 1
            }
            nums2.forEach {
                if (num1Record.containsKey(it)) {
                    num2Record[it] = (num2Record[it] ?: 0) + 1
                }
            }
            num2Record.forEach { key, value ->
                val size = Math.min(value, num1Record[key] ?: 0)
                repeat(size) {
                    result.add(key)
                }
            }
            return result.toIntArray()
        }

        /**
         * 双指针
         */
        private fun solveTwo(nums1: IntArray, nums2: IntArray): IntArray {
            nums1.sort()
            nums2.sort()
            val result = mutableListOf<Int>()
            var num1Index = 0
            var nums2Index = 0
            while (num1Index < nums1.size && nums2Index < nums2.size) {
                val data1 = nums1[num1Index]
                val data2 = nums2[nums2Index]
                if (data1 < data2) {
                    num1Index++
                } else if (data1 > data2) {
                    nums2Index++
                } else {
                    // 相等
                    num1Index++
                    nums2Index++
                    result.add(data1)
                }
            }
            return result.toIntArray()
        }
    }
}