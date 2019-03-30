package cn.com.cmbcc.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdway on 2018/3/17.
 */
public class FileUtil {
    public static List<String> read(File file){
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line=br.readLine())!=null){
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
