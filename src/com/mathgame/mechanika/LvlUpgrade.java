package com.mathgame.mechanika;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LvlUpgrade extends UserName {

    public LvlUpgrade(){}

    public LvlUpgrade(String user) {
        super.user = user;
    }

    public void lvlUp() {
        File lvlcheck = new File("src\\resource\\Users\\" + user + ".txt");
        Scanner lvl = null;
        try {
            lvl = new Scanner(lvlcheck);
        } catch (FileNotFoundException e){
            System.out.println("Error LvlUpgrade lvlUp: " + e);
        }

        StringBuilder lvlcontent = new StringBuilder();
        int lvlposition = 0;
        int pointPosition = 0;
        while (lvl.hasNextLine()) {
            String lvlUser = lvl.nextLine();
            if(lvlUser.startsWith("Point: ")){
                String pointValueString = lvlUser.substring("Point: ".length());
                pointPosition = Integer.parseInt(pointValueString);
            }
            if (lvlUser.startsWith("Lvl:")) {
                if (pointPosition < 1){
                    lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                    lvlposition = 0;
                    lvlUser = "Lvl: " + lvlposition;
                } else if(pointPosition <= 10){
                    lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                    lvlposition = 1;
                    lvlUser = "Lvl: " + lvlposition;
                } else if(pointPosition <= 20){
                    lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                    lvlposition = 2;
                    lvlUser = "Lvl: " + lvlposition;
                } else if(pointPosition <= 35){
                    lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                    lvlposition = 3;
                    lvlUser = "Lvl: " + lvlposition;
                } else if(pointPosition <= 50){
                    lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                    lvlposition = 4;
                    lvlUser = "Lvl: " + lvlposition;
                } else if(pointPosition <= 100){
                    lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                    lvlposition = 5;
                    lvlUser = "Lvl: " + lvlposition;
                } else{
                    lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                    lvlposition = 6;
                    lvlUser = "Lvl: " + lvlposition;
                }
                System.out.println("Twój lvl: " + lvlposition);
            }
            lvlcontent.append(lvlUser).append("\n");
        }
        lvl.close();

        try {
            FileWriter save = new FileWriter(lvlcheck);
            save.write(lvlcontent.toString());
            save.close();
        }catch (IOException e){
            System.out.println("Error LvlUpgrade lvlUp save: " + e);
        }
    }
}

