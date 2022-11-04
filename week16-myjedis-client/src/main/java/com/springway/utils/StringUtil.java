package com.springway.utils;

import java.io.UnsupportedEncodingException;

public class StringUtil {
    public static byte[] getBytes(String str) throws UnsupportedEncodingException {
        return str.getBytes("UTF-8");
    }
}
