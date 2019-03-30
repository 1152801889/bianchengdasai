package cn.com.cmbcc.techstar;

import java.io.*;

public class Answer5 {

    public static long doSomething(String load, String word) throws IOException {
        long count = 0;
        File file = new File(load);
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "utf-8"), 5 * 1024 * 1024);// 用5M的缓冲读取文本文件

        String line = "";
        while ((line = reader.readLine()) != null) {
            //TODO: write your business
            line = line.replace(",", " ").replace(".", " ").replace("\"", " ").replace("“", " ").replace("”", " ").replace(";", " ");
            String[] slist = line.split(" ");
            for (int i = 0; i < slist.length; i++) {
                if (slist[i].equals(word)) {
                    count++;
                }
            }
        }
        return count;
        //System.out.println("单次count出现的数量：" + count);
    }
}
