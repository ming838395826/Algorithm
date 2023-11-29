package com.ming.algorithm.simple

import com.ming.algorithm.bean.Node
import com.ming.algorithm.bean.TreeNode
import java.lang.StringBuilder
import java.util.*

/**
 * @Description  多数元素
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class MajorityElement {

    companion object {
        /**
        给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
        你可以假设数组是非空的，并且给定的数组总是存在多数元素。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [3,2,3]
            输出：3
             */
            print("结果是${solveOne(intArrayOf())}\n")
        }

        /**
         * hasMap
         */
        fun solveOne(nums: IntArray): Int {
            val count = nums.size / 2
            val record = mutableMapOf<Int, Int>()
            nums.forEach {
                val time = record[it] ?: 0
                if (time + 1 > count) {
                    return it
                }
                record[it] = time + 1
            }
            return 0
        }

        /**
         * 摩尔投票
         * 推论一： 若记 众数 的票数为 +1+1+1 ，非众数 的票数为 −1-1−1 ，则一定有所有数字的 票数和 >0> 0>0
         * 推论二： 若数组的前 aaa 个数字的 票数和 =0= 0=0 ，则 数组剩余 (n−a)(n-a)(n−a) 个数字的 票数和一定仍 >0>0>0 ，
         * 即后 (n−a)(n-a)(n−a) 个数字的 众数仍为 xxx 。
         */
        fun solveTwo(nums: IntArray): Int {
            var result = 0
            var record = 0
            nums.forEach {
                if (record == 0) {
                    result = it
                    record++
                } else {
                    if (result == it) {
                        record++
                    } else {
                        record--
                    }
                }
            }
            return result
        }
    }
}