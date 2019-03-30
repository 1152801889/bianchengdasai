package cn.com.cmbcc.techstar;

import cn.com.cmbcc.utils.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sdway on 2018/3/17.
 */
public class Answer10 {
    private String ip;
    private String url;
    private String charset = "utf-8";
    private HttpClientUtil httpClientUtil = null;
    public Answer10(String ip) {
        this.ip = ip;
        this.url = "https://rs.creditcard.cmbc.com.cn/mbank/page/login/index.html";
        httpClientUtil = new HttpClientUtil();
    }

    public void go(){
        Map<String,String> createMap = new HashMap<String,String>();
        boolean flag = httpClientUtil.doGet(url,createMap,charset,ip);
        if (flag){
            System.out.println(ip + "服务正常");
        }else {
            System.out.println(ip + "服务不正常");
        }
    }
}
