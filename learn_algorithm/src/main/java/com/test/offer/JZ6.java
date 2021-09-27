package com.test.offer;

/**
 * @Author: Jface
 * @Date: 2021/7/24 12:25
 * @Desc: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 非递减排序的数组: 就是递增的数组但是数可以有重复
 */
public class JZ6 {

    //方法1: 遍历数组求最小值.
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int min = array[0];
        {
            for (int i = 0; i < array.length; i++) {
                if (array[i] < min)
                    min = array[i];
            }
            return min;
        }

    }

    //方式2: 二分法
    public int minNumberInRotateArray2(int [] array) {
        if(array.length==0)
            return 0;
        int l = 0;
        int h = array.length-1;
        while (l <= h){// 当l=h的时候, 跳出循环,满足条件了~
            int m = l +  (h-l)/2;//等同于 (l+h)/2 但是可以避免相加内存溢出
            if( array[m] < array[h] )//说明最小值在左边
                h=m;
            else if(array[m] > array[h])// 说明最小值在右边
                l=m+1;
            else h--; // 如果相等, 缩短继续判断, 因为m=h 所以h对应的值有两个位置, 去掉最尾的一个也没事儿.
        }

        return array[l];
    }



}



