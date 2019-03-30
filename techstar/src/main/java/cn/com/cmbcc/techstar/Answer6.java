package cn.com.cmbcc.techstar;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Answer6 {


//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        String[] words = str.split(" ");
//        if (words.length != 2) {
//            System.out.println("参数数量不为2");
//            return;
//        }
//        int a = 0;
//        try {
//            a = Integer.parseInt(words[0]);
//        } catch (Exception e) {
//            System.out.println("输入的第一个参数应该是整数");
//        }
//        if (a != 6) {
//            System.out.println("第一个参数应该为6");
//        }
//
//        File file = new File(words[1]);
//        System.out.println(folders(file));
//    }

    public static long folders(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                long size = 0;
                for (File f : children) {
                    size += folders(f);

                }
                return size;
            } else {
                long size = file.length();
                return size;
            }
        } else {
            System.out.println("no exist");
            return 0;
        }
    }

}
