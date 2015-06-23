package step;

import java.util.Calendar;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
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

    public static String fileOpen(){
        try{
            File file = new File("/Users/liupeijie/kadai4/src/step/opentime.txt");

            if (checkBeforeReadFile(file)){
                BufferedReader br = new BufferedReader(new FileReader(file));

                String str[] = new String[100];
                int i=0;
                while((str[i] = br.readLine()) != null){
                    System.out.println(i+1+"行目：");
                    System.out.println(str[i]);
                    i++;
                    return str[i];
                }

                br.close();
            }else{
                System.out.println("ファイルが見つからないか開けません");
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
        return "";
    }

    private static boolean checkBeforeReadFile(File file){
        if (file.exists()){
            if (file.isFile() && file.canRead()){
                return true;
            }
        }

        return false;
    }

    public static boolean isOpenNow(){
        //Get the current time
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return isOpenNow(dayOfWeek, hour);
    }

}
