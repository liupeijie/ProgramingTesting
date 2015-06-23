package step;

/**
 * Created by liupeijie on 西暦15/06/23.
 */
public class RollDice {

    public static boolean rollDice(int count , int No){
        int num,i;
        double temp[] = new double[7];
        double probability[] =new double[7];
        for(i=0; i<7; ++i) {
            temp[i]=0;
        }
        for(i=0; i<count; i++) {
            num = (int) (Math.random() * 6) + 1;
            if(num>6 || num <1)System.out.println(num);
            temp[num]= temp[num]+1.0;
            //System.out.println(num);
            //System.out.println(temp[num]);
        }
        for(i=1; i<7; ++i) {
            probability[i] = (temp[i] / count) - (1.0/6.0) ;
            //System.out.println(i+":"+probability[i]);

        }
        System.out.println(count+"回Rollして、"+No+"番出る確率と1/6の差は:"+probability[No]);
        return -0.0015 < probability[No] && probability[No] < 0.0015;
    }
}
