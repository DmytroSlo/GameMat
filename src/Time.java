import java.util.Timer;
import java.util.TimerTask;

public class Time {

    private long startTime;
    private Timer time;

    public Time() {
    }

    public Time(long startTime) {
        this.startTime = startTime;
    }

    public void TimerCheckStart (){
        time = new Timer();
        startTime = System.currentTimeMillis();
    }

    public void TimerEnd(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                long stopTime = System.currentTimeMillis();
                long result = (stopTime - startTime) / 1000;
                System.out.println("Zrobiłeś to za: " + result + " sek.");
            }
        };

        time.schedule(task, 0);
    }

    public void Cancel(){
        time.cancel();
    }
}
