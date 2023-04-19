package com.mathgame;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Scanner imie = new Scanner(System.in);

        while (true) {
            if (name.length() >= 10) {
                System.out.print("Imię jest za dułge! Maks 10 symwolu.\nSprobój ponownie: ");
                name = imie.nextLine();
            } else if (name.matches("[a-zA-Z]")) {
                System.out.println("W imieniu znajdują się zabronione symwoły!\nSprobój ponownie: ");
                name = imie.nextLine();
            } else if (!Character.isUpperCase(name.charAt(0))) {
                System.out.println("Imię powinno zaczynać się z dużej litery!\nSprobój ponownie: ");
                name = imie.nextLine();
            } else {
                return name;
            }
        }
    }

    public String lnameValidation(String lastName){

        Scanner lImie = new Scanner(System.in);

        while(true) {
            if (lastName.length() >= 20) {
                System.out.print("Nazwisko jest za dułge! Maks 20 symwolu.\nSprobój ponownie: ");
                lastName = lImie.nextLine();
            } else if (lastName.matches("[a-zA-Z]")) {
                System.out.print("W nazwisku znajdują się zabronione symwoły!\nSprobój ponownie: ");
                lastName = lImie.nextLine();
            } else if (!Character.isUpperCase(lastName.charAt(0))) {
                System.out.print("Nazwisko powinno zaczynać się z dużej litery!\nSprobój ponownie: ");
                lastName = lImie.nextLine();
            } else {
                return lastName;
            }
        }
    }

    public int ageValidation(int age){

        Scanner ageVal = new Scanner(System.in);

        while(true) {
            if (age >= 100) {
                System.out.print("Tyle lat to napewno nie masz!\nWpisz korektny wiek: ");
                age = ageVal.nextInt();
            } else {
                return age;
            }
        }
    }

}
