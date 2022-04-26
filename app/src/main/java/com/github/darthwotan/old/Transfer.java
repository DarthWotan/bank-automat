package com.github.darthwotan.old;

public class Transfer {
    private ProfileOld u1, u2;
    private int a;
    public Transfer(ProfileOld user1, ProfileOld user2, int amount) {
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
