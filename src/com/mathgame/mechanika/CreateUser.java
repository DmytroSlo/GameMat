package com.mathgame.mechanika;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;

public class CreateUser extends UserName{
    private String firstName;
    private String lastName;
    private int age;
    private String dateAge;
    private String eMail;
    private String password;

    public CreateUser() {}

    public CreateUser(String user, String firstName, String lastName, int age, String dateAge, String eMail, String password) {
        super(user);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateAge = dateAge;
        this.eMail = eMail;
        this.password = password;
    }

    public void createAccount(String user) throws FileNotFoundException, ParseException {
        PrintWriter save = new PrintWriter("src\\resource\\Users\\" + user + ".txt");

        nameUser();
        lNameUser();
        ageUser();
        brithDayUser();
        eMail();
        password();

        int defoult = 0;

        save.println("Imię: " + firstName +
                "\nNazwisko: " + lastName +
                "\nWiek: " + age +
                "\nData urodzenia: " + dateAge +
                "\nE-mail: " + eMail +
                "\nLogin: " + user +
                "\nPassword: " + password +
                "\nPoint: " + defoult +
                "\nLvl: " + defoult +
                "\nBestTime: " + defoult +
                "\nMoney: " + defoult);

        save.close();
        System.out.println(getInfo(user));
    }

    public String getInfo(String login){
        return "Nowy użytkownik " + login + " został stworzony!";
    }

    public void nameUser(){
        Validation validation = new Validation();

        Scanner userName = new Scanner(System.in);
        System.out.print("Wpisz swoje imię: ");
        String firstNameuser = userName.nextLine();

        firstName = validation.nameValidation(firstNameuser);
    }

    public void lNameUser() {
        Validation validation = new Validation();

        Scanner userLastName = new Scanner(System.in);
        System.out.print("Wpisz swoje nazwisko: ");
        String lastNameUser = userLastName.nextLine();

        lastName = validation.lnameValidation(lastNameUser);
    }

    public void ageUser() {
        Validation validation = new Validation();

        Scanner ageUserScan = new Scanner(System.in);
        System.out.print("Wpisz ile masz lat: ");
        int ageUser = ageUserScan.nextInt();

        age = validation.ageValidation(ageUser);
    }

    public void brithDayUser() throws ParseException {
        Validation validation = new Validation();

        Scanner ageDay = new Scanner(System.in);
        System.out.print("Wpisz date urodzenia [dd.mm.yyyy]: ");
        String ageDayUser = ageDay.nextLine();

        dateAge = validation.brithDay(ageDayUser);
    }

    public void eMail(){
        Validation validation = new Validation();

        Scanner eMailUser = new Scanner(System.in);
        System.out.print("Wpisz e-mail: ");
        String eMailuser = eMailUser.nextLine();

        eMail = validation.eMailValidation(eMailuser);
    }

    public void password(){
        Validation validation = new Validation();

        Scanner passwordUs = new Scanner(System.in);
        System.out.print("Wpisz password: ");
        String passwordUser = passwordUs.nextLine();

        password = validation.passwordValidation(passwordUser);
    }
}
