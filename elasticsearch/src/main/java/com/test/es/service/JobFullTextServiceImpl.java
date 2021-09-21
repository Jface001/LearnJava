package com.test.es.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.es.bean.JobDetail;
import com.test.es.imlp.JobFullTextService;
import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Jface
 * @Date: 2021/8/5 17:57
 * @Desc: ES的客户端操作类, 实现数据操作接口, 用于对ES进行增删改查操作
 */
public class JobFullTextServiceImpl implements JobFullTextService {
    //构建客户端连接对象
    private RestHighLevelClient restHighLevelClient;
    //定义索引库名称
    private static final String JOB_IDX_NAME = "job_idx";

    //构造函数, new对象自带客户端连接.
    public JobFullTextServiceImpl() {
        RestClientBuilder clientBuilder = RestClient.builder(
                new HttpHost("node1", 9200, "http"),
                new HttpHost("node2", 9200, "http"),
                new HttpHost("node3", 9200, "http"));
        restHighLevelClient = new RestHighLevelClient(clientBuilder);
    }
    //连接对象中包含了所有增删改查的方法
    //restHighLevelClient.index() 用于写入或者更新数据【用于更新数据性能会更好】
    //restHighLevelClient.update() 用于实现数据的更新
    //restHighLevelClient.delete() 用于删除数据
    //restHighLevelClient.get() 根据指定的docid查询
    //restHighLevelClient.search() 根据指定的条件查询器进行查询


    //往ES写入数据,格式为JSON
    @Override
    public void add(JobDetail jobDetail) {
        IndexRequest indexRequest = new IndexRequest(JOB_IDX_NAME);//获取请求器
        indexRequest.id(jobDetail.getId() + "");//获取docID并转为字符串类型,封装到请求器
        String jsonString = JSON.toJSONString(jobDetail);//将bean对象转换为JSON格式
        indexRequest.source(jsonString, XContentType.JSON);//将JSON数据加载到请求器中
        try {
            restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);//客户端连接调用index方法,写入数据集
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //数据更新
    @Override
    public void update(JobDetail jobDetail) throws IOException {
        //1.先根据docId是否存在, 存在就走下一步, 不存在就直接返回结果
        GetRequest getRequest = new GetRequest(JOB_IDX_NAME);
        getRequest.id(jobDetail.getId() + "");
        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        if (!exists)

            return;

        else {

            //2.新建更新请求器, 加载索引库名称和docId名称
            UpdateRequest updateRequest = new UpdateRequest(JOB_IDX_NAME, jobDetail.getId() + "");
            //加载要更新的JSON对象到请求器
            updateRequest.doc(JSON.toJSONString(jobDetail), XContentType.JSON);
            restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);

        }

    }

    //删除数据
    @Override
    public void deleteById(long id) throws IOException {
        //同样先判断对应docId是否存在
        GetRequest getRequest = new GetRequest(JOB_IDX_NAME);
        getRequest.id(id + "");
        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        if (!exists)

            return;

        else {

            DeleteRequest deleteRequest = new DeleteRequest(JOB_IDX_NAME);
            deleteRequest.id(id + "");
            restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        }

    }

    //通过docId查询
    @Override
    public JobDetail findById(long id) throws IOException {
        //请求一个Get请求器对象
        GetRequest getRequest = new GetRequest(JOB_IDX_NAME);
        ///指定docId
        getRequest.id(id + "");
        //调用方法获取结果集
        GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        //解析主题,获取docId和数据对象
        String s = documentFields.getSourceAsString();
        String id1 = documentFields.getId();
        //把source内容转换为数据对象, 里面没有docId, 所以需要添加进去
        JobDetail jobDetail = JSON.parseObject(s, JobDetail.class);
        jobDetail.setId(Integer.parseInt(id1));
        return jobDetail;

    }

    /**
     * 给定关键字, 通过查询符合条件的所有doc进行返回
     *
     * @param keywords 用户输入的关键词
     * @return 符合条件的所有数据
     * @throws IOException
     */
    @Override
    public List<JobDetail> searchByKeywords(String keywords) throws IOException {
        //0.新建集合, 用于存储结果, 因为结果数据有多条
        ArrayList list = new ArrayList<JobDetail>();
        //1.新建搜索请求器
        //1.1获取查询器
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(keywords, "jd", "title");
        //1.2通过查询器获取条件查询的建造器
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(multiMatchQueryBuilder).size(100);
        //1.3 通过建造器,获取搜索请求器
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.source(searchSourceBuilder);

        //2.调用search方法, 获取结果
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        //3.解析结果封装成数据对象
        SearchHit[] hits = searchResponse.getHits().getHits();
        for (SearchHit hit : hits) {
            String content = hit.getSourceAsString();
            JobDetail jobDetail = JSON.parseObject(hit.getSourceAsString(), JobDetail.class);
            jobDetail.setId(Long.parseLong(hit.getId()));
            list.add(jobDetail);
        }

        return list;
    }


    /**
     * 深分页查询
     *
     * @param keywords 查关键词
     * @param pageNum  起始页码
     * @param pageSize 展示条数
     * @return
     * @throws IOException
     */
    @Override
    public Map<String, Object> searchByPage(String keywords, int pageNum, int pageSize) throws IOException {
        //0.新建集合, 用于存储结果, 因为结果数据有多条
        ArrayList<JobDetail> list = new ArrayList<>();
        //1.新建搜索请求器
        //1.1获取查询器
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(keywords, "jd", "title");
        //1.2通过查询器获取条件查询的建造器
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(multiMatchQueryBuilder).from(pageNum).size(pageSize);
        //1.3 通过建造器,获取搜索请求器
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.source(searchSourceBuilder);
        //1.4调用方法, 获取结果集并做解析
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        //取第一层hits, 包含了总览信息以及每一条数据,
        SearchHits hits = search.getHits();
        //1.5将获取的数据封装成数据对象,添加到结果集合
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            String id = hit.getId();
            JobDetail jobDetail = JSON.parseObject(sourceAsString, JobDetail.class);
            jobDetail.setId(Long.parseLong(id));
            list.add(jobDetail);
        }
        //1.5构建返回值集合
        Map<String, Object> result = new HashMap<>();
        //第一条数据, Key : total, value: 返回值的总条数
        result.put("total", hits.getTotalHits().value);
        //第二条数据: key :content,value: 每条数据
        result.put("content", list);
        return result;

    }

    /**
     * 深分页查询
     *
     * @param keywords 搜索关键词
     * @param scrollId 内存数据的ID, 首次执行才会产生
     * @param pageSize 每页显示条数
     * @return
     * @throws IOException
     */
    @Override
    public Map<String, Object> searchByScrollPage(String keywords, String scrollId, int pageSize) throws IOException {
        //0.构建两个集合, 用于存储结果
        Map<String, Object> result = new HashMap<>();
        List<JobDetail> lists = new ArrayList<>();
        SearchResponse searchResponse =null;
        try {
            //1.先判断内存的数据是否为null, 如果为null就是第一次执行
            if (scrollId == null) {
                //1.1 创建查询器
                MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(keywords, "jd", "title");
                //1.2 创建建造器
                SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                searchSourceBuilder.size(pageSize);//设置每页查询条件
                SearchSourceBuilder sourceBuilder = searchSourceBuilder.query(multiMatchQueryBuilder);
                //1.3 创建搜索请求器
                SearchRequest searchRequest = new SearchRequest(JOB_IDX_NAME);
                searchRequest.source(sourceBuilder);
                searchRequest.scroll(TimeValue.timeValueMinutes(1));//设置数据在内存中存活时间
                //1.4 发起请求,获取结果
                searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

            } else {
                //2.不是第一次, 直接根据scrollid来查询
                //2.1 构建深分页查询器, 传递scrllid
                SearchScrollRequest searchScrollRequest = new SearchScrollRequest(scrollId);
                searchScrollRequest.scroll(TimeValue.timeValueMinutes(1));
                searchResponse = restHighLevelClient.scroll(searchScrollRequest,RequestOptions.DEFAULT);
            }

            //3.解析结果
            SearchHits hits = searchResponse.getHits();
            for (SearchHit hit : hits) {
                String id = hit.getId();
                String sourceAsString = hit.getSourceAsString();
                JobDetail jobDetail = JSONObject.parseObject(sourceAsString, JobDetail.class);// 把字符串形式的JSON转换为指定的类
                jobDetail.setId(Integer.parseInt(id));//获取docId
                lists.add(jobDetail);//添加到结果集合
            }
            //4.把结果放入集合并返回
            //4.1 第一条数据, 数据总览信息
            result.put("scroll_id",searchResponse.getScrollId());
            //4.2 第二条数据, 每一条具体数据
            result.put("content",lists);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //释放资源
    @Override
    public void close() throws IOException {
        restHighLevelClient.close();
    }

}
