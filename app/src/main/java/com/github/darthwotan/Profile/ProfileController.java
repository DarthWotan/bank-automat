package com.github.darthwotan.Profile;

import com.github.darthwotan.Bank.SaveProfiles;

import java.util.Scanner;

public class ProfileController {
    SaveProfiles saveProfiles;
    public ProfileController(SaveProfiles saveProfiles) {
        this.saveProfiles = saveProfiles;
    }
    public void showProfile(Profile profile){
        System.out.println("Your username: " + profile.getUsername());
        System.out.println("Your name: " + profile.getName());
        System.out.println("Your address: " + profile.getAddress());
        System.out.println("Your age: " + profile.getAge());
        System.out.println("Your password: " + profile.getPassword());
    }

    public String createName(){
        Scanner input = new Scanner(System.in);
        System.out.println("Whats your name?");
        return input.nextLine();
    }

    public String createAddress(){
        Scanner input = new Scanner(System.in);
        System.out.println("Whats your address?");
        return input.nextLine();
    }

    public String createUsername(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is your username?");
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
}
