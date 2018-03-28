package com.gyx.service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2018/3/19.
 */
public class RedisService {

    public void testRes(){
        Jedis jedis = new Jedis("47.95.230.74",6379);

        //设置值
        jedis.set("java1718","棒棒哒！");

        //取值
        String java1718 = jedis.get("java1718");
        System.out.println(java1718);
    }

    public void testPool(){
        JedisPool jedisPool = new JedisPool("47.95.230.74",6379);
        //从连接池获取一个具体的连接
        Jedis jedis = jedisPool.getResource();
        //设置值
        jedis.set("java1719","刚刚开学");
        //取值
        String java1719 = jedis.get("java1719");
        System.out.println(java1719);
        jedis.close();
    }

    public static void main(String[] args) {
        RedisService redisService = new RedisService();
//        redisService.testRes();
        redisService.testPool();

    }

}
