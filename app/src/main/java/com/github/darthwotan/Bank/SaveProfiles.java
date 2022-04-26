package com.github.darthwotan.Bank;

import com.github.darthwotan.Profile.Profile;

import java.util.ArrayList;
import java.util.List;

public class SaveProfiles {
    private List<Profile> profileList = new ArrayList<>(); // jedes Profil soll in dieser Liste gespeichert werden

    public SaveProfiles() {
    }

    public void addProfile(Profile profile){
        profileList.add(profile);
    }

    public void removeProfile(Profile profile){
        profileList.remove(profile);
    }
}
