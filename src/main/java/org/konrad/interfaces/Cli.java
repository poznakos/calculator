package org.konrad.interfaces;

import org.konrad.domain.Inputable;

import java.util.Scanner;

public class Cli implements Inputable {
    private Scanner scanner;

    public Cli() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        System.out.print("Input a math expression: ");
        //takes a string as input
        return scanner.next();
    }
}



