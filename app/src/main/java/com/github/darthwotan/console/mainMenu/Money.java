package com.github.darthwotan.console.mainMenu;

import com.github.darthwotan.profile.ActiveUser;
import com.github.darthwotan.konto.Konto;

import java.util.Map;
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
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                if(i==4) break;
                executeCommand(i);
            }
            else System.out.println("Invalid answer, try again");

        }
    }

    private void executeCommand(int input){
        Konto account;
        switch (input){
            case 1 -> {

                try {
                    account = askForAccount();
                    deposit(account, askForAmount("deposit"));
                } catch (Exception e) {
                    System.out.println("Account does not exist");
                }
            }
            case 2 -> {
                try {
                    account = askForAccount();
                    draw(account, askForAmount("draw"));
                } catch (Exception e) {
                    System.out.println("Account does not exist");
                }
            }
            case 3 -> {

            }
        }
    }

    private void deposit(Konto konto, int amount){
        System.out.println("a");
    }

    private void draw(Konto konto, int amount) {

    }

    private Konto askForAccount() throws Exception { // todo: besser mit optional statt Exeption
        int a;
        Map<Integer, Konto> map = activeUser.getCurrentProfile().getKontoHashMap();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose one account");
        for(Integer i: map.keySet())
            System.out.println(map.get(i).getName() + "("+i+")");
        checkIfInt(scanner);
        a = scanner.nextInt();
        if(map.containsKey(a)) return map.get(a);
        else throw new Exception("Account does not exist");
    }

    private int askForAmount(String text){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much money do you want to " + text + "?");
        checkIfInt(scanner);
        return scanner.nextInt();
    }

    public void checkIfInt(Scanner scanner){
        while(!scanner.hasNextInt()){
            System.out.println("Invalid answer, try again");
            scanner.next();
        }
    }
}
