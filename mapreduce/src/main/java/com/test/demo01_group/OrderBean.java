package com.test.demo01_group;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @Author: Jface
 * @Date: 2021/6/11 13:21
 * @Desc: 自定义的OrderBean类, 表示序列化和排序, 实现WritableComparable接口
 */
public class OrderBean implements WritableComparable<OrderBean> {
    //1.定义3个变量,分别表示订单id, 商品id,商品价格
    private String orderId;
    private String pid;
    private Double price;

    //2.空参和全参
    public OrderBean() {
    }

    public OrderBean(String orderId, String pid, Double price) {
        this.orderId = orderId;
        this.pid = pid;
        this.price = price;
    }

    //3.getXxx()  setXxx()


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    //4.重写toString()方法,
    @Override
    public String toString() {

        return orderId + "\t" + pid + "\t" + price;
    }

    //5.序列化
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(orderId);
        out.writeUTF(pid);
        out.writeDouble(price);
    }

    //6.反序列化,牢记和序列化顺序一致.
    @Override
    public void readFields(DataInput in) throws IOException {
        orderId = in.readUTF();
        pid = in.readUTF();
        price = in.readDouble();
    }

    //7.排序的,前减后升序, 后减前降序,//前.compareTo(后)   this:前, ob:后
    //排序规则: 按照订单号升序排序, 订单号一致, 按照金额降序排序.
    @Override
    public int compareTo(OrderBean ob) {
        //按照订单号升序排序
        int a = this.orderId.compareTo(ob.getOrderId());
        //按照金额降序排序.
        int b = a == 0 ? ob.getPrice().compareTo(this.price) : a;
        return b;
    }
}
