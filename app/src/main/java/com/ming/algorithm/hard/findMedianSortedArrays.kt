package com.ming.algorithm.hard

/**
 * @Description  寻找两个正序数组的中位数
 * @Author ming
 * @Date 2021/9/29 9:52
 */
class findMedianSortedArrays {
    companion object {
        /**
         * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
            输入：nums1 = [1,3], nums2 = [2]
            输出：2.00000
            解释：合并数组 = [1,2,3] ，中位数 2
             */
            val nums1= intArrayOf(1, 2)
            val nums2=intArrayOf(3, 4)
            print("结果是${solveOne(nums1, nums2)}\n")
        }

        /**
         * 复杂度（m+n）
         * 通过遍历全部 去进行排序
         */
        private fun solveOne(nums1: IntArray, nums2: IntArray): Double {
            //另一个为空 可马上退出
            if (nums1.isEmpty()){
                return if (nums2.size%2==0){
                    (nums2[nums2.size / 2 - 1]+nums2[nums2.size / 2]).toDouble()/2
                }else{
                    nums2[nums2.size / 2].toDouble()
                }
            }
            if (nums2.isEmpty()){
                return if (nums1.size%2==0){
                    (nums1[nums1.size / 2 - 1]+nums1[nums1.size / 2]).toDouble()/2
                }else{
                    nums1[nums1.size / 2].toDouble()
                }
            }
            val finalNums= IntArray(nums1.size + nums2.size)
            var count=0
            var i=0
            var j=0
            while (count!=nums1.size+nums2.size){
                //因为2个数组不一定一样长
                if(i==nums1.size){
                    while (j!=nums2.size){
                        finalNums[count++]=nums2[j++]
                    }
                    break
                }
                if(j==nums2.size){
                    while (i!=nums1.size){
                        finalNums[count++]=nums1[i++]
                    }
                    break
                }
                if (nums1[i]<nums2[j]){
                    finalNums[count++]=nums1[i++]
                }else{
                    finalNums[count++]=nums2[j++]
                }
            }
            //合并数组后 返回
            return if (finalNums.size%2==0){
                (finalNums[finalNums.size / 2 - 1]+finalNums[finalNums.size / 2]).toDouble()/2
            }else{
                finalNums[finalNums.size / 2].toDouble()
            }
        }

        /**
         * 二分法
         * 不断寻找中位数
         */
        private fun solveTwo(nums1: IntArray, nums2: IntArray): Double{
            val m: Int = nums1.size
            val n: Int = nums2.size
            val left = (m + n + 1) / 2
            val right = (m + n + 2) / 2
            //不用判断 如果数组是奇数 也会是同一个数
            return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0
        }

        //i: nums1的起始位置 j: nums2的起始位置
        fun findKth(nums1: IntArray, i: Int, nums2: IntArray, j: Int, k: Int): Int {
            //如果有数字长度大于 那就取其他数组就好
            if (i >= nums1.size) return nums2[j + k - 1] //nums1为空数组
            if (j >= nums2.size) return nums1[i + k - 1] //nums2为空数组
            if (k == 1) {
                return Math.min(nums1[i], nums2[j])
            }
            val midVal1 = if (i + k / 2 - 1 < nums1.size) nums1[i + k / 2 - 1] else Int.MAX_VALUE
            val midVal2 = if (j + k / 2 - 1 < nums2.size) nums2[j + k / 2 - 1] else Int.MAX_VALUE
            return if (midVal1 < midVal2) {
                findKth(nums1, i + k / 2, nums2, j, k - k / 2)
            } else {
                findKth(nums1, i, nums2, j + k / 2, k - k / 2)
            }
        }
    }
}