package com.github.darthwotan.Profile;

import java.util.Scanner;

public class ProfileController {
    public ProfileController() {

    }
    public void showProfile(String name, String username, String address, int age, String password, int networth){
        System.out.println("Your username: " + username);
        System.out.println("Your password: " + password);
        System.out.println("Your name: " + name);
        System.out.println("Your address: " + address);
        System.out.println("Your age: " + age);
        System.out.println("Your total networth: " + networth);
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
