package com.mathgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RestartGame extends UserName{
    private String result;

    public RestartGame(){
    }

    public RestartGame(String user) {
        super(user);
    }

    public void restart() throws IOException {
        Scanner ask = new Scanner(System.in);
        System.out.print("Chceś sprubować jeszcze raz? Y/N: ");
        String askResult = ask.nextLine();

        if (askResult.equals("Y")) {
            Main.main(new String[]{});
        } else{
            System.out.println("Konieć gry! Twoje danne:");
            setValues();
        }
    }

    public void startNewUser() throws IOException{
        Scanner ask = new Scanner(System.in);
        System.out.print("Chceś sprobować zarać? Y/N: ");
        String askResult = ask.nextLine();

        if (askResult.equals("Y")) {
            Main.main(new String[]{});
        }
    }

    public void setValues() throws FileNotFoundException {
        File load = new File("src\\resource\\Users\\" + user + ".txt");
        Scanner userLoad = new Scanner(load);

        while(userLoad.hasNextLine()){
            String userData = userLoad.nextLine();
            result = userData;
            System.out.println(result);
        }
    }
}
