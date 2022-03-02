package com.ming.algorithm.middle

/**
 * @Description 三数之和
 * @Author ming
 * @Date 2021/9/28 19:50
 */
class ThreeSum {

    companion object {
        /**
        给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
        注意：答案中不可以包含重复的三元组。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [-1,0,1,2,-1,-4]
            输出：[[-1,-1,2],[-1,0,1]]
             */
            print("结果是${solveOne(intArrayOf(1,-1,-1,0))}\n")
        }

        fun solveOne(nums: IntArray): List<List<Int>> {
            val result = ArrayList<List<Int>>()
            nums.sort()
            //数组小于3 直接排除
            if (nums.size < 3)
                return result
            for (k in 0 until nums.size - 2) {
                //数组一开始数大于0  去除 因为已经排序了
                if (nums[k] > 0)
                    break
                if (k > 0 && nums[k] == nums[k - 1]) continue //nums[k]值重复了，去重 无法判断后面 不如判断前面
                var i = k + 1
                var j = nums.size - 1
                while (i < j) {
                    val sum = nums[k] + nums[i] + nums[j]
                    when {
                        sum < 0 -> while (i < j && nums[i] == nums[++i]) {
                        }
                        sum > 0 -> while (i < j && nums[j] == nums[--j]) {
                        }
                        sum == 0 -> {
                            result.add(listOf(nums[k], nums[i], nums[j]))
                            while (i < j && nums[i] == nums[++i]) {
                            }
                            while (i < j && nums[j] == nums[--j]) {
                            }
                        }
                    }
                }
            }
            return result
        }
    }
}