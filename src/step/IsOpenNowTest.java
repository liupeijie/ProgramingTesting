package step;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by liupeijie on 西暦15/06/22.
 */
public class IsOpenNowTest {
    @Test
    public void testisOpenNow(){
        assertTrue(IsOpenNow.isOpenNow(2, 9));
        //assertFalse(IsOpenNow.isOpenNow(Calendar.MONDAY, 8));
        //assertTrue(IsOpenNow.fileOpen(2,10));
    }
}