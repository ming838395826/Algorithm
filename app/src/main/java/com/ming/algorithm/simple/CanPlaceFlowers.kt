package com.ming.algorithm.simple

/**
 * @Description   种花问题
 * @Author ming
 * @Date 2022/2/13 14:46
 */
class CanPlaceFlowers {

    companion object {
        /**
        假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
        给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，
        能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：flowerbed = [1,0,0,0,1], n = 1
            输出：true
             */
            print("结果是${solveOne(intArrayOf(0), 0)}\n")
        }

        /**
         * 动态规划
         * f[n] = Math.max(f[n-1], f[n-2]+1) , f[n] 表示该位置最多可以种多少
         * 初始化： f[n] = flower[0] == 1  0 else 1
         * 顺序：从左到右
         */
        private fun solveOne(flowerbed: IntArray, n: Int): Boolean {
            if (n == 0) return true
            if (flowerbed.isEmpty()) return false
            if (flowerbed.size == 1) {
                return if (flowerbed[0] == 0) {
                    n == 1
                } else {
                    false
                }
            }
            val record = IntArray(flowerbed.size)
            // 初始化
            if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                record[0] = 1
                record[1] = 1
            }
            for (i in 2 until flowerbed.size) {
                // 不仅要判断当前的位置，还要判断后面的位置
                if (flowerbed[i] == 0 && (i == flowerbed.size - 1 || flowerbed[i + 1] == 0) && flowerbed[i - 1] != 1) {
                    record[i] = Math.max(record[i - 1], record[i - 2] + 1)
                } else {
                    record[i] = record[i - 1]
                }
            }
            return record[flowerbed.size - 1] >= n
        }
    }
}