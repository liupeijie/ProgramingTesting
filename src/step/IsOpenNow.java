package step;

import java.util.Calendar;

/**
 * Created by liupeijie on 西暦15/06/22.
 */
public class IsOpenNow {
    public static boolean isOpenNow(){
        //Get the current time
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if(dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY)
            return false;
        return 9 <= hour && hour < 17;
    }

}
