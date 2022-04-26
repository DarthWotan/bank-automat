package com.github.darthwotan.Bank;

import com.github.darthwotan.Profile.Profile;

public class BankMain {
    public static void main(String[] args) {
        Profile testProfile = new Profile("Testname","Test", "Tetstraße 19", 34, "1234");
        testProfile.showProfile();
    }

}
