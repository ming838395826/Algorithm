package com.ming.algorithm.simple

import com.ming.algorithm.util.LogUtils
import java.lang.StringBuilder

/**
 * @Description 两数之和
 * @Author ming
 * @Date 2021/9/25 16:34
 */
class ListNodePlus {

    companion object {
        /**
         * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
        请你将两个数相加，并以相同形式返回一个表示和的链表。
        你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
         */
        @JvmStatic
        fun main(args: Array<String>) {
            /**
             * 输入：l1 = [2,4,3], l2 = [5,6,4]
             * 输出：[7,0,8]
             * 解释：342 + 465 = 807.
             */
            val one = initListNode(listOf(2,4,3))
            val two = initListNode(listOf(5,6,4))
            print("结果是${solveTwo(one, two).toString()}\n")
//            print("结果是${solveTwo(nums, target)}\n")
        }

        /**
         * 初始化数据
         */
        fun initListNode(data:List<Int>):ListNode{
            var result=ListNode(data[0])
            var temp:ListNode=result
            for (index in 1 until data.size){
                val next=ListNode(data[index])
                temp.next= next
                temp=next
            }
            return result
        }

        fun addPlus(firstdata:ListNode?,data:ListNode?,needAdd:Boolean,l1: ListNode?, l2: ListNode?):ListNode{
            if (l1===null&&l2===null) {
                if (needAdd){
                    data!!.next=ListNode(1)
                }
                return firstdata!!
            }

            var itemOne=if (l1 ===null) 0  else l1.`val`
            var itemTwo=if (l2 ===null) 0  else l2.`val`
            val total=itemOne+itemTwo+if (needAdd) 1 else 0
            val result=ListNode(total%10)
            var firstdata=firstdata
            if (data!==null){
                data.next=result
            }else{
                firstdata=result
            }
            if(l1!==null||l2!==null){
                return addPlus(firstdata,
                        result,needAdd = total>=10,
                        if (l1 ===null) null  else l1.next,
                        if (l2 ===null) null  else l2.next)
            }else{
                return firstdata!!
            }
        }

        fun solveOne(l1: ListNode, l2: ListNode): ListNode {
            LogUtils.printRunTime(true)
            val reuslt =addPlus(null,null,false,l1,l2)
            LogUtils.printRunTime(false)
            return reuslt
        }

        /**
         * 通过while进行
         */
        fun solveTwo(l1: ListNode, l2: ListNode): ListNode{
            var data=(l1.`val`+l2.`val`)
            var carry=data/10
            val result=ListNode(data%10)
            var ln1=l1.next
            var ln2=l2.next
            var node=result
            while (ln1!==null||ln2!==null){
                val next=ListNode(0)
                if (ln1===null){
                    data=ln2!!.`val`+carry
                }else if(ln2===null){
                    data=ln1!!.`val`+carry
                }else{
                    data=ln1.`val`+ln2.`val`+carry
                }
                next.`val`=data%10
                carry=data/10
                node.next=next

                //置换值
                ln1=ln1?.next
                ln2=ln2?.next
                node=next
            }
            if(carry!==0){
                node.next= ListNode(carry)
            }
            return result
        }
    }



    /**
     * 链表类
     */
    class ListNode(var `val`: Int) {
        var next: ListNode? = null

        companion object{
            /**
             * 初始化数据
             */
            fun initListNode(data:List<Int>):ListNode{
                var result=ListNode(data[0])
                var temp:ListNode=result
                for (index in 1 until data.size){
                    val next=ListNode(data[index])
                    temp.next= next
                    temp=next
                }
                return result
            }
        }

        override fun toString(): String {
            return getValue(StringBuilder("["),this)
        }

        fun getValue(builder: StringBuilder,data:ListNode):String{
            builder.append(data.`val`)
            return if(data.next!==null){
                getValue(builder,data.next!!)
            }else{
                builder.append("]").toString()
            }
        }
    }
}