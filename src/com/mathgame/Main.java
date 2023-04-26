package com.mathgame;

import com.mathgame.mechanika.*;
import com.mathgame.top.TopUsers;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        //Login
        Scanner userLogin = new Scanner(System.in);
        System.out.print("Wpisz swój login: ");
        String user = userLogin.nextLine();

        Scanner userPassword = new Scanner(System.in);
        System.out.print("Wpisz hasło: ");
        String passwordUser = userPassword.nextLine();

        TopUsers top = new TopUsers();
        top.userTopLvl();

        UserName validUser = new UserName(user);
        //Shearch users
        if (validUser.userValidation()) {
            boolean passResult = validUser.passwordValidation(passwordUser);
            if(passResult) {
                //LVL posium
                Scanner hard = new Scanner(System.in);
                System.out.print("Jaki chceś poziom [1, 2 ,3]?: ");
                if (hard.hasNextInt()) {

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
                    Time time = new Time();
                    time.TimerCheckStart();
                    RestartGame reset = new RestartGame(user);

                    Scanner check = new Scanner(System.in);
                    int answer = check.nextInt();

                    time.TimerEnd();
                    //Point
                    if (answer == correct) {
                        //Result == TRUE
                        Point point = new Point();
                        point.PointUp(user, answer, correct, hardlvl);

                        LvlUpgrade newLvl = new LvlUpgrade(user);
                        newLvl.lvlUp();

                        time.addTime(user);
                        time.Cancel();

                        reset.restart();
                    } else {
                        //Result == FALSE
                        Point point = new Point();
                        point.PointDown(user, hardlvl);

                        LvlUpgrade newLvl = new LvlUpgrade(user);
                        newLvl.lvlUp();

                        time.Cancel();
                        System.out.println("Prawidłowa odpowiedz: " + correct);

                        reset.restart();
                    }
                } else {
                    System.out.println("Złe wpisałeś");
                }
            } else{
                RestartGame reset = new RestartGame(user);
                reset.restart();
            }
        } else{
            //Not found user
            Scanner createAccount = new Scanner(System.in);
            System.out.print("Nie ma takiego użytkownika. Zarejestruj się\nChcesz zarejestrować się? Y/N: ");
            String accepted = createAccount.nextLine();
            if(Objects.equals(accepted, "Y")) {
                CreateUser create = new CreateUser();
                create.createAccount(user);

                RestartGame done = new RestartGame();
                done.startNewUser();
            } else{
                System.out.println("Konieć!");
            }
        }
    }
}