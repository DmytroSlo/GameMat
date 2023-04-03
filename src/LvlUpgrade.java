import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LvlUpgrade {
    private String user;

    public LvlUpgrade(){}

    public LvlUpgrade(String user){
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void lvlUp(String user) throws IOException {
        File lvlcheck = new File("src\\resource\\Users\\" + user + ".txt");
        Scanner lvl = new Scanner(lvlcheck);

        StringBuilder lvlcontent = new StringBuilder();
        int lvlposition = 0;
        int pointPosition = 0;
        while (lvl.hasNextLine()) {
            String lvlUser = lvl.nextLine();
            if(lvlUser.startsWith("Point: ")){
                pointPosition = Integer.parseInt((lvlUser.split(":")[1].trim()));
            }
            if (lvlUser.startsWith("Lvl:")) {
                lvlposition = Integer.parseInt(lvlUser.split(":")[1].trim());
                if (pointPosition < 1){
                    lvlposition = 0;
                } else if(pointPosition <= 10){
                    lvlposition = 1;
                } else if(pointPosition <= 20){
                    lvlposition = 2;
                } else if(pointPosition <= 35){
                    lvlposition = 3;
                } else if(pointPosition <= 50){
                    lvlposition = 4;
                } else if(pointPosition <= 100){
                    lvlposition = 5;
                } else{
                    lvlposition = 6;
                }
                System.out.println("Twój lvl: " + lvlposition);
            }
            lvlcontent.append(lvlUser).append(("\n"));
        }
        lvl.close();

        FileWriter save = new FileWriter(lvlcheck);
        save.write((lvlcontent.toString()));
        save.close();
    }
}

