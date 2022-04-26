package com.github.darthwotan.old;


import java.util.Scanner;

public class Demo {
    public static Port port = new Port();

    public static void main(String[] args) {
        System.out.println("""
                <<<<<<<<>>>>>>>>>
                ------------------
                
                  ATM  BY  WOTAN\040\040
                
                ------------------
                <<<<<<<<>>>>>>>>>
                
                """);

        start_menu();

    }

    public static void start_menu(){
        if(port.ask_account()){
            port.log_in();
            main_menu();
        }
        else {
            port.create_acc();
            main_menu();
        }
    }

    public static void main_menu(){ // menu number 1
        int i;
        boolean running = true;
        System.out.println("""
                
                                           What would you like to do?
                Draw (1)     Deposit(2)    Transfer money(3)    Personal data(4)    Log out(5)
                                    (Press one of the numbers to continue)""");

        Scanner input = new Scanner(System.in);
        while(running) {
            if (!input.hasNextInt()) {
                System.out.println("""
                        
                        Invalid answer, try again
                        """);
                input.next();
            }
            else {
                i = input.nextInt();
                switch (i) {
                    case 1 -> {
                        draw_menu();
                        running = false;
                    }
                    case 2 -> {
                        deposit_menu();
                        running = false;
                    }
                    case 3 -> {
                        transfer_menu();
                        running = false;
                    }
                    case 4 -> {
                        data_menu();
                        running = false;
                    }
                    case 5 -> {
                        log_out_button();
                        running = false;
                    }
                    default -> {
                        System.out.println("""
                                                                
                                Invalid answer, try again
                                """);
                        input.next();
                    }
                }
            }
        }

    }

    public static void draw_menu(){ // menu number 2 (goes back to main menu); number 1
        System.out.println("""
                
                       What would you like to do?
                         Draw money(1)     Go back(2)\040
                     (Press one of the numbers to continue)""");
        while_loop(1);




    }

    public static void deposit_menu(){ // menu number 2 (goes back to main menu); number 2
        System.out.println("""
                
                            What would you like to do?
                         Deposit money (1)     Go back(2)\040
                     (Press one of the numbers to continue)""");
        while_loop(2);
    }

    public static void transfer_menu(){ // menu number 2 (goes back to main menu); number 3
        System.out.println("""
                
                       What would you like to do?
                         Transfer money (1)     Go back(2)\040
                     (Press one of the numbers to continue)""");
        while_loop(3);

    }

    public static void while_loop(int number){
        boolean running = true;
        int i;

        Scanner input = new Scanner(System.in);
        while(running){
            check_int(input);
            i = input.nextInt();
            switch (i) {
                case 1 -> {
                    switch (number) {
                        case 1 -> {
                            boolean run = true;
                            System.out.println("""
                                                                        
                                    How much do you want to withdraw?""");
                            while (run) {
                                check_int(input);
                                int sum = input.nextInt();
                                if (!port.current_profile.getAccount().draw(sum))
                                    System.out.println("You don't have enough money to do this!");
                                else {
                                    System.out.println("Successful! You withdrew " + sum + "$");
                                    System.out.println("Your current balance: " + port.current_profile.getMoney() + "$");
                                    running = false; run = false;
                                    main_menu();
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("""
                                                                        
                                    How much do you want to deposit?""");
                           check_int(input);
                            int sum = input.nextInt();
                            port.current_profile.getAccount().deposit(sum);
                            System.out.println("Successful! You deposited " + sum + "$");
                            System.out.println("Your current balance: " + port.current_profile.getMoney() + "$");
                            running = false;
                            main_menu();
                        }
                        case 3 -> {
                            Transfer transfer;
                            System.out.println("To which user do you want to transfer money? (ID)");
                            check_int(input);
                            int id = 0;

                            Profile second_user;
                            boolean n = true;
                            while (n){
                                id = input.nextInt();
                                if(port.set_account.data.check_existing_id(id)) {
                                    n = false;
                                }
                                else System.out.println("User does not exist, try again");
                            }
                            second_user = port.set_account.data.search_profil(id);

                            while(true){
                                System.out.println("How much money do you want do send?");
                                check_int(input);
                                int sum = input.nextInt();

                                transfer = new Transfer(port.current_profile, second_user, sum);
                                if (transfer.transfer()) {
                                    System.out.println("Successful! You sent " + sum + "$ to " + second_user.getName());
                                    System.out.println("Your current balance: " + port.current_profile.getMoney() + "$");
                                    main_menu();
                                }
                            }
                        }
                    }
                    running = false;
                }
                case 2 -> {
                    running = false;
                    back_button(2);
                }
                default -> System.out.println("""
                                                    
                        Invalid answer, try again
                        """);
            }
        }

    }

    public static void data_menu(){ // menu number 2 (goes back to main menu)
        System.out.println("""
                
                                            What would you like to do?
                         See personal data(1)    Change personal data(2)    Go back(3)
                                     (Press one of the numbers to continue)""");
        Scanner input = new Scanner(System.in);
        check_int(input);
        int i;
        boolean running = true;
        while (running){
            check_int(input);
            i = input.nextInt();
            switch (i) {
                case 1 -> {
                    port.show_profile_data(port.current_profile);
                    running = false;
                    data_menu();

                }
                case 2 -> {
                    running = false;
                    change_data();


                }
                case 3 -> {
                    running = false;

                    back_button(2);

                }
            }
        }
    }

    public static void change_data(){
        System.out.println("""
                
                                       What would you like to change?
                         Name(1)    Address(2)    Age(3)    Password(4)    Go back(5)
                                    (Press one of the numbers to continue)""");
        Scanner input = new Scanner(System.in);
        check_int(input);
        int i = input.nextInt();
        switch (i){
            case 1-> {
                port.current_profile.setName(port.set_account.create_name());
                System.out.println("New name: " + port.current_profile.getName());
                data_menu();

            }
            case 2-> {
                port.current_profile.setAddress(port.set_account.create_address());
                System.out.println("New address: " + port.current_profile.getAddress());
                data_menu();
            }
            case 3-> {
                port.current_profile.setAge(port.set_account.create_age());
                System.out.println("New age: " + port.current_profile.getAge());
                data_menu();
            }
            case 4-> {
                port.current_profile.setPassword(port.set_account.create_password());
                System.out.println("New password: " + port.current_profile.getPassword());
                data_menu();
            }
            case 5-> back_button(3);
        }


    }


    public static void back_button(int menu_number){
        switch (menu_number) {
            case 1 -> log_out_button();
            case 2 -> main_menu();
            case 3 -> data_menu();
        }

    }

    public static void log_out_button(){
        int i;
        System.out.println("Are you sure? (1/2)");
        Scanner input = new Scanner(System.in);
        check_int(input);
        i = input.nextInt();
        if(i == 1) {
            System.out.println("Logged out!");
            start_menu();
        }
        if(i == 2) main_menu();
        else {
            System.out.println("Invalid answer, try again");
            log_out_button();
        }

    }
    public static void check_int(Scanner input){
        while(!input.hasNextInt()) {
            System.out.println("Invalid answer, try again");
            input.next();
        }
    }
}
