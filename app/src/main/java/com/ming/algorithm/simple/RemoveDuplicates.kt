package com.ming.algorithm.simple


/**
 * @Description 删除有序数组中的重复项
 * @Author ming
 * @Date 2022/4/12 9:58
 */
class RemoveDuplicates {

    companion object {
        /**
         * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
         * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
         * 将最终结果插入 nums 的前 k 个位置后返回 k 。
         * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
             * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
             * 输出：5, nums = [0,1,2,3,4]
             */
            print("结果是${solveTwo(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4))}\n")
        }

        /**
         * 暴力破解法
         */
        fun solveOne(nums: IntArray): Int {
            val stack = mutableListOf<Int>()
            for (item in nums) {
                if (stack.size == 0 || item > stack[stack.size - 1]) {
                    stack.add(item)
                }
            }
            for ((index, item) in stack.withIndex()) {
                nums[index] = item
            }
            return stack.size
        }

        /**
         * 双指针方法
         */
        fun solveTwo(nums: IntArray): Int {
            if (nums.isEmpty())
                return 0
            var slow = 0//定位当前不重复的项
            var fast = 1//定位当前遍历的项目
            while (fast < nums.size) {
                if (nums[fast] != nums[slow]) {
                    slow++
                    nums[slow] = nums[fast]
                }
                fast++
            }
            return slow + 1
        }
    }
}