package com.springapp.biz;

import com.jedis.utils.JedisPoolUtil;
import org.springframework.stereotype.Service;

/**
 * Created by jeremy on 16/5/1.
 */
@Service
public class RedisBiz {

    public boolean add(String key, String value) {
        Long result = JedisPoolUtil.getJedis().sadd(key, value);
        return result > 0;
    }

    public String getString(String key) {
        String result = JedisPoolUtil.getJedis().s
    }
}
