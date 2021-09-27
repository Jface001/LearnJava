package com.test.offer;

/**
 * @Author: Jface
 * @Date: 2021/8/4 14:34
 * @Desc:
 */
public class ListNode<E>{                //类名 ：Java类就是一种自定义的数据结构
    E val;                        //数据 ：节点数据
    ListNode<E> next;             //对象 ：引用下一个节点对象。在Java中没有指针的概念，Java中的引用和C语言的指针类似

    ListNode(E val){              //构造方法 ：构造方法和类名相同
        this.val=val;             //把接收的参数赋值给当前类的val变量
    }
}
