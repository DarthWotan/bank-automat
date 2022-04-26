package com.github.darthwotan.old;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int user_id, money;
    private String name;
    private List<Integer> list_id = new ArrayList<>();

    public Bank(String n){
        user_id = create_id();
        money = 100;
        name = n;
    }

    public Bank(String n, int id, int m){
        user_id = id;
        money = m;
        name = n;
    }

    public boolean draw(int value) {
        if (this.money >= value) {
            this.money = this.money - value; return true;
        }
        else {
            return false;
        }
    }

    public void deposit(int value){
        this.money += value;
    }

    public int create_id(){
        int id = (int) (Math.random() * 1000);
        if(!check_id(id)) {
            list_id.add(id);
            return id;
        }
        else {
            create_id();
        }
        return 0;
    }

    public boolean check_id(int id){
        for (Integer integer : list_id) {
            if (id == integer) return true;
        }
        return false;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
