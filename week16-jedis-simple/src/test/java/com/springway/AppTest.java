package com.springway;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    private static final String HOST = "114.132.70.161";
    private static final Integer PORT = 6379;
    
    @Test
    public void testJedis() {
        Jedis jedis = new Jedis(HOST, PORT);
        jedis.auth("ZMQaishiteru1229@@");
        jedis.set("test_key", "hello world");
        jedis.close();
    }

    @Test
    public void testJedisPool() {
        JedisPool jedisPool = new JedisPool(HOST, PORT);
        Jedis jedis = jedisPool.getResource();
        jedis.auth("ZMQaishiteru1229@@");
        System.out.println(jedis.get("test_key"));
    }
}
