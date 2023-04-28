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

        Scanner ask = new Scanner(System.in);
        System.out.println("Menu:" + "\n1: Top LVL" +
                "\n2: Top Point" + "\n3: Top Time" + "\n4: Start Game");
        String resAsk = ask.nextLine();
        TopUsers top = new TopUsers();
        Game game = new Game(user, passwordUser);

        if (resAsk.equals("1")) {
            top.userTopLvl();
            game.gameStart();
        } else if (resAsk.equals("2")) {
            top.userTopPoint();
            game.gameStart();
        } else if (resAsk.equals("3")) {
            top.userTopTime();
            game.gameStart();
        } else if(resAsk.equals("4")) {
            game.gameStart();
        }
    }
}