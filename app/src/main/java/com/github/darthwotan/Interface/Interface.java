package com.github.darthwotan.Interface;

import com.github.darthwotan.Profile.SaveProfiles;

import java.util.Scanner;

public class Interface { // zuständig für die Ausgabe in der Konsole
    private InterfaceController interfaceController;
    private SaveProfiles saveProfiles;

    public Interface(SaveProfiles saveProfiles){
        this.saveProfiles = saveProfiles;
        interfaceController = new InterfaceController(saveProfiles);
    }

    public void startDemo(){ // soll am Schluss das Programm starten

    }

    public void startMenu(){
        int i; boolean running = true;
        Scanner input = new Scanner(System.in);
        while(running){
            System.out.println("Log In(1) or register(2)");
            checkInt(input);
            i = input.nextInt();
            if(i == 1 || i == 2) {
                running = false;
                interfaceController.logInOrRegister(i);
            }
            else System.out.println("Invalid answer, try again");
        }
    }

    public void mainMenu(){
        System.out.println("""
                
                                       What would you like to change?
                         Name(1)    Address(2)    Age(3)    Password(4)    Go back(5)
                                    (Press one of the numbers to continue)""");
    }
    private void checkInt(Scanner scanner){ // überprüft, ob der Eingabewert ein Integer ist
        while(!scanner.hasNextInt()){
            System.out.println("Invalid answer, try again");
            scanner.next();
        }
    }

}
