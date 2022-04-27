package com.github.darthwotan.console.mainMenu;

import com.github.darthwotan.active.ActiveUser;

import java.util.Scanner;

public class Money {
    ActiveUser activeUser;
    public Money(ActiveUser activeUser) {
        this.activeUser = activeUser;
    }
    public void welcome(){
        Scanner scanner = new Scanner(System.in);
        int i;
        while(true){
            System.out.println("""
                                    
                              What would you like to do?
                    Deposit(1)    Draw(2)    Transfer(3)    Back(4)
                        (Press one of the numbers to continue)""");
            checkIfInt(scanner);
            i = scanner.nextInt();
            if (i == 1 || i == 2 || i == 3) {
                executeCommand(i);
            }
            if(i==4) break;
            else System.out.println("Invalid answer, try again");
        }
    }

    private void executeCommand(int input){
        switch (input){
            case 1 -> {

            }
        }
    }

    private void deposit(int amount){

    }

    public void checkIfInt(Scanner scanner){
        while(!scanner.hasNextInt()){
            System.out.println("Invalid answer, try again");
            scanner.next();
        }
    }
}
