package com.github.darthwotan.console;

import com.github.darthwotan.active.ActiveUser;
import com.github.darthwotan.bank.BankController;
import com.github.darthwotan.console.mainMenu.Money;
import com.github.darthwotan.console.mainMenu.Personal;
import com.github.darthwotan.profile.Profile;
import com.github.darthwotan.profile.SaveProfiles;

import java.util.Scanner;

public class ConsoleController { // zuständig um die richtigen Befehle auszuführen
    SaveProfiles allProfiles;
    BankController bankController;
    ActiveUser activeUser;
    public ConsoleController(SaveProfiles saveProfiles){
        allProfiles = saveProfiles;
        
    }
    
    public void logInOrRegister(int input){
        if(input == 1) logIn();
        else bankController.setActiveUser(new ActiveUser(register()));
    }

    public int mainMenu(int input){ // mit return arbeiten, um das ursrprüngliche "Fenster" wieder aufzurufen
        switch (input){
            case 1 -> {
                Money money = new Money(activeUser);
                money.welcome();
                return 1;
            }
            case 2 -> {
                Personal personal = new Personal(activeUser);
                return 2;
            }
            case 3 -> {
                Scanner scanner = new Scanner(System.in);
                String i; boolean running = true;
                while(running){
                    System.out.println("Are you sure? (y/n)");
                    i = scanner.next();
                    if(i.equals("y")) {
                        running = false;
                        deleteAccount(activeUser.getCurrentProfile());
                    }
                    if(i.equals("n")) { // return
                        break;
                    }
                    else System.out.println("Invalid answer, try again");
                }
                return 3;
            }
            case 4 -> {
                if(logOut()) return 4;
            }
        }
        return 5;
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

    private Profile register(){
        return new Profile(allProfiles);

    }

    private boolean logOut(){
        Scanner scanner = new Scanner(System.in);
        String i;
        while(true) {
            System.out.println("Are you sure? (y/n)");
            i = scanner.next();
            if (i.equals("y")) {
                System.out.println("Logged out");
                return true;
            }
            if (i.equals("n")) { // return
                return false;
            } else System.out.println("Invalid answer, try again");
        }
    }

    private void deleteAccount(Profile profile){
        allProfiles.removeProfile(profile);
        System.out.println("Account deleted");
    }
}
