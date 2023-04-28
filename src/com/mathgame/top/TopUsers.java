package com.mathgame.top;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class TopUsers implements ITopUser{

    private String user;

    public TopUsers(){
    }

    public TopUsers (String user){
        this.user = user;
    }

    @Override
    public void userTopLvl() throws FileNotFoundException {
        File folder = new File("src\\resource\\Users\\");

        ArrayList<String> usersName = new ArrayList<>();

        File[] listOfFiles = folder.listFiles();

        for(File file : listOfFiles) {
            if(file.isFile() && file.getName().endsWith(".txt")){
                usersName.add(file.getName());
            }
        }

        Map<String, Integer > map = new HashMap<>();
        for(String fileName : usersName) {
            File lvlcheck = new File("src\\resource\\Users\\" + fileName);
            Scanner lvlScan = new Scanner(lvlcheck);

            String[] split = fileName.split(".txt");
            String keyName = split[0];
            int valueLvl = 0;

            while(lvlScan.hasNextLine()){
                String lvlChek = lvlScan.nextLine();
                if(lvlChek.startsWith("Lvl: ")){
                    valueLvl = Integer.parseInt(lvlChek.split(":")[1].trim());
                }
            }

            map.put(keyName, valueLvl);
        }

        Map<String, Integer> posortowanaMapa = map.entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println("Top users:");
        for(Map.Entry<String, Integer> el : posortowanaMapa.entrySet()){
            System.out.println("User: " + el.getKey() + ". Lvl: " + el.getValue());
        }
    }

    @Override
    public String userTopPoint() {
        return null;
    }

    @Override
    public String userTopTime() {
        return null;
    }
}




