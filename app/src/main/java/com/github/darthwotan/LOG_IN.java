package com.github.darthwotan;

import java.util.Scanner;

public class LOG_IN {

    private PROFILE profile;
    private String password;
    private ACCOUNT account;

    public LOG_IN(String pa, ACCOUNT ac){
        password = pa;
        account = ac;
        profile = get_profile(get_id());
    }
    public LOG_IN(ACCOUNT ac){
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

    public PROFILE get_profile(int id){
        return account.search_profile(id);
    }


    public boolean check_existing_id(int id){
        for(int i=0; i< account.getArray_id().size(); i++){
            if(id == account.getArray_id().get(i)) return true;
        }
        return false;
    }

    public PROFILE getProfile() {
        return profile;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
