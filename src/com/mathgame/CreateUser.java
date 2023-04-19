package com.mathgame;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

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

    public void createAccount() throws FileNotFoundException {
        PrintWriter save = new PrintWriter("src\\resource\\Users\\" + user + ".txt");

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateAge() {
        return dateAge;
    }

    public void setDateAge(String dateAge) {
        this.dateAge = dateAge;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
