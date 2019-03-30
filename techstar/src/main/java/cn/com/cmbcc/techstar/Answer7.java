package cn.com.cmbcc.techstar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * Created by tinyspace on 2018/3/6.
 */
public class Answer7 {
    public static void doSomething() {

        String srcPath = null;
        String desPath = null;
        File srcFile = null;
        File desfile = null;
        FileInputStream fileInputStream = null;
        GZIPInputStream gzipInputStream = null;

        try {
            for (int i = 1; i < 6; i++) {
                srcPath = "src/main/data/Q7/" + i + "-sec.png";
                srcFile = new File(srcPath);
                fileInputStream = new FileInputStream(srcFile);
                gzipInputStream = new GZIPInputStream(fileInputStream);

                desPath = "src/main/data/Q7/" + i + ".png";
                desfile = new File(desPath);
                if (!desfile.exists()) {
                    desfile.createNewFile();//创建文件
                }
                //写入头四个字节
                FileOutputStream fileOutputStream = new FileOutputStream(desfile);
                byte[] header = toBytes("89504E47");
                fileOutputStream.write(header);

                //写入读到的文件数据
                byte[] b = new byte[512];
                int num = 0;
                while ((num = gzipInputStream.read(b)) > 0) {
                    fileOutputStream.write(b, 0, Math.min(num, 512));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (gzipInputStream != null) {
                try {
                    gzipInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(toBytes("89")));
//    }

    public static byte[] toBytes(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }
}
