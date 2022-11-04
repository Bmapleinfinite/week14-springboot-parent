package com.springway.conn;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.springway.constants.Command;
import com.springway.protocol.Protocol;

public class Connection {
    // 主机名字
    private String host;
    // 端口号
    private int port;
    // 操作传输对象的
    private Socket socket;
    // 输入流
    private InputStream in;
    // 输出流
    private OutputStream out;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void sendCommand(Command command, byte[]... args) throws Exception {
        connect();
        Protocol.sendCommand(out, command, args);
    }

    private void connect() throws Exception {
        if(!this.isConnected()){
            socket = new Socket(this.host, this.port);
            out = socket.getOutputStream();
            in = socket.getInputStream();
        }
    }

    public String getResult() throws Exception {
        byte[] buf = new byte[8192];
        int read = in.read(buf);
        //获取服务器返回的这个数据
        String result = new String(buf, 0, read);
        return result;
    }

    public boolean isConnected() {
        return this.socket != null && this.socket.isBound() && !this.socket.isClosed() && this.socket.isConnected()
                && !this.socket.isInputShutdown() && !this.socket.isOutputShutdown();
    }
}
