package com.ming.algorithm.bean

/**
 * @Description n节点的node
 * @Author ming
 * @Date 2023/3/8 23:34
 */
class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}