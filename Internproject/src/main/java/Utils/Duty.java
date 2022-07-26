package Utils;

import java.util.ArrayList;
import java.util.Random;

public class Duty {

    void FillDuty(ArrayList<Data> list, ArrayList<Header> date) {
        Random random = new Random();
        for (int i = 0; i < list.size(); i++) {
            // for (int j = 0; j < date.size(); j++) {
            //     list.get(i).duty.add(null);
            // }
            int p = random.nextInt(list.size());
            int d = random.nextInt(date.size());
            if (list.get(p).getName() != "" && list.get(p).getNoOfDuties() < list.get(p).totalDuty
                    && date.get(d).assignendDuties < date.get(d).getNoOfInvigilators()) {
                date.get(d).increaseDuty();
                list.get(p).increaseNoOfDuites();
                list.get(p).duty.add(date.get(d).getDate());
                // System.out.println(list.get(p).getName() + list.get(p).duty);
            }
        }

    }
}
