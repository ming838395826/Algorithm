package com.ming.algorithm.simple

import android.os.Handler
import androidx.core.content.pm.ActivityInfoCompat
import com.ming.algorithm.util.DateUtils
import com.ming.algorithm.util.LogUtils
import java.lang.Exception

/**
 * @Description 两数之和
 * @Author ming
 * @Date 2021/9/24 21:47
 */
class SumOfTwoNumbers {
    companion object {
        /**
         * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现
         */
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = listOf<Int>(2,7,11,15)
            val target = 17
            print("结果是${solveOne(nums,target)}\n")
            print("结果是${solveTwo(nums,target)}\n")
        }

        /**
         * 复杂度
         * 时间O(n^2)
         * 空间O(1)
         */
        private fun solveOne(nums:List<Int>, target: Int):List<Int>{
            LogUtils.printRunTime(true)
            val total=nums.size
            for (one in 0 until total){
                for (two in one+1 until total){
                    if (nums[one]+nums[two]===target){
                        LogUtils.printRunTime(false)
                        return listOf(one,two)
                    }
                }
            }
            throw Exception()
        }

        /**
         * 通过链表方式
         * 通过保存与之相差的 实现遍历一次
         * 复杂度
         * 时间O(n)
         * 空间O(n)
         */
        private fun solveTwo(nums:List<Int>, target: Int):List<Int>{
            LogUtils.printRunTime(true)
            val map=HashMap<Int,Int>()
            for ((index,item) in nums.withIndex()){
                if (map.containsKey(target-item)){
                    LogUtils.printRunTime(false)
                    return listOf(map[target-item]!!,index)
                }else{
                    map[item] = index
                }
            }
            throw Exception()
        }
    }


}