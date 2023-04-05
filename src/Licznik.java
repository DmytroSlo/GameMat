import java.io.*;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Licznik {
    public static void main(String[] args) throws IOException {
        //Login
        Scanner userLogin = new Scanner(System.in);
        System.out.print("Wpisz swój login: ");
        String user = userLogin.nextLine();
        //Shearch users
        File usersData = new File("src\\resource\\Users\\" + user + ".txt");
        if (usersData.exists()) {
            //LVL posium
            Scanner hard = new Scanner(System.in);
            System.out.print("Jaki chceś poziom [1, 2 ,3]?: ");
            if(hard.hasNextInt()) {
                int hardlvl = hard.nextInt();

                int correct = 0;
                Random rand = new Random();

                int num1;
                int num2;
                int operator = rand.nextInt(2);

                switch (hardlvl) {
                    case 1 -> {
                        num1 = rand.nextInt(10) + 1;
                        num2 = rand.nextInt(10) + 1;
                        MathRandom corect = new MathRandom(num1, num2, operator);
                        System.out.print(corect.Random(num1, num2, operator));
                        correct = corect.getCorrect();
                    }
                    case 2 -> {
                        num1 = rand.nextInt(30) + 1;
                        num2 = rand.nextInt(30) + 1;
                        MathRandom corect = new MathRandom(num1, num2, operator);
                        System.out.print(corect.Random(num1, num2, operator));
                        correct = corect.getCorrect();
                    }
                    case 3 -> {
                        num1 = rand.nextInt(50) + 1;
                        num2 = rand.nextInt(50) + 1;
                        MathRandom corect = new MathRandom(num1, num2, operator);
                        System.out.print(corect.Random(num1, num2, operator));
                        correct = corect.getCorrect();
                    }
                    default -> {
                        System.out.println("Złe wpisałeś");
                        return;
                    }
                }
                //Result == TRUE
                Scanner check = new Scanner(System.in);
                int answer = check.nextInt();

                //Point
                if (answer == correct) {
                    //Result == TRUE
                    Point point = new Point();
                    point.PointUp(user, answer, correct, hardlvl);

                    LvlUpgrade newLvl = new LvlUpgrade(user);
                    newLvl.lvlUp(user);

                } else {
                    //Result == FALSE
                    Point point = new Point();
                    point.PointDown(user, hardlvl);

                    LvlUpgrade newLvl = new LvlUpgrade(user);
                    newLvl.lvlUp(user);
                }
            } else{
                System.out.println("Złe wpisałeś");
            }
        } else{
            //Not found user
            Scanner createAccount = new Scanner(System.in);
            System.out.print("Nie ma takiego użytkownika. Zarejestruj się\nChcesz zarejestrować się? Y/N: ");
            String accepted = createAccount.nextLine();
            if(Objects.equals(accepted, "Y")) {
                createUser();
            } else{
                System.out.println("Konieć!");
            }
        }
    }

    //Create new users
   public static void createUser() throws FileNotFoundException {
        // Ankieta rejestracijna
        Scanner userName = new Scanner(System.in);
        System.out.print("Wpisz swoje imię: ");
        String firstNameUser = userName.nextLine();

        Scanner userLastName = new Scanner(System.in);
        System.out.print("Wpisz swoje nazwisko: ");
        String lastNameUser = userLastName.nextLine();

        Scanner age = new Scanner(System.in);
        System.out.print("Wpisz ile masz lat: ");
        int ageUser = age.nextInt();

        Scanner ageDay = new Scanner(System.in);
        System.out.print("Wpisz date urodzenia: ");
        String ageDayUser = ageDay.nextLine();

        Scanner eMail = new Scanner(System.in);
        System.out.print("Wpisz e-mail: ");
        String eMailUser = eMail.nextLine();

        Scanner login = new Scanner(System.in);
        System.out.print("Wpisz login: ");
        String loginUser = login.nextLine();

        Scanner password = new Scanner(System.in);
        System.out.print("Wpisz password: ");
        String passwordUser = password.nextLine();

        CreateUser create = new CreateUser(firstNameUser, lastNameUser, ageUser, ageDayUser,eMailUser, loginUser, passwordUser);
        create.createAccount();

    }
}