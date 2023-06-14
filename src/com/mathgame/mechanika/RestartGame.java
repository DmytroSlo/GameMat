package com.mathgame.mechanika;

import com.mathgame.Game;
import com.mathgame.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestartGame extends UserName{

    private String msg;

    public RestartGame(){
    }

    public RestartGame(String user) {
        super(user);
    }

    public String restart(String password) {
        Scanner ask = new Scanner(System.in);
        System.out.print("Chceś sprubować jeszcze raz? Y/N: ");
        String askResult = ask.nextLine();

        if (askResult.equals("Y")) {
            Game game = new Game(user, password);
            game.gameStart();
        } else{
            System.out.println("Konieć gry! Twoje danne:");
            setValues();
        }

        return msg;
    }

    public void startNewUser() {
        Scanner ask = new Scanner(System.in);
        System.out.print("Chceś sprobować zarać? Y/N: ");
        String askResult = ask.nextLine();

        if (askResult.equals("Y")) {
            Main.main(new String[]{});
        }
    }

    public void setValues() {
        File load = new File("src\\resource\\Users\\" + user + ".txt");
        Scanner userLoad = null;
        try {
            userLoad = new Scanner(load);
        } catch (FileNotFoundException e){
            System.out.println("Error RestartGame setValues: " + e);
        }

        while(userLoad.hasNextLine()){
            String result = userLoad.nextLine();
            System.out.println(result);
        }
    }

    public String getMsg() {
        return msg;
    }
}
