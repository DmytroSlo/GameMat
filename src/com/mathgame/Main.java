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
        System.out.print("Chcesz sprawdzić kto ma największy LVL?: [Y/N]");
        String resAsk = ask.nextLine();
        if(resAsk.equals("Y")) {
            TopUsers top = new TopUsers();
            top.userTopLvl();
        }

        Game game = new Game(user, passwordUser);
        game.gameStart();
    }
}