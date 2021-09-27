package com.test.offer;
import java.util.ArrayList;

/**
 * @Author: Jface
 * @Date: 2021/8/4 12:25
 * @Desc:
 */
public class JZ3 {
    //方法1, 遍历链表,把元素每次插入0位置, 这样后面的增加的元素永远在前面
    public ArrayList<Integer> printListFromTailToHead(com.itheima.nowcoder.ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        com.itheima.nowcoder.ListNode tmp = listNode;
        while(tmp!=null){
            list.add(0, (Integer) tmp.val);
            tmp=tmp.next;
        }
        return list;



    }
}
