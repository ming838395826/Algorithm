package com.ming.algorithm.simple

import java.util.*


/**
 * @Description  第一个错误的版本
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class FirstBadVersion {

    companion object {
        /**
        你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，
        你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
        假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
        你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version
        是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 5, bad = 4
            输出：4
            解释：
            调用 isBadVersion(3) -> false
            调用 isBadVersion(5) -> true
            调用 isBadVersion(4) -> true
            所以，4 是第一个错误的版本。
             */
            print("结果是${solveTwo(5)}\n")
        }

        fun isBadVersion(n: Int): Boolean = n >= 4

        /**
         * 二分法
         * 左闭右闭
         * while(left <= right) ,当left==right，区间[left, right]依然有效
         */
        fun solveOne(n: Int): Int {
            var start = 1
            var end = n
            while (start <= end) {
                val middle = start + (end - start) / 2
                // 如果出现坏的版本，那证明在前面
                if (isBadVersion(middle)) {
                    end = middle - 1
                } else {
                    start = middle + 1
                }
            }
            return end + 1
        }

        /**
         * 二分法
         * 左闭右开
         * while(left < right) ,当left == right，区间[left, right]依然无效
         */
        fun solveTwo(n: Int): Int {
            var start = 1L
            var end = n + 1L
            while (start < end) {
                val middle = start + (end - start) / 2
                // 如果出现坏的版本，那证明在前面
                if (isBadVersion(middle.toInt())) {
                    end = middle
                } else {
                    start = middle + 1
                }
            }
            return end.toInt()
        }

        /**
         * 暴力解法(超出时间限制)
         */
        fun solveThree(n: Int): Int {
            // 当遍历到第一个为true 即是一刻开始错误版本
            repeat(n) {
                if (isBadVersion(it + 1)) {
                    return it + 1
                }
            }
            return 1
        }
    }
}