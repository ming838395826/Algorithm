package com.ming.algorithm.middle

import java.util.*
import kotlin.Comparator
import kotlin.math.max
import kotlin.math.sign


/**
 * @Description 根据身高重建队列
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class ReconstructQueue {

    companion object {
        /**
        假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
        每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
        请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
        其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
            输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
            解释：
            编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
            编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
            编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
            编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
            编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
            编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
            因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
             */
            print("结果是${solveOne(arrayOf(intArrayOf(7,0),intArrayOf(4,4),intArrayOf(7,1)))}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 先按身高倒序，在按排名 一直插入，因为后面数字表示前面有多少位比他大，已经排序了，所以直接插入就好
         */
        fun solveOne(people: Array<IntArray>): Array<IntArray> {
            people.sortWith(object : Comparator<IntArray> {
                override fun compare(o1: IntArray, o2: IntArray): Int {
                    if (o1[0] == o2[0]) return o1[1] - o2[1]
                    return o2[0] - o1[0]
                }
            })
            val result = LinkedList<IntArray>()
            people.forEach {
                result.add(it[1], it)
            }
            return result.toArray(Array(result.size) { IntArray(2)})
        }
    }
}