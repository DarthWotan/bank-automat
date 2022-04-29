package com.github.darthwotan.profile;

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
}
