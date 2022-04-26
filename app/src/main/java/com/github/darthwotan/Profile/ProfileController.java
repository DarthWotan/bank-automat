package com.github.darthwotan.Profile;

public class ProfileController {
    public ProfileController() {

    }
    public void showProfile(Profile profile){
        System.out.println("Your username: " + profile.getUsername());
        System.out.println("Your name: " + profile.getName());
        System.out.println("Your address: " + profile.getAddress());
        System.out.println("Your age: " + profile.getAge());
        System.out.println("Your password: " + profile.getPassword());
    }
}
