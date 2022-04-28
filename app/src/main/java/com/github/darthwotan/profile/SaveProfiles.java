package com.github.darthwotan.profile;

import java.util.HashMap;
import java.util.Map;

public class SaveProfiles {
    private Map<String, Profile> profileMap; // jedes Profil soll in dieser Liste gespeichert werden

    public SaveProfiles() {
        profileMap = new HashMap<>();
    }

    public void addProfile(Profile profile){
        profileMap.put(profile.getUsername(), profile);
    }

    public void removeProfile(Profile profile){
        profileMap.remove(profile.getUsername());
    }

    public Profile searchUsername(String username) throws Exception {
        if(profileMap.containsKey(username)) return profileMap.get(username); // überprüft, ob der Name bereits existiert
        else throw new Exception("Profile does not exist");
    }

    public boolean checkIfUsernameExists(String username){
        try {
            searchUsername(username);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkIfUserIDExists(int userid){
        for(String key: profileMap.keySet()){
            if(profileMap.get(key).getUserID() == userid) {
                return true;
            }
        }
        return false;
    }

    public Map<String, Profile> getProfileMap() {
        return profileMap;
    }
}
