package cn.com.cmbcc;

public class Main3 {

    public static void main(String[] args) {

        print(6);

    }
    public static void print(int n){//n 1~19

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1 ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <i*2+1 ; j++) {
                System.out.print(i);
            }
            for (int j = 0; j < n-i-1 ; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
