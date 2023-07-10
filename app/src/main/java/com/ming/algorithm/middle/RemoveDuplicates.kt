package com.ming.algorithm.middle

import android.print.PrintAttributes.Margins
import java.util.*

/**
 * @Description 删除有序数组中的重复项 II
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class RemoveDuplicates {

    companion object {
        /**
        给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
        不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
        说明：
        为什么返回数值是整数，但输出的答案是数组呢？
        请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
        你可以想象内部操作如下:
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = removeDuplicates(nums);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
        print(nums[i]);
        }
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [1,1,1,2,2,3]
            输出：5, nums = [1,1,2,2,3]
            解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
             */
            print("结果是${solveOne(intArrayOf(1, 1, 1, 2, 2, 2, 3, 3))}\n")
        }

        /**
         * 双指针
         * 定义两个指针 slow\textit{slow}slow 和 fast\textit{fast}fast 分别为慢指针和快指针，
         * 其中慢指针表示处理出的数组的长度，快指针表示已经检查过的数组的长度
         * 1,1,1,2,2,3
         * 1,1,2,2,3
         */
        fun solveOne(nums: IntArray): Int {
            if (nums.size < 3) return nums.size
            var slow = 2
            var fast = 2
            while (fast < nums.size) {
                // 因为slow表示当前可替换的位置，所以判断当前的值，是否为slow前面的值，是的话，则不需要
                if (nums[slow-2] != nums[fast]) {
                    nums[slow] = nums[fast]
                    slow++
                }
                fast++
            }
            return slow
        }
    }
}