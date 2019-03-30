package cn.com.cmbcc.techstar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wayne on 2018/3/6.
 */
public class Answer9 {
    public static void doSomething(String str) throws IOException {
        //String str = "82520";
        List<String> result = new ArrayList<String>();
        File file = new File("./src/main/data/Q9/used.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader read = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = null;
        while ((line = read.readLine()) != null) {
            if (str.indexOf("*") != -1) {
                for (int i = 0; i < 10; i++) {
                    if (line.indexOf(str.replace("*", String.valueOf(i))) != -1) {
                        result.add(line);
                        if (result.size() == 30) {
                            System.out.println(result.toString());
                            return;
                        }
                    }
                }
            } else {
                if (line.indexOf(str) != -1) {
                    result.add(line);
                    if (result.size() == 30) {
                        System.out.println(result.toString());
                        return;
                    }
                }
            }
        }
        if (result.size() > 0) {
            System.out.println(result.toString());
        } else {
            System.out.println("提示：没找到！");
        }
    }
}
