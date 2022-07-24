package Utils;

import java.util.ArrayList;
import java.util.Random;

public class Duty {

    int SumOfList(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum++;
        }
        return sum;
    }

    void FillDuty(ArrayList<Data> list, ArrayList<Header> date) {
        Random random = new Random();
        int cnt=0;
        for (int i = 0; i < list.size() / 2; i++) {
            
            int p = random.nextInt(list.size());
            int d = random.nextInt(date.size());
            if (list.get(p).duty.size() < list.get(p).totalDuty && date.get(d).assignendDuties < date.get(d).getNoOfInvigilators()) {
                date.get(d).increaseDuty();
                list.get(p).duty.set(cnt,date.get(d).getDate());
            } else {
                list.get(p).duty.set(cnt,date.get(d).getDate());
            }
            cnt++;
        }

    }
}
