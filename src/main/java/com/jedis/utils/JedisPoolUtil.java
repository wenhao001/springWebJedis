package com.jedis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by jeremy on 16/5/1.
 */
public class JedisPoolUtil {
    private static JedisPool pool;
    private static String host = "192.168.1.110";
    private static int port = 6379;
    private static String PASSWORD = "lwh1056927";


    private static void createJedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxActive(10);
        config.setMaxWait(1000);
        config.setMaxIdle(10);
        pool = new JedisPool(config, host, port);
    }

    private static synchronized void poolInit(){
        if (pool == null){
            createJedisPool();
        }
    }

    public static Jedis getJedis(){
        if (pool == null){
            poolInit();
        }
        Jedis jedis = pool.getResource();
        if (jedis != null){
          //  jedis.auth(PASSWORD);
        }
        return jedis;
    }

    public static void returnJedis(Jedis jedis){
        pool.returnResource(jedis);
    }



}
