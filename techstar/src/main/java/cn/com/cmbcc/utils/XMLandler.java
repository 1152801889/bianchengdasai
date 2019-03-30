package cn.com.cmbcc.utils;

import java.io.*;
import java.net.Socket;

/**
 * Created by sdway on 2018/3/17.
 */
public class XMLandler {

    public static String SUCC = "AAAAAAA";
    public static String FAIL = "FFFFFFF";
    public static String CHARSET = "GB18030";
    public static int HEAD_LEN = 4;

    public static void doSomething(Socket socket) throws IOException {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        in = new BufferedInputStream(socket.getInputStream());//获取输入流
        out = new BufferedOutputStream(socket.getOutputStream());//获取输出流

        //解析輸入
        parseXML(in);
        //返回
        String returnXml = "<?xml version=\"1.0\" encoding=\"GB18030\" standalone=\"yes\"??>\n" +
                "<RESPONSE>\n" +
                " <HEAD>\n" +
                " <TRCD>CCXB</TRCD>\n" +
                " <TRDT>20180306</TRDT>\n" +
                " <TRTM>134117</TRTM>\n" +
                " <MSCOPRSEQ>14877023</MSCOPRSEQ>\n" +
                " <TRSQ>E000022</TRSQ>\n" +
                " <ERTX>动态密码验证错误</ERTX>\n" +
                " <MSCFESEQ>193455</MSCFESEQ>\n" +
                " <MSCFEDT>20170511</MSCFEDT>\n" +
                " </HEAD>\n" +
                " <BODY>\n" +
                " <CardNo>8888888888888888</CardNo>\n" +
                " <CPNO>18613818526</CPNO>\n" +
                " </BODY>\n" +
                "</RESPONSE>";
        out.write(returnXml.getBytes());
        out.flush();
        out.close();
        in.close();
    }

    //读取流式报文
    public static void parseXML(InputStream in) {
        try {
            byte[] recMsgLength = new byte[HEAD_LEN];//报文长度值
            in.read(recMsgLength);//先读4个字节(表示后续的报文长度)
            String strLen = new String(recMsgLength,CHARSET);
            System.out.println("报文长度："+strLen);
            if(strLen.equals("") || strLen == null){//报文格式错误
                System.out.println("报文格式错误");
                return;
            }
            try {
                int tmp = Integer.parseInt(strLen);
            }catch (Exception e){
                System.out.println("不为数字");
            }

            int allLength = Integer.parseInt(strLen);
            if(allLength<1){ //报文格式错误
                System.out.println("报文格式错误");
                return;
            }
            byte[] result = new byte[allLength];
            in.read(result);//读取报文
            String a = new String(result,CHARSET);
            System.out.println("报文内容:"+a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
