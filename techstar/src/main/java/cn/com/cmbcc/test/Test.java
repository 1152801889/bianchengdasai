package cn.com.cmbcc.test;

import java.io.*;
import java.net.Socket;

/**
 * Created by sdway on 2018/3/17.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Socket so= new Socket("127.0.0.1", 8088);

        //获取socket流中的输出流
        OutputStream out=so.getOutputStream();

        //使用输出流将指定的输入写出去
        out.write("0007aaaaaa\n5".getBytes());

        //读取服务端返回的数据，使用socket读取流
        InputStream in=so.getInputStream();
//        in.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String text;
        while ((text=br.readLine())!=null){
            System.out.println(text);
        }

//        text=br.readLine();
//        System.out.println(text);


        so.close();

    }
}

