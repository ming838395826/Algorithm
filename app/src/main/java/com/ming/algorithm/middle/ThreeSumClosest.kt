package com.ming.algorithm.middle


class ThreeSumClosest {

    companion object {
        /**
        给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
        返回这三个数的和。
        假定每组输入只存在恰好一个解。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [-1,2,1,-4], target = 1
            输出：2
            解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)
             */
            print("结果是${solveOne(intArrayOf(0,2,1,-3), 1)}\n")
        }

        fun solveOne(nums: IntArray, target: Int): Int {
            nums.sort()
            var result = 0
            if (nums.size < 3)
                return result
            result = nums[0] + nums[1] + nums[2]
            for (k in 0 until nums.size - 2) {
//                //如果首位第一个已经大于 则没必要相加 不一定 因为负数可以加完 中和
//                if (nums[k] - target > result) {
//                    break
//                }
                var i = k + 1
                var j = nums.size - 1
                while (i < j) {
                    val closeSum = nums[k] + nums[i] + nums[j] - target
                    when {
                        closeSum == 0 -> {
                            return nums[k] + nums[i] + nums[j]
                        }
                        closeSum > 0 -> {
                            result = if (Math.abs(closeSum) > Math.abs(result-target)) result else (nums[k] + nums[i] + nums[j])
                            j--
                        }
                        closeSum < 0 -> {
                            result = if (Math.abs(closeSum)  > Math.abs(result-target)) result else (nums[k] + nums[i] + nums[j])
                            i++
                        }
                    }
                }

            }
            return result
        }
    }
}