package com.jedis.utils;



import redis.clients.jedis.Jedis;

/**
 * Created by jeremy on 16/5/1.
 */
public class JedisUtil {

    public static Jedis createJedis(){
        return new Jedis("127.0.0.1");
    }

    public static Jedis createJedis(String host, int port){
        return new Jedis(host, port);
    }

    public static Jedis createJedis(String host, int port, String password){
        Jedis jedis = new Jedis(host, port);
        if (password != null && password.length() > 0){
            jedis.auth(password);
        }
        return jedis;
    }
}
