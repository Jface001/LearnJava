package com.test.service;


import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import com.test.dao.JdDao;
import com.test.pojo.Item;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: Jface
 * @Date: 2021/5/28 10:57
 * @Desc: 优化代码结构, 把部分功能抽成方法使用.
 */
public class MorePage_Method {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient =null;
        //1.确定首页URL
        for (int i = 1; i <= 82; i++) {
            String indexUrl = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&wq=%E6%89%8B%E6%9C%BA&pvid=292110923bc24800ad7d0648041f5a1d&page=" + (2 * i - 1) + "&s=117&click=0";
            //2.发送请求,获取数据
            //2.1 创建httpcient对象
           httpClient = HttpClients.createDefault();
            onePage(indexUrl, httpClient);
            System.out.println("---------------第" + i + "页已经解析添加成功!---------------");
        }

    }

    //解析1页的方法
    private static void onePage(String indexUrl, CloseableHttpClient httpClient) throws Exception {
        //2.2 创建请求方式的对象
        HttpGet httpGet = new HttpGet(indexUrl);
        //2.3 设置请求信息:请求头
        httpGet.setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36");
        //2.4 发送请求,获取响应对象
        CloseableHttpResponse response = httpClient.execute(httpGet);
        //2.5 根据响应对象,获取响应的数据
        if (response.getStatusLine().getStatusCode() == 200) {//判断状态码是否200
            HttpEntity entity = response.getEntity();//获取响应体
            String html = EntityUtils.toString(entity, "utf-8");//转换成字符串类型,指定编码
//            System.out.println(html);//打印测试

            //3.解析数据
            //3.1 根据HTML获取对应的document对象
            Document dom = Jsoup.parse(html);
            //3.2 获取每个商品的详细信息元素elements
            Elements liEle = dom.select("#J_goodsList>ul>li");
            //3.2.1创建一个集合,用于存储获取到的信息数据
            //3.2.2遍历ELement 获取每一个li标签
            ArrayList<Item> list = new ArrayList<>();
            for (Element li : liEle) {
                Item item = getItem(httpClient, li);
                //3.12 把item对象放入到一个集合中
                list.add(item);
                //4.保存数据
                //4.1 把item对象属性存入对应的数据库中
                new JdDao().saveItems(list);
            }

        }
    }

    //解析每页数据的方法
    private static Item getItem(CloseableHttpClient httpClient, Element li) throws Exception {
        //3.3 获取spu,属性选择器
        String sku = li.attr("data-sku");
        //3.4 获取sku
        String spu = li.attr("data-spu");
        if (spu != sku || spu == null) {
            spu = sku;
        }
        //3.5 获取title,属性选择器
        String title = li.select("div[class ='p-name p-name-type-2'] em").text();
//                System.out.println(title);
        //3.6 获取price
        String price = li.select(".p-price i").text();
//                System.out.println(price);
        //3.7 获取pic
        String pic = "http:" + li.select(".p-img img").attr("data-lazy-img");
//                System.out.println(pic);

        downloadPic(httpClient, pic);

        //3.8 获取url
        String url = "https://item.jd.com/" + sku + ".html";
        //3.9 获取created
        String created = new Date().toLocaleString();
        //3.10 获取updated
        String updated = new Date().toLocaleString();
        //3.11 把获取的元素封装到item对象
        Item item = new Item(
                null,
                Long.parseLong(sku),
                Long.parseLong(spu),
                title,
                Double.parseDouble(price),
                pic,
                url,
                created,
                updated);
        return item;
    }

    private static void downloadPic(CloseableHttpClient httpClient, String pic) throws Exception {
        //下载图片
        //2.获取请求对象
        HttpGet picGet = new HttpGet(pic);
        //3.设置请求头
        picGet.setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36");
        //4.发送请求,获取响应对象
        CloseableHttpResponse response1 = httpClient.execute(picGet);
        //5.根据响应对象,获取响应体
        HttpEntity entity1 = response1.getEntity();
        //6.从响应体中获取输入流
        InputStream is = entity1.getContent();
        //7.生成图片的名称
        //先获取索引所在位置,在从索引位置往后截取
        String s = UUID.randomUUID().toString().replace("-", "") + pic.substring(pic.lastIndexOf("."));
        //8.获取输出流,关联目的地文件
        FileOutputStream fs = new FileOutputStream("d://test/pic/" + s);
        //9.具体的IO流读写操作
        byte[] bys = new byte[8192];
        int len;
        while ((len = is.read(bys)) != -1) {
            fs.write(bys, 0, bys.length);
        }
        //10.释放资源
        is.close();
        fs.close();
    }

}
