package com.mathgame.mechanika;

import java.util.Properties;

public class EmailAlert {

    private String massage;

    public EmailAlert(){
    }

    public EmailAlert(String massage){
        this.massage = massage;
    }

    String host = "mail.example.com";
    String port = "587";
    String username = "timraiders17pl@gmail.com";
    String password = "13578905meN";

    String recipient = "timraiders17@gmail.com";
    String subject = "Create new user";
    String messageBody = "Nowy użytkownik został stworzony";



}
