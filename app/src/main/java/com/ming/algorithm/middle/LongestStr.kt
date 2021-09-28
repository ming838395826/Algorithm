package com.ming.algorithm.middle

import com.ming.algorithm.util.LogUtils

/**
 * @Description 查找最长
 * @Author ming
 * @Date 2021/9/28 19:50
 */
class LongestStr {
    companion object {
        /**
         * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
                输入: s = "abcabcbb"
                输出: 3
                解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
             */
            print("结果是${solveOne("pwwkew")}\n")
            print("结果是${solveTwo("abcabcbb")}\n")
        }

        /**
         * 复杂度
         * 时间O(n^2)
         * 空间O(1)
         */
        private fun solveOne(s: String):Int{
            LogUtils.printRunTime(true)
            var maxLength=0
            val list=s.toCharArray()
            for (i1 in 0 until list.size){
                val builder=StringBuilder()
                for (i2 in i1+1 until list.size){
                    if(!builder.contains(list[i2])){
                        builder.append(list[i2])
                    }else{
                        if(builder.length>maxLength){
                            maxLength=builder.length
                        }
                        print("${builder}\n")
                        break
                    }
                }
            }
            LogUtils.printRunTime(false)
            return maxLength
        }

        /**
         * 滑窗法
         * 复杂度
         * 时间O(n)
         * 空间O(n)
         */
        private fun solveTwo(s: String):Int{
            LogUtils.printRunTime(true)
            var maxLength=0
            val map=HashMap<Char,Int>()
            val builder=StringBuilder()
            val list=s.toCharArray()
            for ((index,item) in list.withIndex()){
                if (builder.contains(item)){
                    print("${builder}\n")
                    val sameIndex=map[item]
                    //如果相邻 就应该按最后一个
                    if ((index-sameIndex!!)===1){
                        builder.clear()
                    }else{
                        //总长-差值 等于要移动的位置
                        val next=builder.substring(builder.length-(index-sameIndex!!)+1)
                        builder.clear()
                        builder.append(next)
                    }
                }
                builder.append(item)
                map[item] = index
                if(builder.length>maxLength){
                    maxLength=builder.length
                }
            }
            LogUtils.printRunTime(false)
            return maxLength
        }
    }
}