package com.github.darthwotan.Bank;

import com.github.darthwotan.Active.ActiveUser;
import com.github.darthwotan.LogIn.LogIn;
import com.github.darthwotan.Profile.Profile;

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
        if(logIn.checkPass()) activeUser.setCurrentProfile(profile);
        else askForPassword();
    }

    public String askForPassword(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is your password?");
        return input.nextLine();
    }
}
