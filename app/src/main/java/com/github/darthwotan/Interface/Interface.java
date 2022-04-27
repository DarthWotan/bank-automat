package com.github.darthwotan.Interface;

import java.util.Scanner;

public class Interface { // zuständig für die Ausgabe in der Konsole
    private InterfaceController interfaceController;
    public Interface(){

    }
    public void startDemo(){ // soll am Schluss das Programm starten

    }

    public void startMenu(){
        int i; boolean running;
        Scanner input = new Scanner(System.in);
        System.out.println("Log In(1) or register(2)");
        checkInt(input);
        i = input.nextInt();


    }

    private void checkInt(Scanner scanner){ // überprüft, ob der Eingabewert ein Integer ist
        while(!scanner.hasNextInt()){
            System.out.println("Invalid answer, try again");
            scanner.next();
        }


    }

}
