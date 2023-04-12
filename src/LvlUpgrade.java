import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LvlUpgrade {
    private String user;

    public LvlUpgrade(){}

    public LvlUpgrade(String user) {
        this.user = user;
    }

    public void lvlUp() throws IOException {
        File lvlcheck = new File("src\\resource\\Users\\" + user + ".txt");
        Scanner lvl = new Scanner(lvlcheck);

        StringBuilder lvlcontent = new StringBuilder();
        int lvlposition = 0;
        int pointPosition = 0;
        while (lvl.hasNextLine()) {
            String lvlUser = lvl.nextLine();
            if(lvlUser.startsWith("Point: ")){
                String pointValueString = lvlUser.substring("Point: ".length());
                pointPosition = Integer.parseInt(pointValueString);
            }
            if (lvlUser.startsWith("Lvl:")) {
                if (pointPosition < 1){
                    lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                    lvlposition = 0;
                    lvlUser = "Lvl: " + lvlposition;
                } else if(pointPosition <= 10){
                    lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                    lvlposition = 1;
                    lvlUser = "Lvl: " + lvlposition;
                } else if(pointPosition <= 20){
                    lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                    lvlposition = 2;
                    lvlUser = "Lvl: " + lvlposition;
                } else if(pointPosition <= 35){
                    lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                    lvlposition = 3;
                    lvlUser = "Lvl: " + lvlposition;
                } else if(pointPosition <= 50){
                    lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                    lvlposition = 4;
                    lvlUser = "Lvl: " + lvlposition;
                } else if(pointPosition <= 100){
                    lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                    lvlposition = 5;
                    lvlUser = "Lvl: " + lvlposition;
                } else{
                    lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                    lvlposition = 6;
                    lvlUser = "Lvl: " + lvlposition;
                }
                System.out.println("Twój lvl: " + lvlposition);
            }
            lvlcontent.append(lvlUser).append("\n");
        }
        lvl.close();

        FileWriter save = new FileWriter(lvlcheck);
        save.write(lvlcontent.toString());
        save.close();
    }
}

