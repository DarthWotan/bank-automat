package com.github.darthwotan.active;

import com.github.darthwotan.profile.Profile;

public class ActiveUser {
    private Profile currentProfile;
    public ActiveUser(Profile profile){
        currentProfile = profile;
    }

    public Profile getCurrentProfile() {
        return currentProfile;
    }

    public void setCurrentProfile(Profile currentProfile) {
        this.currentProfile = currentProfile;
    }
}
