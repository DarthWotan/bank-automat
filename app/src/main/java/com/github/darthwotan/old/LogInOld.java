package com.github.darthwotan.old;

import java.util.Scanner;

public class LogInOld {

    private ProfileOld profileOld;
    private String password;
    private AccountOld accountOld;

    public LogInOld(String pa, AccountOld ac){
        password = pa;
        accountOld = ac;
        profileOld = get_profile(get_id());
    }
    public LogInOld(AccountOld ac){
        accountOld = ac;
        profileOld = get_profile(get_id());
    }

    public boolean check_pass(){
        return password.equals(this.profileOld.getPassword());
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

    public ProfileOld get_profile(int id){
        return accountOld.search_profile(id);
    }


    public boolean check_existing_id(int id){
        for(int i = 0; i< accountOld.getArray_id().size(); i++){
            if(id == accountOld.getArray_id().get(i)) return true;
        }
        return false;
    }

    public ProfileOld getProfile() {
        return profileOld;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
