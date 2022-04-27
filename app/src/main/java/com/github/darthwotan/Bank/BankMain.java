package com.github.darthwotan.Bank;

import com.github.darthwotan.Interface.Interface;
import com.github.darthwotan.Profile.Profile;
import com.github.darthwotan.Profile.SaveProfiles;

public class BankMain {
    public static void main(String[] args) {
        SaveProfiles saveProfiles = new SaveProfiles();
        Interface console = new Interface(saveProfiles);
        Profile testProfile = new Profile("Testname","Test", "Tetstraße 19", 34, "1234", saveProfiles);
        testProfile.showProfile();
        if(saveProfiles.checkIfUsernameExists(testProfile.getUsername())) System.out.println("ist da");
        Profile test = new Profile(saveProfiles);
        test.showProfile();

        console.startMenu();


    }

}
