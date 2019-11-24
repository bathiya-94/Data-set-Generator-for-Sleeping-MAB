package models;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<MTD> mtdList;
    private  List<MTD> activeMTDsList;

    public Network(int[] activeMTDs) {

        int[] maxTolerableDelays = new int[]{11, 7, 12, 7, 4, 9, 11, 4, 11, 7,
                5, 6, 7, 6, 12, 8, 7, 5, 9, 11,
                8, 4, 12, 6, 13, 9, 4, 5, 6, 13,
                7, 10, 13, 9, 11, 12, 7, 8, 13, 10};

        this.mtdList = new ArrayList<>();

        for (int i: maxTolerableDelays
        ) {
            MTD mtd = new MTD(i);
            this.mtdList.add(mtd);
        }

        this.activeMTDsList = new ArrayList<>();

        for (int i: activeMTDs){
            this.mtdList.get(i-1).setActive(true);
            this.mtdList.get(i-1).setDelayCounter();
            this.activeMTDsList.add(this.mtdList.get(i-1));
        }
    }

    public List<MTD> getMtdList() {
        return mtdList;
    }

    public List<MTD> getActiveMTDsList() {
        return activeMTDsList;
    }
}
