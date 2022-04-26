package com.github.darthwotan.Profile;

import com.github.darthwotan.Konto.KontoController;

public class ProfileController {
    private String name, address, password;
    private KontoController Konto1; 
    private int age, user_ID;
    
    public ProfileController(String name, String address, int age, String password) {
        this.name = name;
        this.address = address;
        this.password = password;
        this.age = age;
        this.Konto1 = new KontoController(); 
        this.user_ID = Konto1.getUser_ID(); 
    }
    
    public int getMoney(KontoController konto){
        return konto.getMoney(); 
    }
    
    public void setMoney(KontoController konto, int money){
        konto.setMoney(money);
    }


}
