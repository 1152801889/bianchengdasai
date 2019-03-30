package cn.com.cmbcc.utils;

import cn.com.cmbcc.techstar.Answer1;

/**
 * Created by wayne on 2018/3/17.
 */
public class MyThread extends Thread {
    private long head;
    private long last;
    private long[] result;
    private int index;

    public MyThread(long head, long last, long[] result, int index) {
        this.head = head;
        this.last = last;
        this.result = result;
        this.index = index;
    }

    @Override
    public void run() {
        long tmp = 0;
        for (long i = head+1; i <= last; i++) {
            if (Answer1.isPrimeNumber(i)) {
                tmp += i;
            }
        }
        result[index] = tmp;
    }
}
