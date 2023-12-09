package com.ming.algorithm.simple

import com.ming.algorithm.bean.TreeNode
import java.util.*
import kotlin.collections.Map
import kotlin.math.max

/**
 * @Description 2 的幂
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class IsPowerOfTwo {

    companion object {
        /**
        给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
        如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：n = 1
            输出：true
            解释：20 = 1
             */
            print("结果是${solveOne(1)}\n")
        }

        /**
         */
        fun solveOne(n: Int): Boolean {
            var data = n
            if (data <= 0L) return false
            while (data > 0) {
                if (data == 1) {
                    return true
                }
                val divide = data % 2
                if (divide == 1) {
                    return false
                }
                data /= 2
            }
            return true
        }

        /**
         * 若 n=2xn = 2^xn=2
        x
        且 xxx 为自然数（即 nnn 为 222 的幂），则一定满足以下条件：

        恒有 n & (n - 1) == 0，这是因为：
        nnn 二进制最高位为 111，其余所有位为 000；
        n−1n - 1n−1 二进制最高位为 000，其余所有位为 111；
        一定满足 n > 0。
        因此，通过 n > 0 且 n & (n - 1) == 0 即可判定是否满足 n=2xn = 2^xn=2
        x
         */
        fun solveTwo(n: Int): Boolean {
            return n > 0 && n and (n - 1) == 0
        }
    }
}