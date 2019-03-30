package cn.com.cmbcc.utils;

import java.io.BufferedInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sdway on 2018/3/17.
 */
public class SocketListener implements Runnable {
    private int port;//默认端口
    private boolean flag;

    public SocketListener(int port, boolean flag) {
        this.port = port;
        this.flag = flag;
    }

    private ServerSocket serverSocket = null;

    @Override
    public void run() {
        try {
            //监听服务器端口，一旦有数据发送过来，那么就将数据封装成socket对象;
            //如果没有数据发送过来，那么这时处于线程阻塞状态，不会向下继续执行
            serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

            while (true) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();//侦听并接受到此套接字的连接
                    XMLandler.doSomething(socket);
                    if (!flag) {
                        socket.close();
                        return;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

    }

}
