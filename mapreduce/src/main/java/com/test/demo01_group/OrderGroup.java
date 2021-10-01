package com.test.demo01_group;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * @Author: Jface
 * @Date: 2021/6/11 20:03
 * @Desc:
 * 自定义的分组组件,继承WritableComparator类,按照订单号分组
 */
public class OrderGroup extends WritableComparator {
    //固定写法, 传入K2的类型, 且显示设定: 需要创建k2的对象.
    public OrderGroup(){
        //传入的k2对象
        super(OrderBean.class,true);//这行啥意思??

    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        OrderBean ob1 = (OrderBean) a;
        OrderBean ob2 = (OrderBean) b;
        return ob1.getOrderId().compareTo(ob2.getOrderId());//谁在前谁在无所谓.

    }
}
