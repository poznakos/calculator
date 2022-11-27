package org.konrad;

import org.konrad.domain.Calculator;
import org.konrad.interfaces.Cli;

public class Main {
    public static void main(String[] args) {
        Cli cli = new Cli();

        Calculator calculator = new Calculator(cli);

        calculator.calculate();
    }

    /*
    PRO

    Prosze wpisac dzialanie matematyczne:
    (2+5)*4
    + - * / ()
     */
}