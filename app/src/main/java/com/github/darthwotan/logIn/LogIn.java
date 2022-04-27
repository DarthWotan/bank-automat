package com.github.darthwotan.logIn;

import com.github.darthwotan.profile.Profile;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
