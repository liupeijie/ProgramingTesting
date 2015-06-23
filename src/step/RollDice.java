package step;

/**
 * Created by liupeijie on 西暦15/06/23.
 */
public class RollDice {

    public static boolean rollDice(int count , int No){
        int i;
        int num[] = new int[count];
        double temp[] = new double[7];
        double probability[] =new double[7];
        for(i=0; i<7; ++i) {
            temp[i]=0;
        }
        for(i=0; i<count; i++) {
            num[i] = (int) (Math.random() * 6) + 1;
            if(num[i]>6 || num[i] <1)System.out.println(num);
            temp[num[i]]= temp[num[i]]+1.0;
            //System.out.println(temp[num]);
        }

        for(i=1; i<7; ++i) {
            probability[i] = (temp[i] / count) - (1.0/6.0) ;
            //System.out.println(i+":"+probability[i]);

        }

        System.out.println(count+"回Rollして、"+No+"番出る確率と1/6の差は:"+probability[No]);
        return -0.0015 < probability[No] && probability[No] < 0.0015;
    }

    //偏りを防ぐため、検証を行う
    public static boolean checkRollDice(int count , int No){
        int i ;
        int num[] = new int[count];
        double temp[] = new double[7];
        double probability[] =new double[7];
        
        for(i=0 ; i< count;i++){
            num[i] = (int) (Math.random() * 6) + 1;
            if(num[i]>6 || num[i] <1)System.out.println(num[i]);
            if(i % 2 ==0 ){
                temp[num[i]]= temp[num[i]]+1.0;
            }
        }
        count= count/2;
        for(i=1; i<7; ++i) {
            probability[i] = (temp[i] / count) - (1.0/6.0) ;
            //System.out.println(i+":"+probability[i]);
        }

        System.out.println(count*2+"回Rollして、偶数目に"+No+"番出る確率と1/6の差は:"+probability[No]);
        return -0.0015 < probability[No] && probability[No] < 0.0015;
    }
}
