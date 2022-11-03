package org.net.framework.core;

public class NetworkService {
    // 主机名
    private String host;

    // 端口
    private int port;

    public NetworkService(String host, int port){
        this.host = host;
        this.port = port;
    }

    public void print(){
        System.out.println("host: " + host + ", port: " + port);
    }
}
