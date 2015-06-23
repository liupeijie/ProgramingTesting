package step;

import java.util.Calendar;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Created by liupeijie on 西暦15/06/22.
 * 営業時間
 * ・日にちがバラバラ　木金or1;11;21;31営業しないとか
 * ・昼夜別々　　ｘ〜ｙ　ｚ〜ｐ
 * ・夜23〜1営業　ーー23〜24　24〜1
 * ・祝日認識　if 祝日　false
 * ・6月の第3週とか
 *
 */


public class IsOpenNow {

    public static boolean isOpenNow(int dayOfWeek, int hour){

        if(dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY)
            return false;
        return 9 <= hour && hour < 17;
    }

    public static boolean fileOpen(){
        try{
            File file = new File("/Users/liupeijie/kadai4/src/step/opentime.txt");
            FileReader filereader = new FileReader(file);

            int ch;
            while((ch = filereader.read()) != -1){
                System.out.print((char)ch);
                //return ch;
            }


            filereader.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
        int i=1;
        return i==1;

    }

    public static boolean isOpenNow(){
        //Get the current time
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return isOpenNow(dayOfWeek, hour);
    }

}
