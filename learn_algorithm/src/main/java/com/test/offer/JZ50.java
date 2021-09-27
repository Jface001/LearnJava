package com.test.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Jface
 * @Date: 2021/7/29 17:36
 * @Desc: 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任一一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。存在不合法的输入的话输出-1
 */
public class JZ50 {

    //方法1: 新建一个set集合, 把数组元素放入, 再次遍历集合,如果集合里面有就返回数值, 没有就加入集合
    public int duplicate(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i : numbers) {
            if (set.contains(i))
                return i;
            else set.add(i);
        }
        return -1;

    }

    //方式2: 通过新建一个等长数组,数组下标表示给定数组的值, 值代表该数值出现的次数,值超过1即出现重复
    public int duplicate2(int[] numbers) {
        int[] A = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            A[numbers[i]]++;//int 数组默认值为0, 自增值就变成1
            if (A[numbers[i]] > 1)
                return numbers[i];
        }
        return -1;
    }

    //方式3:替换法, 让下标和对应的值相同,重复出现的数字,第二次出现的下标肯定不会和值相同
    // 数组存放原则：numbers[i] = i,如果该位置上已经有值了, 说明数值重复.
    public int duplicate3(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {//如果相等就跳过,开始下一次循环
                if (numbers[i] == numbers[numbers[i]])//相等情况有两种, 一种是下标和对应值相等, 第二种是
                    return numbers[i];
                //循环赋值, 直至循环跳出.假设 numbers[0]=2;
                int tmp = numbers[numbers[i]];//tmp = numbers[2]
                numbers[numbers[i]] = numbers[i];//numbers[2]=number[0]
                numbers[i] = tmp;//number[0]=tmp==number[2],完成交换
            }

        }

        return -1;

    }
}
