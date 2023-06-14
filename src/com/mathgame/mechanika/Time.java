package com.mathgame.mechanika;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Time extends UserName{

    private long startTime;
    private Timer time;
    private long result;


    public Time() {
    }

    public Time(String user, long startTime) {
        super(user);
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
                result = (stopTime - startTime) / 1000;
                System.out.println("Zrobiłeś to za: " + result + " sek.");
            }
        };

        time.schedule(task, 0);
    }

    public void Cancel(){
        time.cancel();
    }

    public long getResult() {
        return result;
    }

    public void addTime(String user) {
        File timeCheck = new File("src\\resource\\Users\\" + user + ".txt");
        Scanner timer = null;
        try {
            timer = new Scanner(timeCheck);
        } catch (FileNotFoundException e){
            System.out.println("Error Time addTime: " + e);
        }
        long timePosition = 0;
        long timePositionEdit = getResult();
        StringBuilder timerConnect = new StringBuilder();

        while(timer.hasNextLine()){
            String timeUser = timer.nextLine();
            if(timeUser.startsWith("BestTime: ")){
                String timeValueString = timeUser.substring("BestTime: ".length());
                timePosition = Long.parseLong(timeValueString);
            }
            if(timeUser.startsWith("BestTime: ")){
                if(timePosition == 0){
                    timePositionEdit = Long.parseLong(timeUser.split(":")[1].trim());
                    timePositionEdit = getResult();
                    timeUser = "BestTime: " + timePositionEdit;
                    System.out.println("Twój nowy rekord: " + timePositionEdit + " sek.");
                }else if(timePosition > timePositionEdit){
                    timePositionEdit = Long.parseLong(timeUser.split(":")[1].trim());
                    timePositionEdit = getResult();
                    timeUser = "BestTime: " + timePositionEdit;
                    System.out.println("Twój nowy rekord: " + timePositionEdit + " sek.");
                }else{
                    timeUser = "BestTime: " + timePosition;
                }
            }
            timerConnect.append(timeUser).append("\n");
        }
        timer.close();

        try {
            FileWriter save = new FileWriter(timeCheck);
            save.write(timerConnect.toString());
            save.close();
        } catch(IOException e){
            System.out.println("Error Time Save: " + e);
        }
    }
}