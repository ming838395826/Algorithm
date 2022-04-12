package com.ming.algorithm.simple

/**
 * @Description 移除元素
 * @Author ming
 * @Date 2022/4/12 11:26
 */
class RemoveElement {

    companion object {
        /**
         * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
         * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
         * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
             * 输入：nums = [3,2,2,3], val = 3
             * 输出：2, nums = [2,2]
             * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
             */
            print("结果是${solveFour(intArrayOf(1), 1)}\n")
        }

        /**
         * 暴力破解法
         */
        fun solveOne(nums: IntArray, `val`: Int): Int {
            val stack = mutableListOf<Int>()
            for (item in nums) {
                if (item != `val`) {
                    stack.add(item)
                }
            }
            for ((index, item) in stack.withIndex()) {
                nums[index] = item
            }
            return stack.size
        }

        /**
         * 直接将元素放到前面
         */
        fun solveTwo(nums: IntArray, `val`: Int): Int {
            var detectCount = 0
            for ((index, item) in nums.withIndex()) {
                if (item == `val`) {
                    detectCount++
                } else {
                    nums[index - detectCount] = item
                }
            }
            return nums.size - detectCount
        }

        /**
         * 方法2的优化
         */
        fun solveThree(nums: IntArray, `val`: Int): Int {
            var count = 0
            for (item in nums) {
                if (item != `val`) {
                    nums[count++] = item
                }
            }
            return count
        }

        /**
         * 双指针用法(右边存放一样的数据)
         */
        fun solveFour(nums: IntArray, `val`: Int): Int {
            var right = nums.size - 1 //存放位置重复的位置
            var left = 0
            fun swap(left: Int, right: Int) {
                val temp = nums[left]
                nums[left] = nums[right]
                nums[right] = temp
            }
            //等于可以为一位数的时候 进入循环
            while (left <= right) {
                //一样交换位置
                if (nums[left] == `val`) {
                    //先交换,自身left也需要减少，需要重新判断该位置的值是不是符合，right减少存放更多的值
                    swap(left--, right--)
                }
                left++
            }
            //不用left是因为可能存在全部一样的数组，所以不要,right自身减少变负数 加1 为0
            return right + 1
        }
    }
}