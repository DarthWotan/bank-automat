package com.github.darthwotan.konto;

import java.util.Random;

public class Konto {
    private int money, ID, userID;
    private String name; // steht fuer den Namen des Nutzerkontos
    private KontoController kontoController = new KontoController();

    public Konto(int userID, int ID, boolean first) { // Konstruktor, um neues Konto für bereits vorhandenes Profil zu erstellen
        this.money = 100;
        this.ID = ID;
        this.userID = userID;
        if(first){
            this.name = "Standard";
        }
        else{
            this.name = kontoController.createName();
        }

    }

    public int getID() {
        return ID;
    }


    public int getUserID() {
        return userID;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean checkIfEnoughMoney(int amount){
        return money - amount >= 0;
    }
}
