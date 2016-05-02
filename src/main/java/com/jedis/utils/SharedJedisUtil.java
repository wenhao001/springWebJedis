package com.jedis.utils;

import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeremy on 16/5/1.
 */
public class SharedJedisUtil {
    public static ShardedJedis createShardedJedis(){
        List<JedisShardInfo> jedisShardInfoList = new ArrayList<JedisShardInfo>();
        JedisShardInfo jedisShardInfo1 = new JedisShardInfo("192.168.1.110", 6379);
        jedisShardInfo1.setPassword("lwh1056927");
        jedisShardInfoList.add(jedisShardInfo1);

        ShardedJedis shardedJedis = new ShardedJedis(jedisShardInfoList);
        return  shardedJedis;
    }


}
