package com.github.darthwotan.Konto;

import java.util.Random;

public class KontoController {
    private int money, ID, user_ID;
    public KontoController(int userID) {
        this.money = 100;
        this.ID = randomNumber();
        this.user_ID = userID;

    }
    public KontoController(){
        this.money = 100;
        this.ID = randomNumber();
        this.user_ID = randomNumber();
    }

    public int randomNumber(){
        Random r = new Random();
        return r.nextInt(900000) + 100000;
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
}
