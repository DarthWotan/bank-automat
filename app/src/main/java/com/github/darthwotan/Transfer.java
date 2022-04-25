package com.github.darthwotan;

public class Transfer {
    private Profile u1, u2;
    private int a;
    public Transfer(Profile user1, Profile user2, int amount) {
        u1 = user1; u2 = user2; a = amount;
    }
    public boolean transfer(){
        if(check()) {
            u1.setMoney(u1.getMoney() - a); u2.setMoney(u2.getMoney() + a);
            return true;
        }
        else {
            System.out.println("Sorry, you don't have enough money");
            return false;
        }
    }
    private boolean check(){
        return u1.getMoney() - a >= 0;
    }
}
