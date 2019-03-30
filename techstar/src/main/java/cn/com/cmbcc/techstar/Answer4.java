package cn.com.cmbcc.techstar;

/**
 * Created by Lenovo on 2018/3/17.
 */
public class Answer4 {

    public static void main(String[]args){

        getResult("AA");
    }

    public static void getResult(String str){
        long result=0;
        char[] chs=str.toCharArray();
        for (int i = chs.length-1; i >= 0 ; i--) {
            if (!Character.isUpperCase(chs[i])){//不是大写
                System.out.println("输入不正确");
                return;
            }else{
                if (chs[i]=='X'){//是大写的X
                    System.out.println("输入不正确");
                    return;
                }
            }
            if (chs[i]=='Z'){
                result+=0;
            } else if (chs[i]=='Y'){
                result+=get(1,chs.length-i-1);
            }else{
                result+=get('Z'-chs[i]-1,chs.length-i-1);
            }
        }
        System.out.println(result);
    }
    public static long get(int num, int index){
        if (num==0){
            return 0;
        }else if (index==0){
            return num;
        }else {
            int tmp=1;
            for (int i = 1; i <=index ; i++) {
                tmp*=25;
            }
            return num*tmp;
        }
    }


}
