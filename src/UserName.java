import java.io.File;

public class UserName {
    public String user;

    public UserName(){};

    public UserName(String user){
        this.user = user;
    }

    public boolean userValidation(String user){
        File usersData = new File("src\\resource\\Users\\" + user + ".txt");
        boolean result;
        if(usersData.exists()){
            result = true;
        } else{
            result = false;
        }
        return result;
    }
}
