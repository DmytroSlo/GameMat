package com.mathgame.mechanika;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Point extends UserName{
    private int answer;
    private int correct;
    private int hardlvl;

    public Point() {
    }

    public Point(String user, int answer, int correct, int hardlvl) {
        super(user);
        this.answer = answer;
        this.correct = correct;
        this.hardlvl = hardlvl;
    }

    public void PointUp(String user, int answer, int correct, int hardlvl) {
        File usersData = new File("src\\resource\\Users\\" + user + ".txt");
        if (usersData.exists()) {
            int currentPoints = 0;
            //Point
                int newPointValue = switch (hardlvl) {
                    case 1 -> 1;
                    case 2 -> 2;
                    case 3 -> 3;
                    default -> 0;
                };
                Scanner loadFile = null;
                try {
                    loadFile = new Scanner(usersData);
                } catch (FileNotFoundException e){
                    System.out.println("Error Point pointUp: " + e);
                }

                StringBuilder fileContents = new StringBuilder();
                while (loadFile.hasNextLine()) {
                    String line = loadFile.nextLine();
                    if (line.startsWith("Point:")) {
                        currentPoints = Integer.parseInt(line.split(": ")[1]);
                        currentPoints += newPointValue;
                        line = "Point: " + currentPoints;
                    }
                    fileContents.append(line).append("\n");
                }
                loadFile.close();
                //Save to file User
                try {
                    FileWriter save = new FileWriter(usersData);
                    save.write((fileContents.toString()));
                    save.close();
                }catch (IOException e){
                    System.out.println("Error Point save PointUp: " + e);
                }

                System.out.println("Dostałeś " + newPointValue + " punkty. \nMaś: " + currentPoints);
        }
    }

    public void PointDown(String user, int hardlvl) {
        int currentPoints = 0;

        File usersData = new File("src\\resource\\Users\\" + user + ".txt");
        Scanner loadFile = null;
        try {
            loadFile = new Scanner(usersData);
        } catch (FileNotFoundException e){
            System.out.println("Error Point pointDown: " + e);
        }

        int newPointValue = switch (hardlvl) {
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> 3;
            default -> 0;
        };

        StringBuilder fileContents = new StringBuilder();
        while (loadFile.hasNextLine()) {
            String line = loadFile.nextLine();
            if (line.startsWith("Point:")) {
                currentPoints = Integer.parseInt(line.split(": ")[1]);
                currentPoints -= newPointValue;
                line = "Point: " + currentPoints;
            }
            fileContents.append(line).append("\n");
        }
        loadFile.close();
        //Save to file User
        try {
            FileWriter save = new FileWriter(usersData);
            save.write((fileContents.toString()));
            save.close();
        } catch (IOException e){
            System.out.println("Error Point pointDown save: " + e);
        }
        System.out.println("Straciłeś " + newPointValue + " punkty. Maś: " + currentPoints);
    }
}
