package cn.com.cmbcc.techstar;

import cn.com.cmbcc.utils.SocketListener;

/**
 * Created by tinyspace on 2018/3/6.
 */
public class Answer8 {
    private int port;
    private boolean flag;

    public Answer8(int port, boolean flag) {
        this.port = port;
        this.flag = flag;
    }

    /**
     * 请在这里补充您的代码
     */
    public void startListen() {
        //开始监听，补充您的代码
        new Thread(new SocketListener(port, flag)).start();
    }
}
