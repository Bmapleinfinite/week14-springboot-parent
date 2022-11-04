package com.springway.client;

import com.springway.conn.Connection;
import com.springway.constants.Command;
import com.springway.exception.RedisException;
import com.springway.utils.StringUtil;

public class Client {
    private Connection connection;

    public Client(String host, int port) {
        this.connection = new Connection(host, port);
    }
    
    public void set(String key, String val) throws Exception {
        connection.sendCommand(Command.SET, StringUtil.getBytes(key), StringUtil.getBytes(val));
    }

    public String get(String key) throws Exception {
        connection.sendCommand(Command.GET, StringUtil.getBytes(key));
        return connection.getResult();
    }

    public String ttl(String key) throws Exception {
        connection.sendCommand(Command.TTL, StringUtil.getBytes(key));
        return connection.getResult();
    }

    public boolean auth(String password) throws Exception {
        connection.sendCommand(Command.AUTH, StringUtil.getBytes(password));
        if(connection.getResult().contains("OK")){
            return true;
        }else{
            throw new RedisException("AccessDenied: Bad Authentication.");
        }
    }
}
