package com.github.darthwotan;

import java.util.Scanner;

public class PORT {
    public int current_id;
    public PROFILE current_profile;
    public ACCOUNT set_account = new ACCOUNT(true);
    public PORT() {
        ACCOUNT test_user = new ACCOUNT("Test", "Teststraße 13", "1234", 31);
        add_to_list(test_user.getUser(), test_user.getUser_id());
        show_profile_data(test_user.getUser());



    }

    public PROFILE create_acc() {
        ACCOUNT generator = new ACCOUNT();
        show_profile_data(generator.getUser());
        current_profile = generator.getUser();
        current_id = current_profile.getID();
        add_to_list(current_profile, current_id);
        return generator.getUser();
    }

    public void add_to_list(PROFILE profile, int id){
        set_account.data.array_id.add(id); set_account.data.array_PROFILE.add(profile);
    }

    public boolean ask_account(){ // start
        int a;
        boolean running = true;
        while (running){
            System.out.println("Log in(1) or register(2)?");
            Scanner input = new Scanner(System.in);
            while(!input.hasNextInt()){
                System.out.println("Invalid answer, try again");
                input.next();
            }
            a = input.nextInt();
            switch (a) {
                case 1 -> {
                    running = false;
                    return true;
                }
                case 2 -> {
                    running = false;
                    return false;
                }
                default -> System.out.println("Invalid answer, try again");
            }
        }
        return true;
    }

    public void show_profile_data(PROFILE acc) { // data menu
        System.out.println("Your name:" + acc.getName());
        System.out.println("Your address:" + acc.getAddress());
        System.out.println("Your age:" + acc.getAge());
        System.out.println("Your ID:" + acc.getID());
        System.out.println("Your money:" + acc.getMoney() + "$");
        System.out.println("Your password:" + acc.getPassword());
    }

    public void log_in(){
        Scanner input = new Scanner(System.in);
        LOG_IN log_in = new LOG_IN(set_account);
        System.out.println("Whats your password?");
        String pass = input.nextLine();
        log_in.setPassword(pass);
        if(log_in.check_pass()){
            System.out.println("Logged in!");
            show_profile_data(log_in.getProfile());
            current_profile = log_in.getProfile();
            current_id = current_profile.getID();

        }
        else {
            System.out.println("Wrong password!");
            log_in();
        }
    }

}