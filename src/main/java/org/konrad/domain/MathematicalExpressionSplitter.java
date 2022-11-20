package org.konrad.domain;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class MathematicalExpressionSplitter {

    private final String REGEX_PATTERN = "\\d+|[\\+\\-\\*\\/]";

    public String[] split(String mathExpression) {
        return Pattern.compile(REGEX_PATTERN)
                .matcher(mathExpression)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
    }
}
