import models.MTD;
import models.Network;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static  void main(String[] args) throws IOException {

        final int NO_OF_ACTIVE_DEVICES_PER_TIME_STEP =10;
        final  int  NO_OF_TIME_STEPS = 100000;

        // Creating the network with active mtds at first time step
        Network network = new Network(new int[]{1, 2, 3, 4 , 5,6,7,8,9,10});

        // Getting active and total mtd list
        List<MTD> mtdList = network.getMtdList();
        List<MTD> activeMTDList = network.getActiveMTDsList();


        //CSV writers
        FileWriter delayCSVWriter = new FileWriter("maximumTolerableDelays.csv");
        FileWriter availabilityCSVWriter = new FileWriter("availability.csv");

        // Generate Headers
        generateHeaders(delayCSVWriter ,mtdList.size());
        generateHeaders(availabilityCSVWriter ,mtdList.size());

        // Main Time Step loop
        for (int time = 0 ; time <NO_OF_TIME_STEPS ; time ++) {

            //Create variable list
            List<String> delaysList = new ArrayList<>();
            List<String> activeProbabilityList = new ArrayList<>();


            int noOfActiveMTDs= activeMTDList.size();
            int noOfMTDsNeeded = NO_OF_ACTIVE_DEVICES_PER_TIME_STEP- noOfActiveMTDs;

            // Changing the active MTDs
            while (noOfMTDsNeeded !=0){
                Random index = new Random();
                int n =  index.nextInt(39);

                MTD selectedMTD = mtdList.get(n);

                if (!activeMTDList.contains(selectedMTD)){
                    selectedMTD.setActive(true);
                    selectedMTD.setDelayCounter();
                    activeMTDList.add(selectedMTD);
                    noOfMTDsNeeded--;
                }

            }


            // Writing data
            for (MTD mtd : mtdList){

                delaysList.add(String.valueOf(mtd.getDelayCounter()));
                activeProbabilityList.add(String.valueOf(mtd.getActivationProbability()));
                mtd.setActivationProbability();
                mtd.reduceDelayCounter();

                if (mtd.getDelayCounter()==0 && mtd.isActive()){
                    mtd.setActive(false);
                    activeMTDList.remove(mtd);
                }
            }

            availabilityCSVWriter.append(String.join(",",activeProbabilityList));
            availabilityCSVWriter.append("\n");

            delayCSVWriter.append(String.join(",", delaysList));
            delayCSVWriter.append("\n");

            if (time ==0){
                System.out.println("WSN Simulator Starting....!");
                System.out.println("Simulating Network......Please Wait !");
            }
        }

        delayCSVWriter.flush();
        delayCSVWriter.close();

        availabilityCSVWriter.flush();
        availabilityCSVWriter.close();

        System.out.println("Simulating Done.....Refer the relevant CSV files !");

    }

    private static  void generateHeaders(FileWriter csvWriter ,int size) throws IOException {

        int i ;
        for (i =0; i < size-1; i++){
            csvWriter.append("MTD").append(Integer.toString(i+1)).append(",");
        }
        csvWriter.append("MTD").append(Integer.toString(size));
        csvWriter.append("\n");
    }

}
