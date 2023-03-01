package com.ming.algorithm.middle

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

/**
 * @Description 前 K 个高频元素
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class TopKFrequent {

    companion object {
        /**
        给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入: nums = [1,1,1,2,2,3], k = 2
            输出: [1,2]
             */
            print("结果是${solveOne(intArrayOf(1, 1, 1, 2, 2, 3), 2)}\n")
        }

        /**
         * 大顶堆
         */
        fun solveOne(nums: IntArray, k: Int): IntArray {
            val map = mutableMapOf<Int, Int>()
            nums.forEach {
                map[it] = (map[it] ?: 0) + 1
            }
            val queue =
                PriorityQueue<Pair<Int, Int>> { pair1, pair2 -> pair2.second - pair1.second }
            map.forEach {
                queue.add(Pair(it.key, it.value))
            }
            val result = IntArray(k)
            repeat(k) {
                result[it] = queue.poll().first
            }
            return result
        }

        /**
         * 小顶堆
         */
        fun solveTwo(nums: IntArray, k: Int): IntArray {
            val map = mutableMapOf<Int, Int>()
            nums.forEach {
                map[it] = (map[it] ?: 0) + 1
            }
            val queue =
                PriorityQueue<Pair<Int, Int>> { pair1, pair2 -> pair1.second - pair2.second }
            map.forEach {
                queue.add(Pair(it.key, it.value))
                // 超出了数量
                if (queue.size > k) {
                    queue.poll()
                }
            }
            val result = IntArray(k)
            repeat(k) {
                result[it] = queue.poll().first
            }
            return result
        }
    }
}