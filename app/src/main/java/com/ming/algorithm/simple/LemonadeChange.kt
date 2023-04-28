package com.ming.algorithm.simple

import java.util.*
import kotlin.math.max
import kotlin.math.sign


/**
 * @Description 柠檬水找零
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class LemonadeChange {

    companion object {
        /**
        在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
        每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
        注意，一开始你手头没有任何零钱。
        给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：bills = [5,5,5,10,20]
            输出：true
            解释：
            前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
            第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
            第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
            由于所有客户都得到了正确的找零，所以我们输出 true。
             */
            print("结果是${solveOne(intArrayOf(5, 5, 5, 10, 20))}\n")
        }

        /**
         * 贪心算法
         * 局部推断全部
         * 优先只能适用一种情况的货币，比如10 因为只能给20 ，最后才使用5
         */
        fun solveOne(bills: IntArray): Boolean {
            // 5 和 10元的 因为20的无用
            var fiveCount = 0
            var tenCount = 0
            bills.forEach {
                when (it) {
                    5 -> fiveCount++
                    10 -> {
                        // 判断5元是否符合
                        if (fiveCount >= 1) {
                            fiveCount--
                            tenCount++
                        } else {
                            return false
                        }
                    }
                    20 -> {
                        // 优先10元
                        if (tenCount >= 1 && fiveCount >= 1) {
                            tenCount--
                            fiveCount--
                        } else if (fiveCount >= 3) {
                            fiveCount -= 3
                        } else {
                            return false
                        }
                    }
                }
            }
            return true
        }
    }
}