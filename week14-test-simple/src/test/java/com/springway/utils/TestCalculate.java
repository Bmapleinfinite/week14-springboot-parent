package com.springway.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCalculate {
    
    private Calculate calculate;

    @Before
    public void before() {
        calculate = new Calculate();
    }

    @Test
    public void testAdd() {
        int result = calculate.add(1, 1);
        assertEquals(2, result);
    }

    // @Test(expected = ArithmeticException.class, timeout = 1000)
    @Test(timeout = 1000)
    public void testDivide() throws InterruptedException {
        // int result = calculate.divide(10, 0);

        Thread.sleep(2000);

        // assertEquals(4, result);
    }

    @After
    public void after() {
        calculate = null;
    }

}
