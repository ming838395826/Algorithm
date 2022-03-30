package com.ming.algorithm.middle

/**
 * @Description 四数之和
 * @Author ming
 * @Date 2022/3/30 22:00
 */
class FourSum {

    companion object {
        /**
        给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

        0 <= a, b, c, d < n
        a、b、c 和 d 互不相同
        nums[a] + nums[b] + nums[c] + nums[d] == target
        你可以按 任意顺序 返回答案 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [1,0,-1,0,-2,2], target = 0
            输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
             */
            print("结果是${solveOne(intArrayOf(0, 0, 0,1000000000, 1000000000, 1000000000,1000000000), 1000000000)}\n")
        }

        fun solveOne(nums: IntArray, target: Int): List<List<Int>> {
            nums.sort()
            val result = mutableListOf<List<Int>>()
            if (nums.size < 4)
                return result
            val numsSize = nums.size
            for (i in 0 until numsSize - 3) {
                //与之前的比较，这样可以避免后面一样的数字 一直加
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue
                }
                //最小4个数 已经大于 直接退出
                if (nums[i].toLong() + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break
                }
                //与最大的数一样还小于，则不满足
                if (nums[i].toLong() + nums[numsSize - 1] + nums[numsSize - 2] + nums[numsSize - 3] < target) {
                    continue
                }
                //取第二个数
                for (j in i + 1 until numsSize - 2) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue
                    }
                    if (nums[i].toLong() + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break
                    }
                    if (nums[i].toLong() + nums[j] + nums[numsSize - 1] + nums[numsSize - 2] < target) {
                        continue
                    }
                    var left = j+1
                    var right = numsSize - 1
                    //双指针
                    while (left < right) {
                        val sum = nums[i] + nums[j] + nums[left] + nums[right]
                        when {
                            sum < target -> {
                                left++
                            }
                            sum > target -> {
                                right--
                            }
                            else -> {
                                result.add(listOf(nums[i], nums[j], nums[left++], nums[right--]))
                                while (left < right && nums[left] == nums[left- 1])
                                    left++
                                while (left < right && nums[right] == nums[right + 1])
                                    right--
                            }
                        }
                    }
                }
            }
            return result
        }
    }
}