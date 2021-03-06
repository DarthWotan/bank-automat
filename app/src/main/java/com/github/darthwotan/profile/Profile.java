package com.github.darthwotan.profile;

import com.github.darthwotan.konto.Konto;

import java.util.HashMap;
import java.util.Map;

public class Profile {
    private String name, address;
    private Konto konto1;
    private int age, userID;
    private ProfileController controller;
    private Map<Integer,Konto> kontoHashMap = new HashMap<>(); // um zu speichern, welche/wie viele Konten der Nutzer hat
    private UserAccount userAccount;
    
    public Profile(String name, String username, String address, int age, String password, int userID) {
        this.name = name;
        this.address = address;
        this.userAccount = new UserAccount(username, password);
        this.age = age;
        this.konto1 = new Konto(userID, createID(), true);
        this.kontoHashMap.put(konto1.getID(), konto1);
        this.userID = userID;
        this.controller = new ProfileController();
    }


    public void showProfile(){
        controller.showProfile(name, userAccount.getUsername(), address, age, userAccount.getPassword(), getNetWorth());
    } // gibt Name, Addresse, Alter, Passwort und Nutzernamen aus

    public void newKonto(){
        Konto konto = new Konto(this.userID, createID(), false);
        kontoHashMap.put(konto.getID(), konto);
    }

    public void deleteKonto(Konto konto){
        kontoHashMap.remove(konto.getID(), konto);
    }

    private int createID(){
        return kontoHashMap.size() + 1;
    }

    public Map<Integer, Konto> getKontoHashMap() {
        return kontoHashMap;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public void setAddress(String address) {
        this.address = address;
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
    public int getNetWorth(){ // Summe aller Konten
        int sum = 0;
        for(Konto i: kontoHashMap.values()){
            sum += i.getMoney();
        }
        return sum;
    }


}
