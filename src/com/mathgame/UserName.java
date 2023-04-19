package com.mathgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserName {
    protected String user;
    private String passwordUser;
    private boolean passwordResult;
    private boolean result;


    public UserName(){};

    public UserName(String user){
        this.user = user;
    }

    public boolean userValidation() throws FileNotFoundException {
        File usersData = new File("src\\resource\\Users\\" + user + ".txt");
        if(usersData.exists()){
                result = true;
            } else{
                result = false;
            }
        return result;
    }

    public boolean passwordValidation(String passwordUser) throws FileNotFoundException {
        File usersData = new File("src\\resource\\Users\\" + user + ".txt");
        Scanner loadPassworld = new Scanner(usersData);
        while (loadPassworld.hasNextLine()){
            String passwordUserLoad = loadPassworld.nextLine();
            if(passwordUserLoad.startsWith("Password: ")){
                String passUserValue = passwordUserLoad.substring("Password: ".length());
                if(passUserValue.equals(passwordUser)){
                    passwordResult = true;
                } else{
                    System.out.println("Złe wpisałeś hasło!");
                    passwordResult = false;
                }
            }
        }
        return passwordResult;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
