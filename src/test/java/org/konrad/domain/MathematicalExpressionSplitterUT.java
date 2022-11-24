package org.konrad.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathematicalExpressionSplitterUT {

    private final MathematicalExpressionSplitter splitter = new MathematicalExpressionSplitter();

    @Test
    public void splitMathExpression() {
        // GIVEN
        String expression = "12+23-34*45/56";

        // WHEN
        String[] split = splitter.split(expression);

        // THEN
        Assertions.assertEquals("12", split[0]);
        Assertions.assertEquals("+", split[1]);
        Assertions.assertEquals("23", split[2]);
        Assertions.assertEquals("-", split[3]);
        Assertions.assertEquals("34", split[4]);
        Assertions.assertEquals("*", split[5]);
        Assertions.assertEquals("45", split[6]);
        Assertions.assertEquals("/", split[7]);
        Assertions.assertEquals("56", split[8]);
    }

}
