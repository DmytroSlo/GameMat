package com.mathgame;

import java.util.Scanner;

public class Validation {
    private String name;
    private String lastName;
    private int age;
    private String brithDat;
    private String eMail;
    private String password;

    public Validation(){}

    public Validation(String name, String lastName, int age, String brithDat, String eMail, String password) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.brithDat = brithDat;
        this.eMail = eMail;
        this.password = password;
    }

    public String nameValidation (String name){

        String userValid = "";

        if(name.length() >= 10){
            Scanner imie = new Scanner(System.in);
            System.out.print("Imię jest za dułge! Maks 10 symwolu.\nSprobój ponownie: ");
            userValid = imie.nextLine();
            nameValidation(userValid);
        }
        if(name.matches("[a-zA-Z]")){
            Scanner imie = new Scanner(System.in);
            System.out.println("W imieniu znajdują się zabronione symwoły!\nSprobój ponownie: ");
            userValid = imie.nextLine();
            nameValidation(userValid);
        }
        if(!Character.isUpperCase(name.charAt(0))){
            Scanner imie = new Scanner(System.in);
            System.out.println("Imię powinno zaczynać się z dużej litery!\nSprobój ponownie: ");
            userValid = imie.nextLine();
            nameValidation(userValid);
        }

        return userValid;
    }

}
