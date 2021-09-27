package com.test.offer;

import java.util.Arrays;

/**
 * @Author: Jface
 * @Date: 2021/8/3 18:06
 * @Desc: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。1<=数组长度<=50000，0<=数组元素<=10000
 */
public class JZ28 {

    //排序法
    public int MoreThanHalfNum_Solution(int[] array) {
        Arrays.sort(array);
        return  array[array.length/2];
    }


    }
