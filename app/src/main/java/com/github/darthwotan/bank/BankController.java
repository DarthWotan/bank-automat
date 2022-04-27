package com.github.darthwotan.bank;

import com.github.darthwotan.active.ActiveUser;
import com.github.darthwotan.logIn.LogIn;
import com.github.darthwotan.profile.Profile;

import java.util.Scanner;

public class BankController {
    private LogIn logIn;
    private ActiveUser activeUser;
    private Profile profile;
    public BankController(Profile profile){
        this.profile = profile;
        logIn = new LogIn(profile, askForPassword());

    }
    public void logIn(){
        boolean running = true;
        while(running){
            if (logIn.checkPass()) { // überprüft, ob das eingeben Passwort korrekt ist
                activeUser = new ActiveUser(profile); // wählt anschließend den momentanten Nutzer aus
                running = false;
            }
            else { System.out.println("Wrong password, try again");
                logIn.setPassword(askForPassword());
            }
        }
        System.out.println("Logged in!");
    }

    public ActiveUser getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(ActiveUser activeUser) {
        this.activeUser = activeUser;
    }

    public String askForPassword(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is your password?");
        return input.nextLine();
    }
}
