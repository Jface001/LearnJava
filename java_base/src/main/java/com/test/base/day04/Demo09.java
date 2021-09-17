package com.test.base.day04;

/**
 * @Author: Jface
 * @Date: 2021/5/7 23:42
 * @Desc:
 * 9. 定义Demo09类, 在main中调用isEvenNumber()方法, 用来判断数据是奇数还是偶数.
 * 		目的: 本题主要考察 有参有返回的方法 的定义和调用.
 *
 * 		提示:
 * 			1. 在main方法外边定义isEvenNumber()方法.
 * 			2. isEvenNumber()方法接收一个int类型的变量.
 * 			3. 在isEvenNumber()方法内部实现判断奇偶数, 并返回结果(boolean类型的值).
 * 			4. 在main方法中调用isEvenNumber()方法.
 */
public class Demo09 {
    public static void main(String[] args) {
    /*
    调用方法的3个步骤
    A.isEvenNumber
    B.传参
    C.接收返回值
     */
//        赋值调用
        boolean a=isEvenNumber(24);
        System.out.println(a);
//        输出调用
        System.out.println(isEvenNumber(3));
    }

//    1.定义方法3个步骤
//    A isEvenNumer
//    B int a
//    C return boolean
    public static boolean isEvenNumber(int num){  // 这里的a是形参
//        方法一：if else
//        if (num % 2==0) //没有其它，中括号可以省略，写起来更好看
//            return true;
//        else
//            return false;
//        方法二：三元运算
        return num % 2 == 0;// 需要设定一个变量来接收结果。简化成这样也可以！
    }
}
