package com.github.darthwotan.Profile;

import com.github.darthwotan.Konto.KontoController;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String name, address, password;
    private KontoController Konto1; 
    private int age, user_ID;
    private ProfileController controller;
    private List<KontoController> kontoList = new ArrayList<>();
    
    public Profile(String name, String address, int age, String password) {
        this.name = name;
        this.address = address;
        this.password = password;
        this.age = age;
        this.Konto1 = new KontoController();
        this.kontoList.add(Konto1);
        this.user_ID = Konto1.getUser_ID();
        this.controller = new ProfileController();
    }

    public void showProfile(){
        controller.showProfile(this);
    }

    public void newKonto(){
        kontoList.add(new KontoController(this.user_ID));
    }

    public int getAge() {
        return age;
    }

    public int getMoney(KontoController konto){
        return konto.getMoney(); 
    }
    
    public void setMoney(KontoController konto, int money){
        konto.setMoney(money);
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
