package com.github.darthwotan.console.mainMenu;

import com.github.darthwotan.profile.ActiveUser;
import com.github.darthwotan.konto.Konto;
import com.github.darthwotan.profile.Profile;
import com.github.darthwotan.profile.SaveProfiles;

import java.util.Map;
import java.util.Scanner;

public class BalanceSettings {
    ActiveUser activeUser;
    SaveProfiles saveProfiles;
    public BalanceSettings(ActiveUser activeUser, SaveProfiles saveProfiles) {
        this.activeUser = activeUser;
        this.saveProfiles = saveProfiles;
    }
    public void welcome(){
        Scanner scanner = new Scanner(System.in);
        int i;
        while(true){
            System.out.println("""
                                    
                                          What would you like to do?
                    Deposit(1)    Draw(2)    Transfer(3)    Account Settings(4)    Back(5)
                                    (Press one of the numbers to continue)""");
            checkIfInt(scanner);
            i = scanner.nextInt();
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                if(i==5) break;
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
                try {
                    transfer();

                }
                catch (Exception e) {
                    System.out.println("Account does not exist");
                }

            }
            case 4 -> {
                int i;
                Scanner scanner = new Scanner(System.in);

                while(true){
                    System.out.println("""
                                            
                                             What would you like to do?
                            New Account(1)    Delete Account(2)    See Account(3)    Back(4)
                                       (Press one of the numbers to continue)""");
                    checkIfInt(scanner);
                    i = scanner.nextInt();
                    if (i == 1 || i == 2 || i == 3 || i == 4) {
                        if (i == 4) break;

                        accountSettings(i);
                    } else System.out.println("Invalid answer, try again");
                }

            }
        }
    }

    private void deposit(Konto konto, int amount){
        konto.setMoney(konto.getMoney() + amount);
        System.out.println("Your current balance: " +konto.getMoney()+"$");
    }

    private void draw(Konto konto, int amount) {
        if(konto.checkIfEnoughMoney(amount)){
            konto.setMoney(konto.getMoney() - amount);
            System.out.println("Your current balance: " +konto.getMoney()+"$");
        }
        else {
            System.out.println("You do not have enough money on this account′c");
        }
    }

    private void transfer(){
        Konto konto1, konto2;
        Profile profile;
        String username;
        int id;
        int amount;
        while(true){
            try {
                konto1 = askForAccount();
                break;
            } catch (Exception e) {
                System.out.println("Account does not exist");
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("To which user do you want to transfer balanceSettings? (username)");
        username = scanner.next();
        if(saveProfiles.getProfileMap().containsKey(username)){
            profile = saveProfiles.getProfileMap().get(username);

            System.out.println("Type in the ID of the account");
            checkIfInt(scanner);
            id = scanner.nextInt();
            if(profile.getKontoHashMap().containsKey(id)) {
                konto2 = profile.getKontoHashMap().get(id);
                amount = askForAmount("tansfer");
                if(konto1.checkIfEnoughMoney(amount)){
                    konto1.setMoney(konto1.getMoney() - amount);
                    konto2.setMoney(konto2.getMoney() + amount);
                    System.out.println("Successful");
                    System.out.println("Current balance: "+konto1.getMoney()+"$");
                }
            }
            else {
                System.out.println("Account does not exist");
            }
        }
        else {
            System.out.println("Profile does not exist");
        }


    }

    private void accountSettings(int i){
        Konto konto;
        switch (i){
            case 1 -> {
                activeUser.getCurrentProfile().newKonto();
            }
            case 2 -> {
                try {
                    konto = askForAccount();
                    activeUser.getCurrentProfile().deleteKonto(konto);
                } catch (Exception e) {
                    System.out.println("Account does not exist");
                }
            }
            case 3 -> {
                try {

                    for(Integer key: activeUser.getCurrentProfile().getKontoHashMap().keySet()){
                        konto = activeUser.getCurrentProfile().getKontoHashMap().get(key);
                        System.out.println(konto.getName() + ": " + konto.getMoney() + "$");
                    }
                } catch (Exception e) {
                    System.out.println("Account does not exist");
                }
            }
        }
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
