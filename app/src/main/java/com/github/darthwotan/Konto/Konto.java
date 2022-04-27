package com.github.darthwotan.Konto;

import java.util.Random;

public class Konto {
    private int money, ID, user_ID;
    private String name; // steht fuer den Namen des Nutzerkontos
    private KontoController kontoController = new KontoController();

    public Konto(int userID) { // Konstruktor, um neues Konto für bereits vorhandenes Profil zu erstellen
        this.money = 100;
        this.ID = randomNumber();
        this.user_ID = userID;
        this.name = kontoController.createName();

    }
    public Konto(){ // Konstruktor, um neues Konto für ein neues Profil zu erstellen
        this.money = 100;
        this.ID = randomNumber();
        this.user_ID = randomNumber();
        name = "Standard";
    }

    public int getID() {
        return ID;
    }

    public int randomNumber(){
        Random r = new Random();
        return r.nextInt(900000) + 100000;
        // todo: keine doppelungen
    }

    public int getUser_ID() {
        return user_ID;
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
}
