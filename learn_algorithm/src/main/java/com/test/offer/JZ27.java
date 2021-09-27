package com.test.offer;

/**
 * @Author: Jface
 * @Date: 2021/7/26 23:19
 * @Desc: 统计一个数字在升序数组中出现的次数。
 */
public class JZ27 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 3, 3, 3, 4, 5};
        int i = 3;
        System.out.println(GetNumberOfK2(arr1, i));
    }

    //方式1, 遍历数组, 对比统计即可
    public static int GetNumberOfK(int[] array, int k) {
        int num = 0;
        for (int i : array) {
            if (i == k)
                num++;
        }
        return num;

    }

    //方法2, 二分法, 即求目标数字出现的次数.
    public static int GetNumberOfK2(int[] array, int k) {
        //寻找左边界
        int l = 0;
        int h = array.length - 1;
        int index = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (array[mid] < k)
                l = mid + 1;
            else h = mid - 1;
        }
        index = l;
        //寻找右边界
        l = 0;
        h = array.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (array[mid] > k)
                h = mid - 1;
            else l = mid + 1;
        }
        return l - index;

    }
}


