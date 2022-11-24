package org.konrad.domain;

import org.junit.jupiter.api.Test;
import org.konrad.interfaces.InputMock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorUT {

    @Test
    public void calculateExpressions() {
        // GIVEN
        Calculator calculator = new Calculator(new InputMock("22+33*44"));

        // WHEN
        calculator.run();

    }


}
