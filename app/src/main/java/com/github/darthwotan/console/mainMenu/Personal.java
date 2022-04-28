package com.github.darthwotan.console.mainMenu;

import com.github.darthwotan.profile.ActiveUser;

import java.util.Scanner;

public class Personal {
    ActiveUser activeUser;
    public Personal(ActiveUser activeUser) {
        this.activeUser = activeUser;
    }

    public Personal() {

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
}
