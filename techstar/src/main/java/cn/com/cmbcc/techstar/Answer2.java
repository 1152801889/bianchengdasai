package cn.com.cmbcc.techstar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Answer2 {
    static long CONST_WEEK = 3600 * 1000 * 24 * 7;

    public static int doSomething(String strBefore, String strAfter) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar before = Calendar.getInstance();
        Calendar after = Calendar.getInstance();
        before.setTime(sdf.parse(strBefore));
        after.setTime(sdf.parse(strAfter));
        int week = before.get(Calendar.DAY_OF_WEEK);
        before.add(Calendar.DATE, -week);
        week = after.get(Calendar.DAY_OF_WEEK);
        after.add(Calendar.DATE, 7 - week);
        int interval = (int) ((after.getTimeInMillis() - before
                .getTimeInMillis()) / CONST_WEEK);
        interval = interval - 1;
        return interval;
    }
}
