package com.ming.algorithm.simple

import com.ming.algorithm.simple.ListNodePlus
import java.util.*


/**
 * @Description  合并两个有序数组
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class Merge {

    companion object {
        /**
        给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
        请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
        注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1
        的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
            输出：[1,2,2,3,5,6]
            解释：需要合并 [1,2,3] 和 [2,5,6] 。
            合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
             */
            print("结果是${solveOne(intArrayOf(1), 1, intArrayOf(), 0)}\n")
        }

        /**
         * 双指针法
         * 题目给的node就是要删除的节点，就是要把自己给删除了,没给head
         */
        fun solveOne(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
            var num1Index = m - 1
            var num2Index = n - 1
            var current = nums1.size - 1
            while (num2Index >= 0) {
                // 比他大，则放进去,或者数组一为0
                if (num1Index < 0 || nums2[num2Index] >= nums1[num1Index]) {
                    nums1[current] = nums2[num2Index]
                    num2Index--
                } else {
                    nums1[current] = nums1[num1Index]
                    num1Index--
                }
                current--
            }
        }
    }
}