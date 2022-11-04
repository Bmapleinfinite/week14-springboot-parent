package com.springway;

import org.junit.Test;

import com.springway.client.Client;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     * @throws Exception
     */
    @Test
    public void MyJedisTest() throws Exception {
        Client client = new Client("114.132.70.161", 6379);
        client.auth("ZMQaishiteru1229@@");
        // client.set("test_key", "Goodbye world!");
        System.out.println(client.get("test_key"));
    }
}
