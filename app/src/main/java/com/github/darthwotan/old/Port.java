package com.github.darthwotan.old;

import java.util.Scanner;

public class Port {
    public int current_id;
    public ProfileOld current_profileOld;
    public AccountOld set_accountOld = new AccountOld(true);
    public Port() {
        AccountOld test_user = new AccountOld("Test", "Teststraße 13", "1234", 31);
        add_to_list(test_user.getUser(), test_user.getUser_id());
        show_profile_data(test_user.getUser());



    }

    public ProfileOld create_acc() {
        AccountOld generator = new AccountOld();
        show_profile_data(generator.getUser());
        current_profileOld = generator.getUser();
        current_id = current_profileOld.getID();
        add_to_list(current_profileOld, current_id);
        return generator.getUser();
    }

    public void add_to_list(ProfileOld profileOld, int id){
        set_accountOld.dataOld.array_id.add(id); set_accountOld.dataOld.array_ProfileOld.add(profileOld);
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

    public void show_profile_data(ProfileOld acc) { // data menu
        System.out.println("Your name:" + acc.getName());
        System.out.println("Your address:" + acc.getAddress());
        System.out.println("Your age:" + acc.getAge());
        System.out.println("Your ID:" + acc.getID());
        System.out.println("Your money:" + acc.getMoney() + "$");
        System.out.println("Your password:" + acc.getPassword());
    }

    public void log_in(){
        Scanner input = new Scanner(System.in);
        LogInOld log_in = new LogInOld(set_accountOld);
        System.out.println("Whats your password?");
        String pass = input.nextLine();
        log_in.setPassword(pass);
        if(log_in.check_pass()){
            System.out.println("Logged in!");
            show_profile_data(log_in.getProfile());
            current_profileOld = log_in.getProfile();
            current_id = current_profileOld.getID();

        }
        else {
            System.out.println("Wrong password!");
            log_in();
        }
    }

}
