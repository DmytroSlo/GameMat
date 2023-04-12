import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreateUser {

    private String firstName;
    private String lastName;
    private int age;
    private String dateAge;
    private String eMail;
    private String login;
    private String password;

    public CreateUser() {}

    public CreateUser(String firstName, String lastName, int age, String dateAge, String eMail, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateAge = dateAge;
        this.eMail = eMail;
        this.login = login;
        this.password = password;
    }

    public void createAccount() throws FileNotFoundException {
        PrintWriter save = new PrintWriter("src\\resource\\Users\\" + login + ".txt");

        int defoult = 0;
        double defoultTime = 00.00;
        int defoultLvl = 1;

        save.println("Imię: " + firstName +
                "\nNazwisko: " + lastName +
                "\nWiek: " + age +
                "\nData urodzenia: " + dateAge +
                "\nE-mail: " + eMail +
                "\nLogin: " + login +
                "\nPassword: " + password +
                "\nPoint: " + defoult +
                "\nLvl: " + defoultLvl +
                "\nBestTime: " + defoultTime +
                "\nMoney: " + defoult);

        save.close();
        System.out.println(getInfo(login));
    }

    public String getInfo(String login){
        return "Nowy użytkownik " + login + "stworzony!";
    }

}
