package org.konrad.domain;

import org.junit.jupiter.api.Test;
import org.konrad.interfaces.InputMock;

public class CalculatorUT {

    @Test
    public void calculateExpressions() {
        // GIVEN
        Calculator calculator = new Calculator(new InputMock("22+33*44"));

        // WHEN
        calculator.calculate();

    }


}
