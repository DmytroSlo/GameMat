package com.mathgame.top;

import java.awt.event.FocusAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TopUsers implements ITopUser{

    private String user;

    public TopUsers(){
    }

    public TopUsers (String user){
        this.user = user;
    }

    @Override
    public void userTopLvl() throws FileNotFoundException {
        File folder = new File("src\\resource\\Users\\");

        ArrayList<String> usersName = new ArrayList<>();

        File[] listOfFiles = folder.listFiles();

        for(File file : listOfFiles) {
            if(file.isFile() && file.getName().endsWith(".txt")){
                usersName.add(file.getName());
            }
        }

        ArrayList<Integer> lvl = new ArrayList<>();

        for(String fileName : usersName) {
            File lvlcheck = new File("src\\resource\\Users\\" + fileName);
            Scanner lvlScan = new Scanner(lvlcheck);

            while(lvlScan.hasNextLine()){
                String lvlChek = lvlScan.nextLine();
                if(lvlChek.startsWith("Lvl: ")){
                    int lvlposition = Integer.parseInt(lvlChek.split(":")[1].trim());
                    lvl.add(lvlposition);
                }
            }
        }

        Comparator<Integer> topDoun = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        lvl.sort(topDoun);

        for(int lvlShurch : lvl){
            System.out.println(lvlShurch);
        }
    }


    @Override
    public String userTopPoint() {
        return null;
    }

    @Override
    public String userTopTime() {
        return null;
    }
}




