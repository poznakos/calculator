package org.konrad.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathematicalExpressionValidator {
    /**
     * REGEX = REGular EXpression
     * ^(\-|\+)?\d+([\+\-\*\/]\d+)*$
     */
    private static final String REGEX_PATTERN = "^(\\-|\\+)?\\d+([\\+\\-\\*\\/]\\d+)*$";

    String validate(String possibleMathematicalExpression) {
        Pattern compiledRegexPattern = Pattern.compile(REGEX_PATTERN);
        Matcher matcher = compiledRegexPattern.matcher(possibleMathematicalExpression);

        if (matcher.matches()) {
            return possibleMathematicalExpression;
        } else {
            throw new RuntimeException("'" + possibleMathematicalExpression + "' is not a valid mathematical expression");
        }
    }
}
