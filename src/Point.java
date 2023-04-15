import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Point extends UserName{
    private int answer;
    private int correct;
    private int hardlvl;

    public Point() {
    }

    public Point(String user, int answer, int correct, int hardlvl) {
        super(user);
        this.answer = answer;
        this.correct = correct;
        this.hardlvl = hardlvl;
    }

    public void PointUp(String user, int answer, int correct, int hardlvl) throws IOException {
        File usersData = new File("src\\resource\\Users\\" + user + ".txt");
        if (usersData.exists()) {
            int currentPoints = 0;
            //Point
                int newPointValue = switch (hardlvl) {
                    case 1 -> 1;
                    case 2 -> 2;
                    case 3 -> 3;
                    default -> 0;
                };
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

                System.out.println("Dostałeś " + newPointValue + " punkty. \nMaś: " + currentPoints);
        }
    }

    public void PointDown(String user, int hardlvl) throws IOException {
        int currentPoints = 0;

        File usersData = new File("src\\resource\\Users\\" + user + ".txt");
        Scanner loadFile = new Scanner(usersData);

        int newPointValue = switch (hardlvl) {
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> 3;
            default -> 0;
        };

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
    }
}
