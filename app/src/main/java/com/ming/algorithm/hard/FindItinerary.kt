package com.ming.algorithm.hard

import java.util.*


/**
 * @Description 重新安排行程
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FindItinerary {

    companion object {
        /**
        给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
        所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
        例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
        假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
            输出：["JFK","MUC","LHR","SFO","SJC"]
             */
            print(
                "结果是${solveOne(mutableListOf(
                    mutableListOf("MUC","LHR"),
                    mutableListOf("JFK","MUC"),
                    mutableListOf("SFO","SJC"),
                    mutableListOf("LHR","SFO")
                ))}\n"
            )
        }

        /**
         * 递归法
         * 按层递归，然后判断是否合法，不合法就跳过
         */
        fun solveOne(tickets: List<List<String>>): List<String> {
            val result = mutableListOf<String>()
            val used = BooleanArray(tickets.size) { false }
            Collections.sort(tickets) { a, b -> a[1].compareTo(b[1]) }
            /**
             * 不用行加列的原因
             * 单用行做参数，因为 一行还有很多的列空
             * 用行和列做参数，又因为不一定最尾的是空格，有可能是展位的地方午发判断到列切换行
             */
            fun findItinerary(path: MutableList<List<String>>): Boolean {
                // 终止条件
                if (path.size == tickets.size) {
                    // 判断序列排列升序,如果如果符合的就直接返回
                    path.forEachIndexed { index, item ->
                        result.add(item[0])
                        if (index == path.size - 1) {
                            result.add(item[1])
                        }
                    }
                    return true
                }
                for (index in tickets.indices) {
                    // 如果已经用过就跳过
                    if (used[index]) {
                        continue
                    }
                    //当首位的时候，只能是“JFK” 开头
                    if (path.isEmpty() && tickets[index][0] != "JFK") {
                        continue
                    }
                    // 当首位不相等跳过
                    if (path.size > 0 && path[path.size - 1][1] != tickets[index][0]) {
                        continue
                    }
                    path.add(tickets[index])
                    used[index] = true
                    // 判断是否找到，找到就推出
                    val result = findItinerary(path)
                    if (result)
                        return true
                    used[index] = false
                    path.removeAt(path.size - 1)
                }
                return false
            }
            findItinerary(mutableListOf())
            return result
        }
    }
}