package com.github.darthwotan.console;

import com.github.darthwotan.console.mainMenu.BalanceSettings;
import com.github.darthwotan.console.mainMenu.Personal;
import com.github.darthwotan.logIn.LogIn;
import com.github.darthwotan.profile.ActiveUser;
import com.github.darthwotan.profile.Profile;
import com.github.darthwotan.profile.SaveProfiles;

import java.util.Scanner;

public class ConsoleController { // zuständig um die richtigen Befehle auszuführen
    SaveProfiles allProfiles;
    LogIn logIn;
    ActiveUser activeUser;

    public ConsoleController(SaveProfiles saveProfiles){
        allProfiles = saveProfiles;
        
    }
    
    public void logInOrRegister(int input){
        if(input == 1) {
            logIn();
        }
        else {
            Profile profile = register();
            activeUser = new ActiveUser(profile);
            allProfiles.addProfile(profile);
        }
    }

    private void logIn() {
        Scanner input = new Scanner(System.in);
        String username;
        while(true){
            System.out.println("What is your username?");
            username = input.nextLine();
            if(allProfiles.checkIfUsernameExists(username)) {
                break;
            }
            else System.out.println("Username does not exist, try again");
        }
        while(true){
            logIn = new LogIn(allProfiles.getProfileMap().get(username), askForPassword());
            if (logIn.checkPass()) { // überprüft, ob das eingeben Passwort korrekt ist
                activeUser = new ActiveUser(allProfiles.getProfileMap().get(username)); // wählt anschließend den momentanten Nutzer aus
                break;
            }
            else {
                System.out.println("Wrong password, try again");

            }
        }
        System.out.println("Logged in!");
    }

    private Profile register(){
        String password, username, name, address;
        Personal personal = new Personal();
        int age;
        while(true){ // falls der User einen freien Namen auswaehlt wird die loop beendet
            username = personal.createUsername();
            if(!allProfiles.checkIfUsernameExists(username)) break;
            else System.out.println("Sorry this username is already taken");

        }
        password = personal.createPassword();
        name = personal.createName();
        address = personal.createAddress();
        age = personal.createAge();

        Profile profile = new Profile(name, username, address, age, password);
        allProfiles.addProfile(profile);
        return profile;
    }

    public int mainMenu(int input){ // mit return arbeiten, um das ursrprüngliche "Fenster" wieder aufzurufen
        switch (input){
            case 1 -> {
                BalanceSettings balanceSettings = new BalanceSettings(activeUser);
                balanceSettings.welcome();
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

    public String askForPassword(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is your password?");
        return input.nextLine();
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
