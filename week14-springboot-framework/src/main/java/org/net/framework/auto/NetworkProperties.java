package org.net.framework.auto;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 自动配置的可变参数提取的类
 */
@ConfigurationProperties(prefix = "springway.network")
public class NetworkProperties {
    // 主机名
    private String host = "loclhost";

    // 端口
    private int port = 8080;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
