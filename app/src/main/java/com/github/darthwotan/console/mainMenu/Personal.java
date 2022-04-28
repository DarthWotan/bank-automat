package com.github.darthwotan.console.mainMenu;

import com.github.darthwotan.profile.ActiveUser;
import com.github.darthwotan.profile.SaveProfiles;

import java.util.Random;
import java.util.Scanner;

public class Personal {
    ActiveUser activeUser;
    SaveProfiles saveProfiles;
    public Personal(ActiveUser activeUser, SaveProfiles saveProfiles) {
        this.activeUser = activeUser;
        this.saveProfiles = saveProfiles;
    }

    public Personal() {}

    public void welcome(){
        Scanner scanner = new Scanner(System.in);
        int i;
        while(true){
            System.out.println("""
                                    
                                      What would you like to do?
                    Show personal data(1)    Change personal data(2)    Back(3)
                                (Press one of the numbers to continue)""");
            checkIfInt(scanner);
            i = scanner.nextInt();
            if (i == 1 || i == 2 || i == 3) {
                if(i==3) break;
                executeCommand(i);
            }
            else System.out.println("Invalid answer, try again");

        }
    }

    private void executeCommand(int input) {
        switch (input){
            case 1 -> {
                activeUser.getCurrentProfile().showProfile();
            }
            case 2 -> {
                Scanner scanner = new Scanner(System.in);
                int i;
                while(true){
                    System.out.println("""
                                    
                                                               What would you like to do?
                    Change name(1)    Change username(2)    Change password(3)    Change address(4)    Change age(5)    Back(6)
                                                        (Press one of the numbers to continue)""");
                    checkIfInt(scanner);
                    i = scanner.nextInt();
                    if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
                        if(i==6) break;
                        selectCommand(i);
                    }
                    else System.out.println("Invalid answer, try again");
                }
            }
        }
    }

    private void selectCommand(int number){
        switch (number){
            case 1 -> {
                String newName = createName();
                activeUser.getCurrentProfile().setName(newName);
                System.out.println("Your new name: " + activeUser.getCurrentProfile().getName());

            }
            case 2 -> {
                String newUsername = createUsername();
                if(!saveProfiles.checkIfUsernameExists(newUsername)){
                    activeUser.getCurrentProfile().setUsername(newUsername);
                    System.out.println("Your new username: " + activeUser.getCurrentProfile().getUsername());
                }
                else {
                    System.out.println("Sorry, this username is already taken");
                }
            }
            case 3 -> {
                String newPassword = createPassword();
                activeUser.getCurrentProfile().setPassword(newPassword);
                System.out.println("Your new password: "+activeUser.getCurrentProfile().getPassword());
            }
            case 4 -> {
                String newAddress = createAddress();
                activeUser.getCurrentProfile().setName(newAddress);
                System.out.println("Your new address: "+activeUser.getCurrentProfile().getAddress());
            }
            case 5 -> {
                int newAge = createAge();
                activeUser.getCurrentProfile().setAge(newAge);
                System.out.println("Your new age: "+activeUser.getCurrentProfile().getAge());
            }

        }
    }
    public String createName(){
        Scanner input = new Scanner(System.in);
        System.out.println("Whats your name?");
        return input.nextLine();
    }

    public String createUsername(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is your username?");
        return input.nextLine();
    }

    public String createAddress(){
        Scanner input = new Scanner(System.in);
        System.out.println("Whats your address?");
        return input.nextLine();
    }

    public int createAge(){
        Scanner input = new Scanner(System.in);
        System.out.println("How old are you?");
        while(!input.hasNextInt()) { // solange es kein int ist, wird der naechste string weiterverwendet
            input.next();
            System.out.println("Invalid answer, try again");
        }
        return input.nextInt();
    }

    public String createPassword(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is your password?");
        return input.nextLine();
    }

    public int createUserID(){
        while (true){
            Random r = new Random();
            int id = r.nextInt(9000000) + 100000;
            if(!saveProfiles.checkIfUserIDExists(id)){
                return id;
            }
        }
    }

    public void checkIfInt(Scanner scanner){
        while(!scanner.hasNextInt()){
            System.out.println("Invalid answer, try again");
            scanner.next();
        }
    }
}
