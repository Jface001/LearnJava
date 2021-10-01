package com.test.demo03_flow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @Author: Jface
 * @Date: 2021/6/12 20:23
 * @Desc:
 * 自定义FlowBean类,继承WritableComparable接口,用于序列化和排序
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowBean implements WritableComparable<FlowBean> {
    //1.自定义的成员变量
    private Integer upFlow;
    private Integer downFlow;
    private Integer upTotalFlow;
    private Integer downTotalFlow;

    //2.展示的格式
    @Override
    public String toString() {
        return upFlow+"\t"+downFlow+"\t"+upTotalFlow+"\t"+downTotalFlow;
    }
    //3.用于排序,前减后升序, 后减前降序
    @Override
    public int compareTo(FlowBean fb) {
        int a = fb.getUpTotalFlow().compareTo(this.getUpTotalFlow());
        return a;
    }

    //4.用于序列化
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(upFlow);
        out.writeInt(downFlow);
        out.writeInt(upTotalFlow);
        out.writeInt(downTotalFlow);

    }
    //5.用于反序列化
    @Override
    public void readFields(DataInput in) throws IOException {
       upFlow = in.readInt();
       downFlow = in.readInt();
       upTotalFlow = in.readInt();
       downTotalFlow = in.readInt();

    }
}
