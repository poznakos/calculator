package org.konrad.interfaces;

import java.util.Scanner;

public class Cli implements Inputable {
    private Scanner scanner;

    public Cli() {
        scanner = new Scanner(System.in);
    }

    private void validate(String mathExpression) {
        // [\d(\+\-\*\/)\d)+]
        //  a+b*c/d
    }

    @Override
    public double getInput() {
        System.out.print("Input a math expression: ");
        //takes a string as input
        String text = scanner.next();
        //reads a character from string at the specified index value
        validate(text);

        return 0;
    }
}



