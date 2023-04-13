import java.io.IOException;
import java.util.Scanner;

public class RestartGame {

    public RestartGame(){
    }

    public void restart() throws IOException {
        Scanner ask = new Scanner(System.in);
        System.out.print("Chceś sprubować jeszcze raz? Y/N: ");
        String askResult = ask.nextLine();

        if (askResult.equals("Y")) {
            Licznik.main(new String[]{});
        }
    }

    public void startNewUser() throws IOException{
        Scanner ask = new Scanner(System.in);
        System.out.print("Chceś sprobować zarać? Y/N: ");
        String askResult = ask.nextLine();

        if (askResult.equals("Y")) {
            Licznik.main(new String[]{});
        }
    }
}
