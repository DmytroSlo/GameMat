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

                int currentPoints = 0;
                //Point
                if (answer == correct) {
                    int newPointValue = switch (hardlvl) {
                        case 1 -> 1;
                        case 2 -> 2;
                        case 3 -> 3;
                        default -> 0;
                    };

                    // Edytacja
                    Scanner loadFile = new Scanner(usersData);

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
                    FileWriter save = new FileWriter(usersData);
                    save.write((fileContents.toString()));
                    save.close();

                    System.out.println("Dostałeś " + newPointValue + " punkty. Maś: " + currentPoints);

                    LvlUpgrade newLvl = new LvlUpgrade(user);

                } else {
                    //Result == FALSE
                    Scanner loadFile = new Scanner(usersData);

                    int newPointValue = 2;

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
                    FileWriter save = new FileWriter(usersData);
                    save.write((fileContents.toString()));
                    save.close();

                    System.out.println("Straciłeś " + newPointValue + " punkty. Maś: " + currentPoints);

                    LvlUpgrade newLvl = new LvlUpgrade(user);
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