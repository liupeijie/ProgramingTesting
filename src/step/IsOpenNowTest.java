package step;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by liupeijie on 西暦15/06/22.
 * open time
 * from　第2,4,6行　to 第3,5,7行　営業
 * close time
 * 閉店曜日記入　weekday weekend も可
 */
public class IsOpenNowTest {
    @Test
    public void testisOpenNow(){
        assertTrue(IsOpenNow.isOpenNow(2, 3));
        assertFalse(IsOpenNow.isOpenNow(Calendar.FRIDAY, 8));
    }
}