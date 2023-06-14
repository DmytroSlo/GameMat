package com.mathgame;

import com.mathgame.mechanika.*;
import com.mathgame.top.TopUsers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Login
        Scanner userLogin = new Scanner(System.in);
        System.out.print("Wpisz swój login: ");
        String user = userLogin.nextLine();

        Scanner userPassword = new Scanner(System.in);
        System.out.print("Wpisz hasło: ");
        String passwordUser = userPassword.nextLine();

        UserName validUser = new UserName(user);
        //Shearch users
        if (validUser.userValidation()) {
            boolean passResult = validUser.passwordValidation(passwordUser);
            if (passResult) {

                Scanner ask = new Scanner(System.in);

                String menu = "Menu:" + "\n1: Top LVL" +
                        "\n2: Top Point" + "\n3: Top Time" + "\n4: Start Game";
                System.out.println(menu);
                String resAsk = ask.nextLine();
                TopUsers top = new TopUsers();
                Game game = new Game(user, passwordUser);

                while (true) {
                    if (resAsk.equals("1")) {
                        top.userTopLvl();
                        System.out.println(menu);
                        resAsk = ask.nextLine();
                    } else if (resAsk.equals("2")) {
                        top.userTopPoint();
                        System.out.println(menu);
                        resAsk = ask.nextLine();
                    } else if (resAsk.equals("3")) {
                        top.userTopTime();
                        System.out.println(menu);
                        resAsk = ask.nextLine();
                    } else {
                        game.gameStart();
                        break;
                    }
                }
            } else {
                System.out.println("Złę wpisałeś hasło!");
            }
        } else{
            //Not found user
            Scanner createAccount = new Scanner(System.in);
            System.out.print("Nie ma takiego użytkownika. Zarejestruj się\nChcesz zarejestrować się? Y/N: ");
            String accepted = createAccount.nextLine();
            if (Objects.equals(accepted, "Y")) {
                CreateUser create = new CreateUser();
                create.createAccount(user);

                RestartGame done = new RestartGame();
                done.startNewUser();
            } else {
                System.out.println("Konieć!");
            }
        }
    }
}