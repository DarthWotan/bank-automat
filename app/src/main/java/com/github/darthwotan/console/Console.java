package com.github.darthwotan.console;

import com.github.darthwotan.profile.SaveProfiles;

import java.util.Scanner;

public class Console { // zuständig für die Ausgabe in der Konsole
    private ConsoleController consoleController;
    private SaveProfiles saveProfiles;

    public Console(SaveProfiles saveProfiles){
        this.saveProfiles = saveProfiles;
        consoleController = new ConsoleController(saveProfiles);
    }

    public void startDemo(){ // soll am Schluss das Programm starten
        startMenu();
    }

    public void startMenu(){
        int i;
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Log In(1) or register(2)");
            checkInt(input);
            i = input.nextInt();
            if(i == 1 || i == 2) {
                consoleController.logInOrRegister(i);
                break;
            }
            else System.out.println("Invalid answer, try again");
        }
        mainMenu();
    }

    public void mainMenu(){
        Scanner input = new Scanner(System.in);
        int i;
        while(true){
            System.out.println("""
                                    
                                   What would you like to do?
                    Balance(1)    Personal(2)    Delete Account(3)    Log out(4)
                            (Press one of the numbers to continue)""");
            checkInt(input);
            i = input.nextInt();
            if(i == 1 || i == 2 || i == 3 || i == 4) {
                int check  = consoleController.mainMenu(i);
                if(check == 4 || check == 3) break;
            }
            else System.out.println("Invalid answer, try again");
        }
        startMenu();
    }
    private void checkInt(Scanner scanner){ // überprüft, ob der Eingabewert ein Integer ist
        while(!scanner.hasNextInt()){
            System.out.println("Invalid answer, try again");
            scanner.next();
        }
    }

}
