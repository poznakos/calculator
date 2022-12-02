package org.konrad.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InfixUT {
    /*
    2-3   -> 2 3 -
    2-3+5 -> 2 3 - 5 +
    2-3*5 -> 2 4 5 * -
    2*3-5 -> 2 4 * 5 -
     */

    @Test
    public void checkIfSingleOperatorPass() {
        // GIVEN
        Infix infix = new Infix("2-3");
        // WHEN
        Postfix postfix = infix.toPostfix();
        // THEN
        Assertions.assertEquals("[2, 3, -]", postfix.getExpression().toString());
    }

    @Test
    public void checkIfSameOperatorPriorityPass() {
        // GIVEN
        Infix infix = new Infix("2-3+5");
        // WHEN
        Postfix postfix = infix.toPostfix();
        // THEN
        Assertions.assertEquals("[2, 3, -, 5, +]", postfix.getExpression().toString());
    }

    @Test
    public void checkIfWeakBeforeStrongOperatorPriorityPass() {
        // GIVEN
        Infix infix = new Infix("2-3*5");
        // WHEN
        Postfix postfix = infix.toPostfix();
        postfix.calculate();
        // THEN
        Assertions.assertEquals("[2, 3, 5, *, -]", postfix.getExpression().toString());
    }

    @Test
    public void checkIfStrongBeforeWeakOperatorPriorityPass() {
        // GIVEN
        Infix infix = new Infix("2*3-5");
        // WHEN
        Postfix postfix = infix.toPostfix();
        postfix.calculate();
        // THEN
        Assertions.assertEquals("[2, 3, *, 5, -]", postfix.getExpression().toString());
    }
}
