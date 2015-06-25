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

    public static boolean isOpenNow() {
        //get the time now
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return isOpenNow(dayOfWeek, hour);
    }

    public static boolean isOpenNow(int dayOfWeek, int hour){
        try{
            //file name
            File file = new File("/Users/liupeijie/kadai4/src/step/opentime.txt");

            if (checkBeforeReadFile(file)){ //check if file exit
                BufferedReader br = new BufferedReader(new FileReader(file));
                String str[] = new String[100];
                int i=0;
                while((str[i] = br.readLine()) != null){   //read contant of fil
                     i++;
                }
                int close[]; int open[];
                open = openHour(str);
                close = close(str);
                for(i=0;close[i]!=0;i++) {
                    if (dayOfWeek == close[i])  //check close day
                        return false;
                }
                for(i=0;open[i]!=0;i=i+2) {
                    if(open[i] > open[i+1]){
                        if(open[i] <= hour && hour <= 24)return true;
                        if(0 <= hour && hour < open[i+1])return true;
                    }
                    if(open[i] <= hour && hour < open[i+1])return true;  //check open time
                }
           }else{
                System.out.println("ファイルが見つからないか開けません");
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
        return false;
    }

    private static boolean checkBeforeReadFile(File file){
        if (file.exists()){
            if (file.isFile() && file.canRead()){
                return true;
            }
        }
        return false;
    }

    //営業日の営業時間の出力
    public static int[] openHour(String str[]) {
        int i, k = 0;
        int openHour[] = new int[6];
        for(i= 0;i < 6;i++){
            openHour[i]=0;
        }
        for (i = 0; str[i] != null; i++) {
            if (str[i].equals("open time")) {
                int raw = i + 1;
                System.out.println("open from");
                while (str[raw].compareToIgnoreCase("close day") != 0) {
                    openHour[k] = Integer.parseInt(str[raw]);
                    System.out.println(openHour[k]);
                    k++;
                    raw++;
                }
            }
        }
        return openHour;
    }

    //閉店日の出力
    public static int[] close(String str[]){
        int i;
        int closeDayOfWeek[];
        int closeDay[] = new int[8];
        for(i= 0;i < 8;i++){
            closeDay[i]=0;
        }
        for(i =0;  str[i] != null;i++){
            if(str[i].equals("close day")){
                System.out.println("close at these days:");
                int raw = i+1;
                int day = 0;
                int q =0;
                while (str[raw]!=null) {
                    closeDayOfWeek = changeDays(str[raw]);
                    for(day=0;closeDayOfWeek[day]!=0;day++) {
                        closeDay[q]=closeDayOfWeek[day];
                        System.out.println(closeDay[q]);
                        q++;
                    }
                    raw++;
                }
            }
        }
        return closeDay;
    }


    //テキストの閉店日の情報を数字に変換
    public static int[] changeDays(String str){
        int closeDayOfWeek[] = new int[8];
        int i;
        for(i=0;i<8;i++){
            closeDayOfWeek[i]=0;
        }
        if (str.equals("Sunday")) {
            closeDayOfWeek[0] = 1;

        } else if (str.equals("Monday")) {
            closeDayOfWeek[0] = 2;

        } else if (str.equals("Tuesday")) {
            closeDayOfWeek[0] = 3;

        } else if (str.equals("Wednesday")) {
            closeDayOfWeek[0] = 4;

        } else if (str.equals("Thursday")) {
            closeDayOfWeek[0] = 5;

        } else if (str.equals("Friday")) {
            closeDayOfWeek[0] = 6;

        }
        else if (str.equals("Saturday")) {
            closeDayOfWeek[0] = 7;

        }else if (str.equals("Weekend")) {
            closeDayOfWeek[0] = 7;
            closeDayOfWeek[1] = 1;

        }else if (str.equals("Weekday")) {
            closeDayOfWeek[0] = 2;
            closeDayOfWeek[1] = 3;
            closeDayOfWeek[2] = 4;
            closeDayOfWeek[3] = 5;
            closeDayOfWeek[4] = 6;
        }

            return closeDayOfWeek;

    }

}
