package cn.com.cmbcc.techstar;

import java.io.*;

/**
 * Created by wayne on 2018/3/6.
 * <p>
 * 有一个长篇巨制的英文小说，小说为txt形式，大小可能超过2G。
 * Java虚拟机最大可运行内存不超过1G，请设计一个统计单词的功能。例如
 * java -jar techstar.jar 5 fileFullPath count 统计出总共包含多少个count单词
 * 注意，account, counter, e-count这些都不能作为count单词统计。
 */
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
