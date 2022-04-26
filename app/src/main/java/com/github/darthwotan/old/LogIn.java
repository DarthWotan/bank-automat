package com.github.darthwotan.old;

import java.util.Scanner;

public class LogIn {

    private Profile profile;
    private String password;
    private Account account;

    public LogIn(String pa, Account ac){
        password = pa;
        account = ac;
        profile = get_profile(get_id());
    }
    public LogIn(Account ac){
        account = ac;
        profile = get_profile(get_id());
    }

    public boolean check_pass(){
        return password.equals(this.profile.getPassword());
    }
    public int get_id(){
        System.out.println("Whats your ID? (only numbers)");
        Scanner input = new Scanner(System.in);
        while(!input.hasNextInt()) {
            input.next();
            System.out.println("Invalid answer, try again");
        }
        int id = input.nextInt();
        if(!check_existing_id(id)) {
            System.out.println("Invalid answer, try again");
            get_id();
        }
        return id;
    }

    public Profile get_profile(int id){
        return account.search_profile(id);
    }


    public boolean check_existing_id(int id){
        for(int i=0; i< account.getArray_id().size(); i++){
            if(id == account.getArray_id().get(i)) return true;
        }
        return false;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
