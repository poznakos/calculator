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
        InfixData infix = new InfixData("2-3");
        // WHEN
        List<String> postfix = infix.toPostfix();
        // THEN
        Assertions.assertEquals("[2, 3, -]", postfix.toString());
    }

    @Test
    public void checkIfSameOperatorPriorityPass() {
        // GIVEN
        InfixData infix = new InfixData("2-3+5");
        // WHEN
        List<String> postfix = infix.toPostfix();
        // THEN
        Assertions.assertEquals("[2, 3, -, 5, +]", postfix.toString());
    }

    @Test
    public void checkIfWeakBeforeStrongOperatorPriorityPass() {
        // GIVEN
        InfixData infix = new InfixData("2-3*5");
        // WHEN
        List<String> postfix = infix.toPostfix();
        // THEN
        Assertions.assertEquals("[2, 3, 5, *, -]", postfix.toString());
    }

    @Test
    public void checkIfStrongBeforeWeakOperatorPriorityPass() {
        // GIVEN
        InfixData infix = new InfixData("2*3-5");
        // WHEN
        List<String> postfix = infix.toPostfix();
        // THEN
        Assertions.assertEquals("[2, 3, *, 5, -]", postfix.toString());
    }
}
