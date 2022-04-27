package com.github.darthwotan.bank;

import com.github.darthwotan.console.Console;
import com.github.darthwotan.profile.Profile;
import com.github.darthwotan.profile.SaveProfiles;

public class BankMain {
    public static void main(String[] args) {
        SaveProfiles saveProfiles = new SaveProfiles();
        Console console = new Console(saveProfiles);
        Profile testProfile = new Profile("Testname","Test", "Tetstraße 19", 34, "1234", saveProfiles);
        testProfile.showProfile();
        if(saveProfiles.checkIfUsernameExists(testProfile.getUsername())) System.out.println("ist da");
        Profile test = new Profile(saveProfiles);
        test.showProfile();

        console.startDemo();


    }

}
