package org.konrad.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathematicalExpressionValidatorUT {

    private final MathematicalExpressionValidator validator = new MathematicalExpressionValidator();

    /*
        -11
        11
        +11
        11+21-31*41/51
        11/21*31-41+51

        -
        aa
        11+aa
        *1
        /1
    */

    @Test
    public void checkIfMinusNumberPass() {
        validator.validate("-11");
    }

    @Test
    public void checkIfNumberPass() {
        validator.validate("11");
    }

    @Test
    public void checkIfPlusNumberPass() {
        validator.validate("+11");
    }

    @Test
    public void checkIfProperMathExpressionsPass() {
        validator.validate("11+21-31*41/51");
        validator.validate("11/21*31-41+51");
    }

    @Test
    public void checkIfMinusFailed() {
        String expression = "-";

        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> validator.validate(expression)
        );

        Assertions.assertEquals(
                "'" + expression + "' is not a valid mathematical expression",
                exception.getMessage()
        );
    }

    @Test
    public void checkIfLettersFailed() {
        String expression = "aa";

        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> validator.validate(expression)
        );

        Assertions.assertEquals(
                "'" + expression + "' is not a valid mathematical expression",
                exception.getMessage()
        );
    }

    @Test
    public void checkIfExpressionWithLettersFailed() {
        String expression = "11+aa";

        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> validator.validate(expression)
        );

        Assertions.assertEquals(
                "'" + expression + "' is not a valid mathematical expression",
                exception.getMessage()
        );
    }

    @Test
    public void checkIfMultiplyNumberFailed() {
        String expression = "*11";

        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> validator.validate(expression)
        );

        Assertions.assertEquals(
                "'" + expression + "' is not a valid mathematical expression",
                exception.getMessage()
        );
    }

    @Test
    public void checkIfDivideNumberFailed() {
        String expression = "/11";

        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> validator.validate(expression)
        );

        Assertions.assertEquals(
                "'" + expression + "' is not a valid mathematical expression",
                exception.getMessage()
        );
    }
}
