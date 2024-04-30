package Zoo.Creature;

public class Slept {
    public int cntSleep;
    public int sleepDuration;
    public int timeSleeping;

    public Slept(int cntSleep,int sleepDuration) {
        this.cntSleep = cntSleep;
        this.sleepDuration = sleepDuration;
        this.timeSleeping = 0;
    }

    public int getTimeSleeping() {
        return timeSleeping;
    }

    public int getSleepDuration() {
        return sleepDuration;
    }

    public int getCntSleep() {
        return cntSleep;
    }

    public void setCntSleep(int cntSleep) {
        this.cntSleep = cntSleep;
    }

    public void setTimeSleeping(int timeSleeping) {
        this.timeSleeping = timeSleeping;
    }

    public void setSleepDuration(int sleepDuration) {
        this.sleepDuration = sleepDuration;
    }
}
