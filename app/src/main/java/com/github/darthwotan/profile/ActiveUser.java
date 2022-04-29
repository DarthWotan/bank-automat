package com.github.darthwotan.profile;

import com.github.darthwotan.profile.Profile;

public class ActiveUser {
    private Profile currentProfile;
    public ActiveUser(Profile profile){
        currentProfile = profile;
    }

    public Profile getCurrentProfile() {
        return currentProfile;
    }

    public String getUsername() {
        return currentProfile.getUsername();
    }

    public void setCurrentProfile(Profile currentProfile) {
        this.currentProfile = currentProfile;
    }
}
