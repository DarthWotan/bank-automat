package com.github.darthwotan.Profile;

import com.github.darthwotan.Bank.SaveProfiles;
import com.github.darthwotan.Konto.Konto;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String name, address;
    private Konto Konto1;
    private int age, user_ID;
    private ProfileController controller;
    private List<Konto> kontoList = new ArrayList<>(); // um zu speichern, welche/wie viele Konten der Nutzer hat
    private UserAccount userAccount;
    private SaveProfiles saveProfiles;
    
    public Profile(String name, String username, String address, int age, String password, SaveProfiles saveProfiles) {
        this.name = name;
        this.address = address;
        this.userAccount = new UserAccount(username, password);
        this.age = age;
        this.Konto1 = new Konto();
        this.kontoList.add(Konto1);
        this.user_ID = Konto1.getUser_ID();
        this.controller = new ProfileController(saveProfiles);
        this.saveProfiles = saveProfiles;

        this.saveProfiles.addProfile(this);
    }

    public Profile(SaveProfiles saveProfiles){
        this.Konto1 = new Konto();
        this.kontoList.add(Konto1);
        this.user_ID = Konto1.getUser_ID();
        this.controller = new ProfileController(saveProfiles);
        this.saveProfiles = saveProfiles;
        createProfile();

        this.saveProfiles.addProfile(this);
        showProfile();
    }

    private void createProfile(){
        boolean running = true;
        String password, username;
        this.name = controller.createName();
        this.address = controller.createAddress();
        this.age = controller.createAge();
        password = controller.createUsername();
        username = controller.createPassword();
        userAccount = new UserAccount(username, password);

    }

    public void showProfile(){
        controller.showProfile(this);
    } // gibt Name, Addresse, Alter, Passwort und Nutzernamen aus

    public void newKonto(){
        kontoList.add(new Konto(this.user_ID));
    }

    public int getAge() {
        return age;
    }

    public int getMoney(Konto konto){
        return konto.getMoney(); 
    }
    
    public void setMoney(Konto konto, int money){
        konto.setMoney(money);
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return userAccount.getPassword();
    }
    public void setPassword(String password){
        userAccount.setPassword(password);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUsername(String username) {
        userAccount.setUsername(username);
    }

    public String getUsername() {
        return userAccount.getUsername();
    }

}
