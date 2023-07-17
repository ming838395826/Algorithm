package com.ming.algorithm.middle

/**
 * @Description  寻找重复数
 * @Author ming
 * @Date 2022/2/13 14:46
 */
class FindDuplicate {

    companion object {
        /**
        给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
        假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
        你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums = [1,3,4,2,2]
            输出：2
             */
            print("结果是${solveOne(intArrayOf(1,3,4,2,2))}\n")
        }

        /**
         * 快慢指针
         * 将数组转化为环形链表
         * 前提： 是从1开头，如果0开头 可以能出现死循环,并且只有一个数多
         * 假设从头结点到环形入口节点 的节点数为x。 环形入口节点到 fast指针与slow指针相遇节点 节点数为y。 从相遇节点 再到环形入口节点节点数为 z。
         *  slow指针走过的节点数为: x + y
         *  fast指针走过的节点数：x + y + n (y + z)，n为fast指针在环内走了n圈才遇到slow指针
         *  因为fast指针是一步走两个节点，slow指针一步走一个节点， 所以 fast指针走过的节点数 = slow指针走过的节点数 * 2：
         *  (x + y) * 2 = x + y + n (y + z)
         *  两边消掉一个（x+y）: x + y = n (y + z)
         *  x = n (y + z) - y
         *  意这里n一定是大于等于1的，因为 fast指针至少要多走一圈才能相遇slow指针
         *  x = z
         *  这就意味着，从头结点出发一个指针，从相遇节点 也出发一个指针，这两个指针每次只走一个节点， 那么当这两个指针相遇的时候就是 环形入口的节点。
         */
        private fun solveOne(nums: IntArray): Int {
            var slow = nums[0]
            var fast = nums[nums[0]]
            //找出相遇的节点
            while (slow != fast) {
                slow = nums[slow]
                fast = nums[nums[fast]]
            }
            var head = 0
            // 因为x = z 找出入环的起点
            while (head != slow) {
                head = nums[head]
                slow = nums[slow]
            }
            return head
        }
    }
}