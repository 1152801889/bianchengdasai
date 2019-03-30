package cn.com.cmbcc.techstar;

import cn.com.cmbcc.utils.MyThread;

public class Answer1 {

    public static long[] result = new long[10];

    public static void doSomething() throws InterruptedException {
        long single = 1000000 / 10;
        long start = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                MyThread thread1 = new MyThread(start, 1000000, result, i);
                thread1.start();
                thread1.join();
            } else {
                MyThread thread2 = new MyThread(start, start + single, result, i);
                thread2.start();
                thread2.join();
            }
            start = start + single;
        }
        //Thread.sleep(10000);
        long end = 0;
        for (int i = 0; i < 10; i++) {
            end += result[i];
        }
        System.out.println(end);
    }

    //num从4开始
    public static boolean isPrimeNumber(Long num) {

        if (num == 1) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
