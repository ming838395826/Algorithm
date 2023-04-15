package com.ming.algorithm.middle

import com.ming.algorithm.bean.TreeNode
import java.util.Stack


/**
 * @Description 复原 IP 地址
 * @Author ming
 * @Date 2022/2/10 23:20
 */
class RestoreIpAddresses {

    companion object {
        /**
        有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
        例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
        给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
        你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：s = "25525511135"
            输出：["255.255.11.135","255.255.111.35"]
             */
            print("结果是${solveOne("25525511135")}\n")
        }

        /**
         * 递归法
         * 剪枝
         * 区间 0 到255 只有4段
         */
        fun solveOne(s: String): List<String> {
            val result = mutableListOf<String>()
            fun getIpAddresses(s: String, startIndex: Int, path: MutableList<String>) {
                // 大于4，非法了
                if (path.size > 4) {
                    return
                }
                // 当数值相等的时候
                if (startIndex == s.length && path.size == 4) {
                    result.add(path.joinToString(separator = "."))
                    return
                }

                for (index in startIndex until s.length) {
                    val item = s.subSequence(startIndex, index + 1).toString()
                    // 查看范围是否在0到255之间,如果已经大于了 即可后面的无需遍历了
                    if (item.toInt() > 255 || (item.startsWith("0") && item.length > 1)) {
                        return
                    }
                    path.add(item)
                    getIpAddresses(s, index + 1, path)
                    path.removeAt(path.size - 1)
                }
            }
            getIpAddresses(s, 0, mutableListOf())
            return result
        }
    }
}