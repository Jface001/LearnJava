package com.test.jedis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;

/**
 * @Author: Jface
 * @Date: 2021/7/24 18:32
 * @Desc: java开发操作Redis客户端
 */

public class JedisClientTest {
    //1.构建连接, 获取客户端连接对象
    //Jedis jedis = null;
    JedisCluster jedisCluster = null;
    @Before
    public void getJedis() {
        //方式1: 直接构建Jedis对象
        //jedis= new Jedis("node1", 6379);

        //方式2:构建连接池
        //2.1新建配置文件, 设置配置文件
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(30);//资源池中的最大连接数
        jedisPoolConfig.setMaxIdle(20);//资源池允许的最大空闲连接数
        jedisPoolConfig.setMaxWaitMillis(1500);//等待时间
//        //2.2获取线程池对象
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "node1", 6379);
//        //2.3获取数据库连接
//        jedis = jedisPool.getResource();

        //方式3: 构建哨兵集群连接池, 第一个参数是Master逻辑名称, 第二个是哨兵列表, 第三个是连接池的配置
//        HashSet<String> sets = new HashSet<>();
//        sets.add("node1:26379");
//        sets.add("node2:26379");
//        sets.add("node3:26379");
//        JedisSentinelPool mymaster = new JedisSentinelPool("mymaster", sets, jedisPoolConfig);
//        jedis = mymaster.getResource();

        //方式4: 分片集群构建连接池
        HashSet<HostAndPort> sets2 =new HashSet<>();
        sets2.add(new HostAndPort("192.168.88.161",7001));
        sets2.add(new HostAndPort("192.168.88.161",7002));
        sets2.add(new HostAndPort("192.168.88.162",7001));
        sets2.add(new HostAndPort("192.168.88.162",7002));
        sets2.add(new HostAndPort("192.168.88.163",7001));
        sets2.add(new HostAndPort("192.168.88.163",7002));

        jedisCluster = new JedisCluster(sets2, 2000, 2000, 5, "123456", jedisPoolConfig);


    }

    //2.测试代码逻辑

    //String数据类型
    //set/get/incr/exists/expire/setex/ttl
//    @Test
//    public void testString() {
//        jedis.set("s1", "Hadoop");
//        System.out.println(jedis.get("s1"));
//        System.out.println(jedis.exists("s1"));
//        System.out.println(jedis.exists("s2"));
//        System.out.println("---------------------");
//        jedis.set("s4", "oozie");
//        jedis.expire("s4", 10);
//        System.out.println(jedis.ttl("s4"));
//        jedis.setex("s5", 10, "mysql");
//        System.out.println(jedis.ttl("s5"));
//        System.out.println("----------------------");
//        jedis.set("s7", "22");
//        jedis.incr("s7");
//        System.out.println(jedis.get("s7"));
//
//    }

    //测试Hash数据类型
    //hset/hmset/hget/hgetall/hdel/hlen/hexists
//    @Test
//    public void hashText(){
//        jedis.hset("m1","name","libai");
//        System.out.println(jedis.hget("m1", "name"));
//        Map<String,String> maps = new HashMap<>();
//        maps.put("age","23");
//        maps.put("city","shenzhen");
//        jedis.hmset("m1",maps);
//        List<String> list = jedis.hmget("m1", "name", "age");
//        for (String s : list) {
//            System.out.println(s);
//        }
//        System.out.println("-------------------");
//        Map<String, String> map2 =new HashMap<>();
//        map2.put("id","23232");
//        map2.put("phone","112");
//        map2.put("gender","male");
//        jedis.hmset("m2",map2);
//        Map<String, String> m3 = jedis.hgetAll("m2");
//        Set<Map.Entry<String, String>> entries = m3.entrySet();
//        for (Map.Entry<String, String> s : entries) {
//            System.out.println(s);
//        }
//        System.out.println("---------------------");
//        System.out.println(jedis.hvals("m1"));
//    }
//
//    //测试哨兵集群
//    @Test
//    public void sentinelTest(){
//        jedis.set("s1","oooozie");
//    }

    //测试分片集群
    @Test
    public void clusterTest(){
        jedisCluster.set("s6","presto");
        System.out.println(jedisCluster.get("s2"));


    }

    //3.释放资源
    @After
    public void closeJedis() {
        //jedis.close();
        jedisCluster.close();
    }


}
