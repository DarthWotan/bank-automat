package com.github.darthwotan.konto;

import java.util.Scanner;

public class KontoController {
    public KontoController() {

    }

    public String createName(){
        Scanner input = new Scanner(System.in);
        System.out.println("For what purpose do you need the new account?");
        return input.nextLine();
    }

}
