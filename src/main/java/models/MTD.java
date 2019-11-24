package models;

import org.decimal4j.util.DoubleRounder;

import java.util.Random;

public class MTD {
    private  int maxTolerableDelay;
    private  int delayCounter;
    private  double activationProbability;
    private  boolean isActive;

    public MTD(int maxTolerableDelay) {
        this.maxTolerableDelay = maxTolerableDelay;
        this.isActive = false;
        setActivationProbability();
    }

    public void setActivationProbability() {
        Random r = new Random();
        if (this.isActive){

            this.activationProbability = DoubleRounder.round( (0.600 + r.nextDouble() *(0.900 -0.600)),3);
        }
        else {
            this.activationProbability = DoubleRounder.round( ( r.nextDouble() *0.5999),3);
        }
    }

    public void setActive(boolean active) {
        isActive = active;
        setActivationProbability();
    }

    public  void  reduceDelayCounter(){
        if (this.delayCounter !=0){
            this.delayCounter = this.delayCounter -1;
        }
    }

    public void setDelayCounter(){
        this.delayCounter = this.maxTolerableDelay;
    }

    public int getMaxTolerableDelay() {
        return maxTolerableDelay;
    }

    public int getDelayCounter() {
        return delayCounter;
    }

    public double getActivationProbability() {
        return activationProbability;
    }

    public boolean isActive() {
        return isActive;
    }
}
