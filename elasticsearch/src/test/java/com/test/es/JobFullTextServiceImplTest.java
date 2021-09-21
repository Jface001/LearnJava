package com.test.es;


import com.test.es.bean.JobDetail;
import com.test.es.service.JobFullTextServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author: Jface
 * @Date: 2021/8/5 19:58
 * @Desc:
 */
public class JobFullTextServiceImplTest {

    private JobFullTextServiceImpl jobFullTextService;

    @Before
    public void getInstance() {
        //构建实现类的实例对象：构建连接
        jobFullTextService = new JobFullTextServiceImpl();
    }

    @Test
    public void add() {
        //构建JaIndexRequestvaBean实例
        JobDetail jobDetail = new JobDetail();
        jobDetail.setId(1);
        jobDetail.setArea("江苏省-南京市");
        jobDetail.setCmp("Elasticsearch大学");
        jobDetail.setEdu("本科及以上");
        jobDetail.setExp("一年工作经验");
        jobDetail.setTitle("大数据工程师");
        jobDetail.setJob_type("全职");
        jobDetail.setPv("1700次浏览");
        jobDetail.setJd("会Hadoop就行");
        jobDetail.setSalary("5-9千/月");
        //调用add方法
        jobFullTextService.add(jobDetail);

    }

    //测试更新数据
    @Test
    public void update() throws IOException {
        JobDetail jobDetail = new JobDetail();
        jobDetail.setId(1);
        jobDetail.setArea("江苏省-南京市");
        jobDetail.setCmp("Elasticsearch大学");
        jobDetail.setEdu("本科及以上");
        jobDetail.setExp("一年工作经验");
        jobDetail.setTitle("大数据工程师");
        jobDetail.setJob_type("全职");
        jobDetail.setPv("1700次浏览");
        jobDetail.setJd("会Hadoop就行");
        jobDetail.setSalary("20-40千/月");
        //调用更新方法进行更新
        jobFullTextService.update(jobDetail);

    }

    //测试删除数据
    @Test
    public void deleteById() throws IOException {
        jobFullTextService.deleteById(1);


    }

    //测试根据dcoId获取数据
    @Test
    public void findById() throws IOException {
        JobDetail byId = jobFullTextService.findById(1);
        System.out.println(byId);

    }

    //根据条件查询数据
    @Test
    public void searchByKeywords() throws IOException {
        List<JobDetail> jobDetails = jobFullTextService.searchByKeywords("销售");
        for (JobDetail jobDetail : jobDetails) {
            System.out.println(jobDetail);
        }

    }

    //测试浅分页查询
    @Test
    public void searchByPage() throws IOException {

        Map<String, Object> objectMap = jobFullTextService.searchByPage("销售", 0, 100);
        System.out.println("总共：" + objectMap.get("total"));
        List<JobDetail> list = (List<JobDetail>) objectMap.get("content");
        for (JobDetail jobDetail : list) {
            System.out.println(jobDetail);
        }

    }

    //测试深分页查询
    //第1次运行
    @Test
    public void searchByScrollPage1() throws IOException {
        Map<String, Object> result = jobFullTextService.searchByScrollPage("销售", null, 100);
        System.out.println("scrollId: " + result.get("scroll_id"));
        List<JobDetail> content = (List<JobDetail>) result.get("content");
        for (JobDetail jobDetail : content) {
            System.out.println(jobDetail);
        }

    }

    //第2次开始
    @Test
    public void searchByScrollPage2() throws IOException {
        Map<String, Object> result = jobFullTextService.searchByScrollPage("销售",
                "DnF1ZXJ5VGhlbkZldGNoBQAAAAAAAAAyFjVBazloeGo2VE1tZWYxbHdENEN4YUEAAAAAAAAAPBZmYi0ycUNYOVNMQ1AwZ1EyNWxVWWVnAAAAAAAAAEEWNHgzeHZFUG1RYlNlalR1SFdKQXNaQQAAAAAAAAA7FmZiLTJxQ1g5U0xDUDBnUTI1bFVZZWcAAAAAAAAAMxY1QWs5aHhqNlRNbWVmMWx3RDRDeGFB",
                100);
        System.out.println("scrollId: " + result.get("scroll_id"));
        List<JobDetail> content = (List<JobDetail>) result.get("content");
        for (JobDetail jobDetail : content) {
            System.out.println(jobDetail);
        }

    }

    //释放资源
    @After
    public void close() {
    }
}