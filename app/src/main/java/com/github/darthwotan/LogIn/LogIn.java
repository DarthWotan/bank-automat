package com.github.darthwotan.LogIn;

import com.github.darthwotan.Profile.Profile;

public class LogIn {
    private Profile profile;
    private String password;
    public LogIn(Profile profile, String password){
        this.profile = profile;
        this.password = password;
    }
    public boolean checkPass(){
        return profile.getPassword().equals(password);
    }
}
