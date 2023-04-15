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
        super.user = user;
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
}
