package org.konrad.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.konrad.interfaces.InputMock;

public class CalculatorUT {

    @Test
    public void calculate1Expressions() {
        // GIVEN
        String testData = "22+33*44";
        InputMock inputMock = new InputMock(testData);
        Calculator calculator = new Calculator(inputMock);

        // WHEN
        Double result = calculator.calculate();

        //THEN
        Assertions.assertEquals(1474.0d, result);
    }

    @Test
    public void calculate2Expressions() {
        // GIVEN
        String testData = "2 + 4 * 5 - 10 * 20";
        InputMock inputMock = new InputMock(testData);
        Calculator calculator = new Calculator(inputMock);

        // WHEN
        Double result = calculator.calculate();

        //THEN
        Assertions.assertEquals(-178.0d, result);
    }

}
