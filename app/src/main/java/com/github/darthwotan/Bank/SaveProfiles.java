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

    public Profile searchUsername(String username) throws Exception {
        for(int i = 0; i < profileList.size(); i++) {
            if(profileList.get(i).getUsername().equals(username)) return profileList.get(i); // geht die Liste durch und gibt das entsprechende Profil wieder, falls es den Username gibt
        }
        throw new Exception("Profile does not exist"); // for loop durchgelaufen: -> Username wurde nicht gefunden
    }

    public boolean checkIfUsernameExists(String username){
        try {
            searchUsername(username);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
