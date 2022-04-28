package com.github.darthwotan.console.mainMenu;

import com.github.darthwotan.profile.ActiveUser;
import com.github.darthwotan.konto.Konto;
import com.github.darthwotan.profile.Profile;
import com.github.darthwotan.profile.SaveProfiles;

import java.util.Map;
import java.util.Optional;
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
        Optional<Konto> account;
        switch (input){
            case 1 -> {


                account = askForAccount();
                if(account.isPresent()) {
                    deposit(account.get(), askForAmount("deposit"));
                }
                else {
                    System.out.println("Account does not exist");
                }

            }
            case 2 -> {
                account = askForAccount();
                if(account.isPresent()) {
                    draw(account.get(), askForAmount("draw"));
                }
                else {
                    System.out.println("Account does not exist");
                }
            }
            case 3 -> transfer();
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
        Konto konto2;
        Optional<Konto> konto1;
        Profile profile;
        String username;
        int id;
        int amount;
        while(true){
            konto1 = askForAccount();
             if(konto1.isPresent()){
                break;
            }
            else {
                System.out.println("Account does not exist");
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("To which user do you want to transfer money? (username)");
        username = scanner.next();
        if(saveProfiles.getProfileMap().containsKey(username)){
            profile = saveProfiles.getProfileMap().get(username);

            System.out.println("Type in the ID of the account");
            checkIfInt(scanner);
            id = scanner.nextInt();
            if(profile.getKontoHashMap().containsKey(id)) {
                konto2 = profile.getKontoHashMap().get(id);
                amount = askForAmount("tansfer");
                if(konto1.get().checkIfEnoughMoney(amount)){
                    konto1.get().setMoney(konto1.get().getMoney() - amount);
                    konto2.setMoney(konto2.getMoney() + amount);
                    System.out.println("Successful");
                    System.out.println("Current balance: "+konto1.get().getMoney()+"$");
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
        Optional<Konto> konto;
        Konto account;
        switch (i){
            case 1 -> activeUser.getCurrentProfile().newKonto();
            case 2 -> {
                    konto = askForAccount();
                    if(konto.isPresent()){
                        activeUser.getCurrentProfile().deleteKonto(konto.get());
                    }
                    else {
                        System.out.println("Account does not exist");
                    }

            }
            case 3 -> {
                for(Integer key: activeUser.getCurrentProfile().getKontoHashMap().keySet()){
                    account = activeUser.getCurrentProfile().getKontoHashMap().get(key);
                    System.out.println(account.getName() + ": " + account.getMoney() + "$");
                }
            }
        }
    }

    private Optional<Konto> askForAccount() { // bessere Option gegenüber einer Exception (immer mit try und catch) oder return null (Error)
        int a;
        Map<Integer, Konto> map = activeUser.getCurrentProfile().getKontoHashMap();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose one account");
        for(Integer i: map.keySet())
            System.out.println(map.get(i).getName() + "("+i+")");
        checkIfInt(scanner);
        a = scanner.nextInt();
        if(map.containsKey(a)) return Optional.of(map.get(a));
        else return Optional.empty();
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
