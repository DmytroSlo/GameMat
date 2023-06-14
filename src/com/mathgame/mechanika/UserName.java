package com.mathgame.mechanika;

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

    public boolean userValidation() {
        File usersData = new File("src\\resource\\Users\\" + user + ".txt");
        if(usersData.exists()){
                result = true;
            } else{
                result = false;
            }
        return result;
    }

    public boolean passwordValidation(String passwordUser) {
        File usersData = new File("src\\resource\\Users\\" + user + ".txt");
        Scanner loadPassworld = null;
        try {
            loadPassworld = new Scanner(usersData);
        } catch (FileNotFoundException e){
            System.out.println("Error UserName Password Validation: " + e);
        }
        while (loadPassworld.hasNextLine()){
            String passwordUserLoad = loadPassworld.nextLine();
            if(passwordUserLoad.startsWith("Password: ")){
                String passUserValue = passwordUserLoad.substring("Password: ".length());
                if(passUserValue.equals(passwordUser)){
                    passwordResult = true;
                } else{
                    passwordResult = false;
                }
            }
        }
        return passwordResult;
    }

    public boolean isPasswordResult() {
        return passwordResult;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
