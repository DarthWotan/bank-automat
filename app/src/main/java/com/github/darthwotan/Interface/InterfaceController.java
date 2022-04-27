package com.github.darthwotan.Interface;

import com.github.darthwotan.Bank.BankController;
import com.github.darthwotan.Profile.Profile;
import com.github.darthwotan.Profile.SaveProfiles;

import java.util.Scanner;

public class InterfaceController { // zuständig um die richtigen Befehle auszuführen
    SaveProfiles allProfiles;
    BankController bankController;
    public InterfaceController(SaveProfiles saveProfiles){
        allProfiles = saveProfiles;
        
    }
    
    public void logInOrRegister(int input){
        if(input == 1) logIn();
        else register();
    }

    private void logIn() {
        Scanner input = new Scanner(System.in);
        String username; boolean running = true;
        while(running){
            System.out.println("What is your username?");
            username = input.nextLine();
            if(allProfiles.checkIfUsernameExists(username)) {
                running = false;
                bankController = new BankController(allProfiles.getProfileMap().get(username));
                bankController.logIn();

            }
            else System.out.println("Username does not exist, try again");
        }



    }

    private void register(){
        Profile profile = new Profile(allProfiles);

    }
}
