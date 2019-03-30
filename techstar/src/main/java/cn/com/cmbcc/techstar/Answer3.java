package cn.com.cmbcc.techstar;

/**
 * Created by sdway on 2018/3/17.
 */
public class Answer3 {
    public static void printf(String str){
        int n = 0;
        try {
            n = Integer.parseInt(str);
        }catch (Exception e){
            System.out.println("第二个参数应该为小于等于20的正整数");
        }
        if (n > 20 || n <=0) {
            System.out.println("第二个参数应该为小于等于20的正整数");
        }
        if (n <= 10) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n-i+1; j++) {
                    System.out.printf(" ");
                }
                for (int j = 0; j < i*2+1; j++) {
                    System.out.print(i);
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2*n-2*i+1; j++) {
                    System.out.printf(" ");
                }
                for (int j = 0; j < i*2+1; j++) {
                    if (i<10){
                        System.out.print(i + " ");
                    } else {
                        System.out.print(i);
                    }

                }
                System.out.println();
            }
        }

    }


//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        String[] words = str.split(" ");
//        if (words.length != 2) {
//            System.out.println("参数数量不为2");
//            return;
//        }
//        int a = 0;
//        int n = 0;
//        try {
//            a = Integer.parseInt(words[0]);
//            n = Integer.parseInt(words[1]);
//        }catch (Exception e){
//            System.out.println("输入的应该是整数");
//        }
//        if (a != 3){
//            System.out.println("第一个参数应该为3");
//        }
//        if (n > 20 || n <=0) {
//            System.out.println("第二个参数应该为小于等于20的正整数");
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n-i+1; j++) {
//                System.out.printf(" ");
//            }
//            for (int j = 0; j < i*2+1; j++) {
//                System.out.print(i);
//            }
//            System.out.println();
//        }
//    }
}
