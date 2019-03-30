package cn.com.cmbcc.techstar;

import cn.com.cmbcc.utils.FileUtil;
import cn.com.cmbcc.utils.SocketListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by tinyspace on 2018/3/6.
 */
public class Answer {

    private static final Logger logger = LoggerFactory.getLogger(Answer.class);

    public static void main(String[] args) throws InterruptedException {


        if (args == null || args.length == 0) {
            System.out.println("usage cn.com.cmbcc.techstar.Answer [1-10] other params");
            return;
        }
        int num = 0;

        try {
            num = Integer.parseInt(args[0]);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        if (num <= 0 || num > 10) {
            System.out.println("first param is invalid");
            return;
        }
        switch (num) {
            case 1:
                System.out.println("verify No." + num);

                break;
            case 2:
                System.out.println("verify No." + num);
                int[] nums=new int[args.length-1];
                for (int i=1;i<args.length;i++){
                    nums[i-1]=Integer.parseInt(args[i]);
                }
                Answer2.doSomething(nums);
                break;
            case 3:
//                System.out.println("verify No." + num);
//                System.out.println("题3输出结果：");
//                Answer3.printf(args[1]);
                break;
            case 4:
                System.out.println("verify No." + num);

                break;
            case 5:
                System.out.println("verify No." + num);

                break;
            case 6:
                System.out.println("verify No." + num);

                break;
            case 7:
                System.out.println("verify No." + num);

                break;
            case 8:
                System.out.println("verify No." + num);
                //
                break;
            case 9:
                System.out.println("verify No." + num);
                //
                break;
            case 10:
                System.out.println("verify No." + num);
                //
                break;
            default:
                System.out.println("verify No." + num);
                break;

        }
    }
}
